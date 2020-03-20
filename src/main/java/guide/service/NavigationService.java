package guide.service;

import guide.bean.Navigation;
import guide.bean.NavigationExample;
import guide.mapper.NavigationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Explain: 路线处理器
 */
@Service
public class NavigationService {

    @Autowired
    private NavigationMapper navigationMapper;

    public List<Navigation> getList(Integer startid, Integer endid) {
        NavigationExample navigationExample = new NavigationExample();
        NavigationExample.Criteria criteria = navigationExample.createCriteria();
        if (startid != null) {
            criteria.andStartidEqualTo(startid);
        }
        if (endid != null) {
            criteria.andEndidEqualTo(endid);
        }
        navigationExample.setOrderByClause("id desc");
        return navigationMapper.selectByExample(navigationExample);
    }

    public Navigation getOne(Integer id) {
        return navigationMapper.selectByPrimaryKey(id);
    }

    public int delNavigation(Navigation navigation) {
        return navigationMapper.deleteByPrimaryKey(navigation.getId());
    }

    public int editNavigation(Navigation navigation) {
        return navigationMapper.updateByPrimaryKeySelective(navigation);
    }

    public int addNavigation(Navigation navigation) {
        return navigationMapper.insertSelective(navigation);
    }

    public Navigation getRoute(Navigation navigation) {
        NavigationExample navigationExample = new NavigationExample();
        navigationExample.createCriteria().andStartidEqualTo(navigation.getStartid()).andEndidEqualTo(navigation.getEndid());
        List<Navigation> navigationList = navigationMapper.selectByExample(navigationExample);
        return navigationList.size() > 0 ? navigationList.get(0) : null;
    }
}
