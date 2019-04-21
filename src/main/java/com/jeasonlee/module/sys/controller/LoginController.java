package com.jeasonlee.module.sys.controller;

import com.jeasonlee.module.sys.entity.User;
import com.jeasonlee.module.sys.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

//ok
@Controller
@RequestMapping(value = {"/user"})
public class LoginController {

    /**
     * 注入service
     */
    @Autowired
    private UserLoginService userLoginService;

    /**
     * 跳转到用户登录页面
     *
     * @return 登录页面
     */
    @RequestMapping(value = {"/loginHtml"})
    public String loginHtml() {
        return "userLogin";
    }

    /**
     * 跳转到用户注册页面
     *
     * @return 注册页面
     */
    @RequestMapping(value = {"/registerpage"})
    public String registerpage() {
        return "register";
    }

    /**
     * 获取用户名与密码，用户登录
     *
     * @return 登录成功页面
     */
    @RequestMapping(value = {"/userLogin"})
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {

        User user = userLoginService.userLogin(username, password);

        if (user != null) {                                                  //登录成功
            request.getSession().setAttribute("session_user", user);     //将用户信息放入session
            return "index";
        }
        return "loginError";
    }


    /**
     * 注册新用户
     *
     * @return 注册结果
     */
    @ResponseBody
    @RequestMapping(value = {"/uregister"})
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("password2") String password2,
                          @RequestParam("age") int age, HttpServletResponse response) {
        if (password == "" || password2 == "") {
            this.setRespMsg("密码不能为空", response);
            return null;
        }
        if (!password.equals(password2)) {
            this.setRespMsg("两次密码不相同，注册失败！", response);
            return null;
        }
        int res = userLoginService.addUser(username, password, age);
        if (res == 0) {
            this.setRespMsg("注册失败！！", response);
        } else {
            this.setRespMsg("注册成功！！", response);
        }
        return null;

    }

    public void setRespMsg(String msg, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            out.print("<script>alert('" + msg + "');history.go(-1);</script>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
