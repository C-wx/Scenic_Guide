package guide.service;

import guide.bean.Favorite;
import guide.bean.FavoriteExample;
import guide.mapper.FavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Explain: 收藏处理器
 */
@Service
public class FavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;

    public Favorite getOne(Integer id, String wxId) {
        FavoriteExample favoriteExample = new FavoriteExample();
        favoriteExample.createCriteria().andAttractionidEqualTo(id).andWxidEqualTo(wxId);
        List<Favorite> favoriteList = favoriteMapper.selectByExample(favoriteExample);
        return favoriteList.size() > 0 ? favoriteList.get(0) : null;
    }

    public int addFavorite(Favorite favorite) {
        return favoriteMapper.insertSelective(favorite);
    }

    public int delFavorite(Favorite favorite) {
        FavoriteExample favoriteExample = new FavoriteExample();
        favoriteExample.createCriteria().andWxidEqualTo(favorite.getWxid()).andAttractionidEqualTo(favorite.getAttractionid());
        return favoriteMapper.deleteByExample(favoriteExample);
    }

    public List<Favorite> getList(String wxid) {
        FavoriteExample favoriteExample = new FavoriteExample();
        favoriteExample.createCriteria().andWxidEqualTo(wxid);
        return favoriteMapper.selectByExample(favoriteExample);
    }
}
