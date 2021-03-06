package guide.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guide.bean.*;
import guide.dto.Result;
import guide.service.*;
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
 * @Explain: 景点控制器
 */
@Controller
public class AttractionController {

    @Autowired
    private AttractionService attractionService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private PunchLogService punchLogService;

    @Autowired
    private SharingService sharingService;

    @Autowired
    private UserService userService;

    /**
     * 跳转景点管理页
     */
    @RequestMapping("/toAttraction")
    public String toAttraction() {
        return "attraction";
    }

    /**
     * @param pn    页码
     * @param size  每页的数据量
     * @param sort  过滤条件
     * @param order 分类条件
     * @Explain 获取历史订单
     */
    @ResponseBody
    @RequestMapping("/attractionList")
    public Object attractionList(@RequestParam(value = "current", defaultValue = "1") Integer pn,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size,
                                 @RequestParam(value = "sort", defaultValue = "id") String sort,
                                 @RequestParam(value = "order", defaultValue = "desc") String order,
                                 @RequestParam(value = "title", defaultValue = "%") String title) {
        PageHelper.startPage(pn, size, sort + " " + order);     //pn:页码  size：页大小
        List<Attraction> attractionList = attractionService.getList(title);
        PageInfo pageInfo = new PageInfo(attractionList, 10);
        return Result.layuiTable(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * @param id 景点ID
     * @Explain 跳转管理景点页面(添加 / 编辑)
     */
    @RequestMapping("toManageAttraction")
    public String toManageAttraction(Integer id, Model model) {
        if (id != null) {
            Attraction attraction = attractionService.getOne(id);
            List<Image> imageList = imageService.getList(id, "attraction");
            attraction.setImageList(imageList);     //设置图片列表
            if (StringUtils.isNotBlank(attraction.getLocation())) {
                String frameTop = attraction.getLocation().split(";")[0].split(":")[1].split("r")[0];
                String frameLeft = attraction.getLocation().split(";")[1].split(":")[1].split("r")[0];
                attraction.setFrameTop(frameTop);
                attraction.setFrameLeft(frameLeft);
            }
            if (StringUtils.isNotBlank(attraction.getImglocation())) {
                String pointTop = attraction.getImglocation().split(";")[0].split(":")[1].split("r")[0];
                String pointLeft = attraction.getImglocation().split(";")[1].split(":")[1].split("r")[0];
                attraction.setPointTop(pointTop);
                attraction.setPointLeft(pointLeft);
            }
            model.addAttribute("attraction", attraction);
        }
        return "manageAttraction";
    }

    /**
     * @param attraction 景点传输实体
     * @param files      图片流
     * @Explain 删除/修改/添加  景点操作
     */
    @ResponseBody
    @RequestMapping("/manageAttraction")
    public Object manageAttraction(Attraction attraction,
                                   @RequestParam(value = "files", required = false) MultipartFile[] files) {
        int res;
        if ("delete".equals(attraction.getType())) {       //删除景点操作
            res = attractionService.delAttraction(attraction);
        } else if (attraction.getId() != null) {               //编辑景点操作
            if (!ArrayUtils.isEmpty(files)) {
                doUploadImage(attraction, files);
            }
            res = attractionService.editAttraction(attraction);
        } else {                                            //添加景点操作
            res = attractionService.addAttraction(attraction);
            doUploadImage(attraction, files);
        }
        return res > 0 ? Result.success() : Result.error("操作失败");
    }


    /**
     * 跳转人流量管理页
     */
    @RequestMapping("/toTraffic")
    public String toTraffic() {
        return "traffic";
    }

    /**
     * @Explain 上传图片
     */
    private void doUploadImage(Attraction attraction, @RequestParam(value = "files", required = false) MultipartFile[] files) {
        for (MultipartFile myFile : files) {
            if (StringUtils.isNotBlank(myFile.getOriginalFilename())) {
                try {
                    byte[] bytes = myFile.getBytes();
                    String imageName = UUID.randomUUID().toString();
                    String url = QiniuCloudUtil.put64image(bytes, imageName);
                    Image image = new Image();
                    image.setOriginid(attraction.getId());
                    image.setOrigintype("attraction");
                    image.setUrl(url);
                    imageService.addImage(image);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param id 图片ID
     * @Explain 删除图片
     */
    @ResponseBody
    @RequestMapping("/doDelImage")
    public Object doDelImage(Integer id) {
        Image image = imageService.getOne(id);
        String target = image.getUrl().split("/")[3];
        QiniuCloudUtil.delete(target);
        imageService.delImage(id);
        return Result.success();
    }

    /**
     * @Explain 跳转更新人流量页面
     */
    @RequestMapping("/toUpdateTraffic")
    public String toUpdateTraffic(Integer id, Model model) {
        Attraction attraction = attractionService.getOne(id);
        model.addAttribute("attraction", attraction);
        return "manageTraffic";
    }


    /**
     * ------以下为小程序接口------
     **/

    /**
     * @Explain 获取景点列表
     */
    @ResponseBody
    @RequestMapping("/getAttractionlist")
    public Object getAttractionlist() {
        List<Attraction> attractionList = attractionService.getList("%");
        for (Attraction attraction : attractionList) {
            List<Image> imageList = imageService.getList(attraction.getId(), "attraction");
            attraction.setImageList(imageList);
            attraction.setHidden(true);
        }
        return Result.success(attractionList);
    }

    /**
     * @Explain 获取推送列表
     */
    @ResponseBody
    @RequestMapping("/getRecommendList")
    public Object getRecommendList() {
        List<Attraction> attractionList = attractionService.getRecommendList();     //推送人流量最少的前五
        for (Attraction attraction : attractionList) {
            List<Image> imageList = imageService.getList(attraction.getId(), "attraction");
            attraction.setImageList(imageList);
            attraction.setHidden(true);
        }
        return Result.success(attractionList);
    }

    /**
     * @Explain 获取打卡点列表
     */
    @ResponseBody
    @RequestMapping("/getPunchlist")
    public Object getPunchlist(String wxid) {
        List<Attraction> attractionList = attractionService.getList("%");
        for (Attraction attraction : attractionList) {
            List<Image> imageList = imageService.getList(attraction.getId(), "attraction");
            PunchLog punchLog = punchLogService.getOne(attraction.getId(), wxid);
            if (punchLog != null) {
                attraction.setPunch(true);
            } else {
                attraction.setPunch(false);
            }
            attraction.setImageList(imageList);
            attraction.setHidden(true);
        }
        return Result.success(attractionList);
    }

    /**
     * @Explain 获取景点详情
     * @param  id 景点ID
     * @Return
     */
    @ResponseBody
    @RequestMapping("/getAttractionDetail")
    public Object getAttractionDetail(Integer id, String wxId) {
        Attraction attraction = attractionService.getOne(id);
        Favorite favorite = favoriteService.getOne(attraction.getId(), wxId);
        if (favorite != null) {
            attraction.setLike(true);   //如果收藏表里面有记录，说明收藏过这个景点
        } else {
            attraction.setLike(false);  //否则没收藏过
        }
        List<Image> imageList = imageService.getList(attraction.getId(), "attraction");
        List<Sharing> sharingList = sharingService.getList(attraction.getId());
        for (Sharing sharing : sharingList) {
            User user = userService.getOne(sharing.getWxid());
            sharing.setUser(user);  //设置发布人
            List<Image> images = imageService.getList(sharing.getId(), "comment");
            sharing.setImageList(images);
        }
        attraction.setSharingList(sharingList);
        attraction.setImageList(imageList);
        return Result.success(attraction);
    }

    /**
     * @Explain 打卡
     */
    @ResponseBody
    @RequestMapping("/doPunch")
    public Object doPunch(PunchLog punchLog) {
        punchLogService.addPunchLog(punchLog);      //添加打卡记录
        Attraction attraction = attractionService.getOne(punchLog.getAttractionid());
        attraction.setPunchnum(attraction.getPunchnum() + 1);       //打卡数+1
        attractionService.editAttraction(attraction);
        return Result.success();
    }
}