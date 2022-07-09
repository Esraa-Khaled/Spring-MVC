package com.example.mvc.springmvc.lc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Registration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class LoveCalculatorInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

//        System.out.println("debuggggg");
//        XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
//        webApplicationContext.setConfigLocation("classpath:application-config.xml");

        AnnotationConfigWebApplicationContext webApplicationContext =new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(LoveCalculatorInitializer.class);

        //create a dispatcher servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

        //register dispatcher servlet with servlet context
        ServletRegistration.Dynamic myCustomServlet = servletContext.addServlet("myDispatcher123",dispatcherServlet);

        //configure load on deployment startup
        myCustomServlet.setLoadOnStartup(1);
        myCustomServlet.addMapping("/mywebsite.com/*");

        //
    }
}
