package org.example.crm.web.filter;

import org.example.crm.settings.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入到验证有没有登陆过的过滤器");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String path = request.getServletPath();
//        System.out.println(path);
        //自动放行的请求
        if("/login.jsp".equals(path) || "/settings/user/login.do".equals(path)){
            filterChain.doFilter(req, resp);
        }else{
            //其他资源必须验证有没有登陆过
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            if(user != null){
                filterChain.doFilter(req, resp);
            }else{
                //重定向到登录页
                //在项目开发中，对于路径，不论操作的是前端还是后端，应该一律使用绝对路径
                //转发：
                //使用一种特殊的绝对路径，这种绝对路径不加/项目名，为内部路径  /login.jsp
                //重定向：
                //使用传统的绝对路径写法，前面以/项目名开头，后面跟具体的资源路径  /crm/login.jsp
                response.sendRedirect(request.getContextPath() + "/login.jsp");

            }
        }




    }
}
