package com.config;


import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;





//@Import({HibernateConfig.class,DatabaseConfig.class})


@Import({DatabaseConfig.class})
@Configuration
@EnableWebMvc
@ComponentScan("com")
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class AppConfig  implements WebMvcConfigurer {
	
	@Bean
	public ViewResolver getResolver() {
		InternalResourceViewResolver vr= new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	public HandlerMapping getHandler() {
		RequestMappingHandlerMapping handler= new RequestMappingHandlerMapping();
		handler.setOrder(Ordered.LOWEST_PRECEDENCE);
		return handler;
	}
	
	@Bean("localeChangeInterceptor")
	public LocaleChangeInterceptor getLocaleChangeInterceptor() {
		LocaleChangeInterceptor interceptor= new LocaleChangeInterceptor();
		interceptor.setParamName("language");
		System.out.println("locale");
		return interceptor;
	}
	
	@Bean("localeResolver")
	public LocaleResolver getLocaleResolver() {
		SessionLocaleResolver resolver= new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.ENGLISH);
		return resolver;
	}
	
	@Bean("messageSource")
	public ResourceBundleMessageSource getMessageSource() {
		ResourceBundleMessageSource src= new ResourceBundleMessageSource();
		src.addBasenames("locale");
		src.setDefaultEncoding("UTF-8");
		return src;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getLocaleChangeInterceptor());
	}
	
	@Bean("propertySource")
	@Profile("!test")
	public static PropertySourcesPlaceholderConfigurer getDevDatabasePropertry() {
		PropertySourcesPlaceholderConfigurer pc = new PropertySourcesPlaceholderConfigurer();
		pc.setLocation(new ClassPathResource("db.properties"));
		return pc;
	}
	
	
	@Bean("propertySource")
	@Profile("test")
	public static PropertySourcesPlaceholderConfigurer getTestDatabasePropertry() {
		PropertySourcesPlaceholderConfigurer pc = new PropertySourcesPlaceholderConfigurer();
		pc.setLocation(new ClassPathResource("db_test.properties"));
		return pc;
	}
	
	@Bean("propertySource")
	@Profile("prod")
	public static PropertySourcesPlaceholderConfigurer getProdDatabasePropertry() {
		PropertySourcesPlaceholderConfigurer pc = new PropertySourcesPlaceholderConfigurer();
		pc.setLocation(new ClassPathResource("db_prod.properties"));
		return pc;
	}
	
	
	@Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("home");
	    
	  }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/views/images/").setCacheControl(CacheControl.maxAge(20, TimeUnit.MINUTES));
		registry.addResourceHandler("/icon/**").addResourceLocations("/WEB-INF/views/icon.ico/").setCacheControl(CacheControl.maxAge(20, TimeUnit.MINUTES));
		registry.addResourceHandler("/JS/**").addResourceLocations("/WEB-INF/views/JS/").setCacheControl(CacheControl.maxAge(0, TimeUnit.MINUTES));;
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/views/css/").setCacheControl(CacheControl.maxAge(0, TimeUnit.MINUTES));;
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		//registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}
	

}
