package com.EasyJobs.EasyJobsbd.config;

import javax.servlet.Filter;
import java.nio.charset.StandardCharsets;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

	public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		protected Class[] getRootConfigClasses()
		{
			return new Class[] { DataBaseConfig.class };
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		protected Class[] getServletConfigClasses() 
		{
			return null;
		}

		@Override
		protected String[] getServletMappings() 
		{
			return new String[] { "/" };
		}
		

		 @Override
		  protected Filter[] getServletFilters() {
		    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		    characterEncodingFilter.setEncoding(StandardCharsets.UTF_8.name());
		    return new Filter[] { characterEncodingFilter };
		  }
		
}
