package guide.controller;

import guide.bean.Attraction;
import guide.bean.Image;
import guide.bean.Sharing;
import guide.bean.User;
import guide.dto.Result;
import guide.service.AttractionService;
import guide.service.ImageService;
import guide.service.SharingService;
import guide.service.UserService;
import guide.utils.QiniuCloudUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * @Explain: 新鲜事控制器
 */
@RestController
public class SharingController {

    @Autowired
    private SharingService sharingService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserService userService;

    @Autowired
    private AttractionService attractionService;

    /**
     * 发布新鲜事
     */
    @ResponseBody
    @RequestMapping("/publishSharing")
    public Object publishSharing(Sharing sharing) {
        sharingService.addSharing(sharing);
        return Result.success(sharing.getId());
    }

    /**
     * 上传图片
     */
    @ResponseBody
    @RequestMapping("saveImage")
    public Object saveImage(@RequestParam(value = "file", required = false) MultipartFile file,
                            @RequestParam(value = "sharingId", required = false) Integer sharingId) {
        Image image = new Image();
        image.setOrigintype("comment");
        image.setOriginid(sharingId);
        try {
            byte[] bytes = file.getBytes();
            String imageName = UUID.randomUUID().toString();
            String url = QiniuCloudUtil.put64image(bytes, imageName);
            image.setUrl(url);
        } catch (Exception e) {
            return Result.error("上传图片异常");
        }
        imageService.addImage(image);
        return Result.success();
    }


    /**
     * @param wxid 用户ID
     * @Explain 获取个人发布的新鲜事
     */
    @ResponseBody
    @RequestMapping("/getSharingList")
    public Object getSharingList(String wxid) {
        List<Sharing> sharingList = sharingService.getList(wxid);
        for (Sharing sharing : sharingList) {
            User user = userService.getOne(sharing.getWxid());
            sharing.setUser(user);  //设置发布人
            List<Image> images = imageService.getList(sharing.getId(), "comment");
            sharing.setImageList(images);
            Attraction attraction = attractionService.getOne(sharing.getAttractionid());
            sharing.setAttraction(attraction);
        }
        return Result.success(sharingList);
    }

    /**
     * @Explain 删除说说
     * @param  id 说说ID
     */
    @ResponseBody
    @RequestMapping("/delSharing")
    public Object delSharing(Integer id) {
        sharingService.delSharing(id);
        return Result.success();
    }
}
