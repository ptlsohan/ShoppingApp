package com.config;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx= new AnnotationConfigWebApplicationContext();
		ctx.setServletContext(servletContext);
		ctx.register(AppConfig.class);
		
		Dynamic serv = servletContext.addServlet("MyApp", new DispatcherServlet(ctx));
		serv.addMapping("/");
		serv.setLoadOnStartup(1);
		
	}


}
