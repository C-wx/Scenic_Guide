package guide.controller;

import guide.bean.User;
import guide.dto.Result;
import guide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Explain: 用户登录控制器
 */
@Controller
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * @param user
     * @Explain 如果用户为首次登录, 则往数据库插入用户信息
     */
    @ResponseBody
    @RequestMapping("addUser")
    public Object addUser(User user) {
        User tempUser = userService.getOne(user);
        if (null == tempUser) {       //没有查到用户 说明是首次登录
            userService.addUser(user);
        } else {
            user.setId(tempUser.getId());
            userService.editUser(user);
        }
        return Result.success();
    }

}
