package guide.service;

import guide.bean.Manager;
import guide.bean.ManagerExample;
import guide.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Explain: 登录处理器
 */
@Service
public class LoginService {

    @Autowired
    private ManagerMapper managerMapper;


    public Manager doLogin(Manager manager) {
        ManagerExample managerExample = new ManagerExample();
        managerExample.createCriteria().andAccountEqualTo(manager.getAccount()).andPasswordEqualTo(manager.getPassword());
        List<Manager> managerList = managerMapper.selectByExample(managerExample);
        return managerList.size() > 0 ? managerList.get(0) : null;
    }
}
