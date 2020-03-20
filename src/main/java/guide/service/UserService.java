package guide.service;

import guide.bean.User;
import guide.bean.UserExample;
import guide.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Explain: 用户处理器
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getOne(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andWxidEqualTo(user.getWxid());
        List<User> userList = userMapper.selectByExample(userExample);
        return userList.size() > 0 ? userList.get(0) : null;
    }

    public void addUser(User user) {
        userMapper.insertSelective(user);
    }

    public void editUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    public User getOne(String wxid) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andWxidEqualTo(wxid);
        List<User> userList = userMapper.selectByExample(userExample);
        return userList.size() > 0 ? userList.get(0) : null;
    }
}
