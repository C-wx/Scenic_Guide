package guide.service;

import guide.bean.Sharing;
import guide.bean.SharingExample;
import guide.mapper.SharingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Explain: 说说处理器
 */
@Service
public class SharingService {

    @Autowired
    private SharingMapper sharingMapper;

    public List<Sharing> getList(Integer id) {
        SharingExample sharingExample = new SharingExample();
        sharingExample.createCriteria().andAttractionidEqualTo(id);
        sharingExample.setOrderByClause("id desc");
        return sharingMapper.selectByExample(sharingExample);
    }

    public void addSharing(Sharing sharing) {
        sharingMapper.insertSelective(sharing);
    }

    public List<Sharing> getList(String wxid) {
        SharingExample sharingExample = new SharingExample();
        sharingExample.createCriteria().andWxidEqualTo(wxid);
        sharingExample.setOrderByClause("id desc");
        return sharingMapper.selectByExample(sharingExample);
    }

    public void delSharing(Integer id) {
        sharingMapper.deleteByPrimaryKey(id);
    }
}
