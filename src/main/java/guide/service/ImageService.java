package guide.service;

import guide.bean.Image;
import guide.bean.ImageExample;
import guide.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Explain: 图片处理器
 */
@Service
public class ImageService {

    @Autowired
    private ImageMapper imageMapper;

    public List<Image> getList(Integer id) {
        ImageExample imageExample = new ImageExample();
        imageExample.createCriteria().andAttracttionidEqualTo(id);
        return imageMapper.selectByExample(imageExample);
    }

    public void addImage(Image image) {
        imageMapper.insertSelective(image);
    }

    public Image getOne(Integer id) {
        return imageMapper.selectByPrimaryKey(id);
    }

    public void delImage(Integer id) {
        imageMapper.deleteByPrimaryKey(id);
    }
}
