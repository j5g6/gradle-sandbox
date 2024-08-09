package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
public class GreetingAspect {

    @Pointcut("execution(* javax.servlet.http.HttpServlet.service(..))")
    public void servletService() {}

    @After("servletService() && args(request, response)")
    public void afterServletService(JoinPoint joinPoint, HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String name = request.getParameter("name");
        if (name != null) {
            response.getWriter().println("Hello, " + name + "!");
        }
    }
}
