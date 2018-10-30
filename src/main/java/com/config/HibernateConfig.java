package com.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.dto.Address;
import com.dto.Book;
import com.dto.Cart;
import com.dto.CreditCard;
import com.dto.Fashion;
import com.dto.Laptop;
import com.dto.Mobile;
import com.dto.Order;
import com.dto.Product;
import com.dto.User;
import com.dto.UserProfile;

@Configuration("hibernateConfig")
public class HibernateConfig {
	@Value("${DB_URL}")
	private String url;
	@Value("${DB_User}")
	private String username;
	@Value("${DB_Password}")
	private String password;
	@Value("${DB_Driver}")
	private String driverName;
	@Value("${DB_Hbm2ddl.auto}")
	private String hbm2ddl;
	@Value("${DB_Dialect}")
	private String dialect;
	@Value("${DB_Show_url}")
	private String show_url;
	@Value("${DB_Cache}")
	private String cache;
	@Value("${DB_CacheRegion}")
	private String cacheRegion;
	
	
	@Bean
	public SessionFactory getSessionFactory() {
		
		org.hibernate.cfg.Configuration cfg=new org.hibernate.cfg.Configuration();
		
			cfg.addAnnotatedClass(User.class);
			cfg.addAnnotatedClass(UserProfile.class);
			cfg.addAnnotatedClass(Address.class);
			cfg.addAnnotatedClass(Product.class);
			cfg.addAnnotatedClass(Mobile.class);
			cfg.addAnnotatedClass(Laptop.class);
			cfg.addAnnotatedClass(Book.class);
			cfg.addAnnotatedClass(Fashion.class);
			
			cfg.addAnnotatedClass(Cart.class);
			cfg.addAnnotatedClass(Order.class);
			cfg.addAnnotatedClass(CreditCard.class);
			
			cfg.setProperty(Environment.HBM2DDL_AUTO,hbm2ddl);
			cfg.setProperty(Environment.DIALECT,dialect);
			cfg.setProperty("hibernate.connection.username",username);
			cfg.setProperty("hibernate.connection.password",password);
			cfg.setProperty("hibernate.connection.driver_class",driverName);
			cfg.setProperty("hibernate.connection.url",url);
			cfg.setProperty(Environment.SHOW_SQL,show_url);
			
			cfg.setProperty("hibernate.cache.use_second_level_cache",cache);
			cfg.setProperty("hibernate.cache.region.factory_class",cacheRegion);
			
			
			
			StandardServiceRegistryBuilder rb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
			SessionFactory sf = cfg.buildSessionFactory(rb.build());
			
			return sf;

			
			
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getHbm2ddl() {
		return hbm2ddl;
	}

	public void setHbm2ddl(String hbm2ddl) {
		this.hbm2ddl = hbm2ddl;
	}

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

	public String getShow_url() {
		return show_url;
	}

	public void setShow_url(String show_url) {
		this.show_url = show_url;
	}

	public String getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
	}

	public String getCacheRegion() {
		return cacheRegion;
	}

	public void setCacheRegion(String cacheRegion) {
		this.cacheRegion = cacheRegion;
	}
	
	
}
