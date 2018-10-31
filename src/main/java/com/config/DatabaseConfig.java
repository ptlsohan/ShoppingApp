package com.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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


@Configuration
@PropertySource(value="classpath:db.properties")
@EnableTransactionManagement(proxyTargetClass=false)
public class DatabaseConfig {

	@Autowired Environment env;
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds= new DriverManagerDataSource();
		ds.setUrl(env.getProperty("DB_URL"));
		ds.setPassword(env.getProperty("DB_Password"));
		ds.setUsername(env.getProperty("DB_User"));
		ds.setDriverClassName(env.getProperty("DB_Driver"));
		return ds;
	}
	
	@Bean
	public SessionFactory sessionFactory() throws IOException {
		LocalSessionFactoryBean bean= new LocalSessionFactoryBean();
		bean.setDataSource(getDataSource());
		bean.setHibernateProperties(hibernateProperties());
		bean.setAnnotatedClasses(User.class,UserProfile.class,Address.class,Product.class,Mobile.class,Laptop.class,Book.class,Fashion.class,Cart.class,Order.class,CreditCard.class);
		bean.afterPropertiesSet();
		return bean.getObject();
	}

	@Bean
	public Properties hibernateProperties() {
		Properties properties= new Properties();
	//	properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
		properties.put(org.hibernate.cfg.Environment.SHOW_SQL, "true");
		properties.put(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		properties.put(org.hibernate.cfg.Environment.AUTOCOMMIT, "false");
		return properties;
	}
	
	@Bean
	public HibernateTemplate getTemplate() throws IOException {
		HibernateTemplate template= new HibernateTemplate();
		template.setSessionFactory(sessionFactory());
		return template;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() throws IOException {
		HibernateTransactionManager tx= new HibernateTransactionManager();
		tx.setSessionFactory(sessionFactory());
		return tx;
	}
}
