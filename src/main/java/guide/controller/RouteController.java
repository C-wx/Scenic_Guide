package guide.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guide.bean.Attraction;
import guide.bean.Navigation;
import guide.dto.Result;
import guide.service.AttractionService;
import guide.service.NavigationService;
import guide.utils.QiniuCloudUtil;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * @Explain: 路线控制器
 */
@Controller
public class RouteController {


    @Autowired
    private AttractionService attractionService;

    @Autowired
    private NavigationService navigationService;

    /**
     * 跳转景点管理页
     */
    @RequestMapping("/toRoute")
    public String toAttraction(Model model) {
        List<Attraction> attractionList = attractionService.getList("%");
        model.addAttribute("attractionList", attractionList);
        return "route";
    }

    /**
     * @param pn    页码
     * @param size  每页的数据量
     * @param sort  过滤条件
     * @param order 分类条件
     * @Explain 获取历史订单
     */
    @ResponseBody
    @RequestMapping("/routeList")
    public Object routeList(@RequestParam(value = "current", defaultValue = "1") Integer pn,
                            @RequestParam(value = "size", defaultValue = "10") Integer size,
                            @RequestParam(value = "sort", defaultValue = "id") String sort,
                            @RequestParam(value = "order", defaultValue = "desc") String order,
                            @RequestParam(value = "startid", required = false) Integer startid,
                            @RequestParam(value = "endid", required = false) Integer endid) {
        PageHelper.startPage(pn, size, sort + " " + order);     //pn:页码  size：页大小
        List<Navigation> navigationList = navigationService.getList(startid, endid);
        for (Navigation navigation : navigationList) {
            Attraction startAttraction = attractionService.getOne(navigation.getStartid());
            navigation.setStartName(startAttraction.getTitle());     //起点名称
            Attraction endAttraction = attractionService.getOne(navigation.getEndid());
            navigation.setEndName(endAttraction.getTitle());         //终点名称
        }
        PageInfo pageInfo = new PageInfo(navigationList, 10);
        return Result.layuiTable(pageInfo.getTotal(), pageInfo.getList());
    }


    @RequestMapping("/toRouteManage")
    public String toRouteManage(Integer id, Model model) {
        if (id != null) {
            Navigation navigation = navigationService.getOne(id);
            model.addAttribute("navigation", navigation);
        }
        //查出景点列表
        List<Attraction> attractionList = attractionService.getList("%");
        model.addAttribute("attractionList", attractionList);
        return "manageRoute";
    }

    /**
     * @param navigation 景点传输实体
     * @param files      图片流
     * @Explain 删除/修改/添加  景点操作
     */
    @ResponseBody
    @RequestMapping("/manageRoute")
    public Object manageRoute(Navigation navigation,
                              @RequestParam(value = "files", required = false) MultipartFile[] files) {
        int res;
        if (!ArrayUtils.isEmpty(files)) {
            for (MultipartFile myFile : files) {
                if (StringUtils.isNotBlank(myFile.getOriginalFilename())) {
                    try {
                        byte[] bytes = myFile.getBytes();
                        String imageName = UUID.randomUUID().toString();
                        String url = QiniuCloudUtil.put64image(bytes, imageName);
                        navigation.setImg(url);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if ("delete".equals(navigation.getType())) {       //删除路线操作
            res = navigationService.delNavigation(navigation);
        } else if (navigation.getId() != null) {               //编辑路线操作
            res = navigationService.editNavigation(navigation);
        } else {                                            //添加路线操作
            res = navigationService.addNavigation(navigation);
        }
        return res > 0 ? Result.success() : Result.error("操作失败");
    }


    /**
     * ------以下为小程序接口------
     **/

    @ResponseBody
    @RequestMapping("/getRoute")
    public Object getRoute(Navigation navigation) {
        Navigation route = navigationService.getRoute(navigation);
        if (route != null) {
            return Result.success(route);
        } else {
            return Result.error("暂未查到该路线");
        }
    }

}
