package guide.controller;


import guide.bean.Manager;
import guide.dto.Result;
import guide.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @Explain: 登录控制器
 */
@Controller
public class LoginController {


    @Autowired
    private LoginService loginService;

    /**
     * @Explain 跳转登录页
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }


    /**
     * @param manager 登录实体对象
     * @Explain 登录操作
     * @Return
     */
    @ResponseBody
    @RequestMapping("/doLogin")
    public Object doLogin(Manager manager, HttpSession session) {
        Manager loginManager = loginService.doLogin(manager);    //根据账号密码向数据库中查找用户
        if (!session.getAttribute("img_session_code").toString().equalsIgnoreCase(manager.getVerifyCode())) {
            return Result.error("验证码不正确,请重新输入");
        } else if (Objects.isNull(loginManager)) {     //没查到用户，说明账号密码错误
            return Result.error("用户名或密码错误");
        } else {        //查到用户，往session中存入当前用户
            session.setAttribute("LOGIN_MERCHANT", loginManager);
            return Result.success();
        }
    }

    /**
     * @Explain 退出登录操作
     */
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        request.getSession().removeAttribute("LOGIN_MERCHANT");     //清除session中的用户信息
        request.getSession().invalidate();
        return new ModelAndView(new RedirectView("/toLogin"));
    }
}
