package guide.controller;

import com.alibaba.fastjson.JSON;
import guide.bean.Attraction;
import guide.bean.Favorite;
import guide.bean.Image;
import guide.dto.Result;
import guide.service.AttractionService;
import guide.service.FavoriteService;
import guide.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Explain: 收藏控制器
 */
@RestController
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private AttractionService attractionService;

    @Autowired
    private ImageService imageService;

    @RequestMapping("/doLike")
    public Object doLike(String wxid, String attraction) {
        int res;
        Favorite favorite = new Favorite();
        Attraction tempAttraction = JSON.parseObject(attraction, Attraction.class);
        favorite.setAttractionid(tempAttraction.getId());
        favorite.setWxid(wxid);
        if (tempAttraction.getLike()) {
            res = favoriteService.addFavorite(favorite);
        } else {
            res = favoriteService.delFavorite(favorite);
        }
        return res > 0 ? Result.success() : Result.error();
    }

    @ResponseBody
    @RequestMapping("/getFavoriteList")
    public Object getFavoriteList(String wxid) {
        List<Favorite> favoriteList = favoriteService.getList(wxid);
        for (Favorite favorite : favoriteList) {
            Attraction attraction = attractionService.getOne(favorite.getAttractionid());
            List<Image> imageList = imageService.getList(attraction.getId(), "attraction");
            attraction.setImageList(imageList);
            favorite.setAttraction(attraction);
        }
        return Result.success(favoriteList);
    }

}
