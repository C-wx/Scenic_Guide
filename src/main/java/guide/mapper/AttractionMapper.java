package guide.mapper;

import guide.bean.Attraction;
import guide.bean.AttractionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttractionMapper {
    long countByExample(AttractionExample example);

    int deleteByExample(AttractionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Attraction record);

    int insertSelective(Attraction record);

    List<Attraction> selectByExample(AttractionExample example);

    Attraction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Attraction record, @Param("example") AttractionExample example);

    int updateByExample(@Param("record") Attraction record, @Param("example") AttractionExample example);

    int updateByPrimaryKeySelective(Attraction record);

    int updateByPrimaryKey(Attraction record);

    List<Attraction> getRecommendList();
}