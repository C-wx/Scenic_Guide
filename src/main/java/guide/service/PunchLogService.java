package guide.service;

import guide.bean.PunchLog;
import guide.bean.PunchLogExample;
import guide.mapper.PunchLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Explain: 打卡日志处理器
 */
@Service
public class PunchLogService {

    @Autowired
    private PunchLogMapper punchLogMapper;


    public PunchLog getOne(Integer id, String wxid) {
        PunchLogExample punchLogExample = new PunchLogExample();
        punchLogExample.createCriteria().andAttractionidEqualTo(id).andWxidEqualTo(wxid);
        List<PunchLog> punchLogList = punchLogMapper.selectByExample(punchLogExample);
        return punchLogList.size() > 0 ? punchLogList.get(0) : null;
    }

    public void addPunchLog(PunchLog punchLog) {
        punchLogMapper.insertSelective(punchLog);
    }
}
