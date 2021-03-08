package org.example.crm.workbench.web.controller;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ActivityController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到市场活动控制器");
        String path = request.getServletPath();
        if("/workbench/activity/xxx.do".equals(path)){
            System.out.println("欢迎进入/workbench/activity/xxx.do");

        }else if("/workbench/activity/xx.do".equals(path)){
            System.out.println("欢迎进入/workbench/activity/xx.do");
        }
    }




}
