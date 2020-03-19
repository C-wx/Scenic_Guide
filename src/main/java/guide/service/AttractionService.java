package guide.service;

import guide.bean.Attraction;
import guide.bean.AttractionExample;
import guide.bean.Navigation;
import guide.mapper.AttractionMapper;
import guide.mapper.NavigationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Explain:
 * @Author: Cbuc
 * @Version: 1.0
 * @Date: 2020/3/18 0018
 */
@Service
public class AttractionService {

    @Autowired
    private AttractionMapper attractionMapper;


    public List<Attraction> getList() {
        AttractionExample attractionExample = new AttractionExample();
        attractionExample.setOrderByClause("ID DESC");
        return attractionMapper.selectByExample(attractionExample);
    }

    public Attraction getOne(Integer id) {
        return attractionMapper.selectByPrimaryKey(id);
    }

    public int delAttraction(Attraction attraction) {
        return attractionMapper.deleteByPrimaryKey(attraction.getId());
    }

    public int editAttraction(Attraction attraction) {
        return attractionMapper.updateByPrimaryKeySelective(attraction);
    }

    public int addAttraction(Attraction attraction) {
        return attractionMapper.insertSelective(attraction);
    }

}
