package com.EasyJobs.EasyJobsbd.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.EasyJobs.EasyJobsbd")
public class DataBaseConfig 
{
	@Bean(name="dataSource")
	public DataSource getDataSource() 
	{
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/gladjobs");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("password");
	    return dataSource;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory sessionFactory()
	{
		LocalSessionFactoryBuilder lsf=new LocalSessionFactoryBuilder(getDataSource());
		lsf.scanPackages("com.EasyJobs.EasyJobsbd.model");
		lsf.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		lsf.setProperty("hibernate.hbm2ddl.auto", "update");
		lsf.setProperty("hibernate.show_sql", "true");
	    return lsf.buildSessionFactory();
	}
	
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	            sessionFactory);	 
	    return transactionManager;
	}
	
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");

	}
}
