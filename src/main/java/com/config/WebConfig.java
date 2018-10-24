package com.config;


import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;


import org.springframework.web.WebApplicationInitializer;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;


public class WebConfig  implements WebApplicationInitializer  {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx= new AnnotationConfigWebApplicationContext();
		ctx.setServletContext(servletContext);
		ctx.register(AppConfig.class);
		
		Dynamic serv = servletContext.addServlet("MyApp", new DispatcherServlet(ctx));
		serv.addMapping("/");
		serv.setLoadOnStartup(1);
	
//		FilterRegistration.Dynamic filter=servletContext.addFilter("urlFilter", new DelegatingFilterProxy("urlFilter"));
//		filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/checkout");
	}


}
