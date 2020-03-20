package guide.mapper;

import guide.bean.Sharing;
import guide.bean.SharingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SharingMapper {
    long countByExample(SharingExample example);

    int deleteByExample(SharingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sharing record);

    int insertSelective(Sharing record);

    List<Sharing> selectByExample(SharingExample example);

    Sharing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sharing record, @Param("example") SharingExample example);

    int updateByExample(@Param("record") Sharing record, @Param("example") SharingExample example);

    int updateByPrimaryKeySelective(Sharing record);

    int updateByPrimaryKey(Sharing record);
}