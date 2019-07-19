package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class MainFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 访问的地址：http://localhost:8080/loginServlet?usernmae=aaa
        // url: http://localhost:8080/loginServlet?usernmae=aaa
        // uri: /loginServlet?usernmae=aaa
        HttpServletRequest req =(HttpServletRequest) servletRequest;
        StringBuffer requestURL = req.getRequestURL();
        String requestURI = req.getRequestURI();
//        System.out.println("url:"+requestURL.toString());
//        System.out.println("uri:"+requestURI);
        //判断请求的url是否以"loginServlet"开头
        System.out.println("sql:"+requestURI.toString());
        if(requestURI.startsWith("/index.jsp")||requestURI.startsWith("/register.jsp")
                ||requestURI.startsWith("ShowAllGoodsServlet")||requestURI.startsWith("/registerservlet")
                ||requestURI.startsWith("/verification")){//true
            filterChain.doFilter(servletRequest, servletResponse);}
            else {
            HttpSession hs = req.getSession();
            if(hs.getAttribute("user")==null){
                HttpServletResponse resp = (HttpServletResponse) servletResponse;
                PrintWriter out = resp.getWriter();
                out.write("<script language='javascript'>alert('请先登陆！')</script>");
                resp.sendRedirect("index.jsp");
            }
            else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
