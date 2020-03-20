package guide.mapper;

import guide.bean.PunchLog;
import guide.bean.PunchLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PunchLogMapper {
    long countByExample(PunchLogExample example);

    int deleteByExample(PunchLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PunchLog record);

    int insertSelective(PunchLog record);

    List<PunchLog> selectByExample(PunchLogExample example);

    PunchLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PunchLog record, @Param("example") PunchLogExample example);

    int updateByExample(@Param("record") PunchLog record, @Param("example") PunchLogExample example);

    int updateByPrimaryKeySelective(PunchLog record);

    int updateByPrimaryKey(PunchLog record);
}