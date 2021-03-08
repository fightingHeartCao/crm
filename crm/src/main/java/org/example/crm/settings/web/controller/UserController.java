package org.example.crm.settings.web.controller;

import org.example.crm.settings.domain.User;
import org.example.crm.settings.service.UserService;
import org.example.crm.settings.service.impl.UserServiceImpl;
import org.example.crm.utils.MD5Util;
import org.example.crm.utils.PrintJson;
import org.example.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到用户控制器");
        String path = request.getServletPath();
        if("/settings/user/login.do".equals(path)){
            System.out.println("欢迎进入/settings/user/login.do");
            login(request, response);
        }else if("/settings/user/xx.do".equals(path)){
            System.out.println("欢迎进入/settings/user/xx.do");
        }
    }

    private static void login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入到登陆验证操作");
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        //将密码的明文形式转换为MD5的密文形式
        loginPwd = MD5Util.getMD5(loginPwd);
        String ip = request.getRemoteAddr();
        System.out.println("ip---------------:" + ip);
        //获取代理类对象
        UserService userService = (UserService) ServiceFactory.getService(new UserServiceImpl());
        try {
            User user = userService.login(loginAct, loginPwd, ip);
            request.getSession().setAttribute("user", user);
            //如果程序执行到此处，说明业务层没有为controller抛出任何异常
            PrintJson.printJsonFlag(response, true);  //工具类方法，将成功登陆信息封装到json
        }catch (Exception e){
//            e.printStackTrace();
            //一旦执行catch块，说明登陆失败
            String msg = e.getMessage();
            Map<String, Object> map = new HashMap<>();
            map.put("success", false);
            map.put("msg", msg);
            PrintJson.printJsonObj(response, map);
        }


    }


}
