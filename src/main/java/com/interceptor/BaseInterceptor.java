package com.interceptor;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.entity.*;
import com.Service.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       System.out.println("-----------进入controller");

       IDemoService ds=(IDemoService)(getBean("demoService",request.getServletContext()));

       System.out.println("demoService="+ds);
        return true;
    }

    private Object getBean(String name, ServletContext ctx)throws Exception{
        ApplicationContext ct=WebApplicationContextUtils.getRequiredWebApplicationContext(ctx);
        return ct.getBean(name);

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("-----------出controller");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("-----------出view");
    }
}
