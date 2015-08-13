package com.aakam.sample;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.aakam.sample.rest" })
public class MvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * {@inheritDoc}
	 * <p>
	 * This implementation is empty.
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/build/vendor/**").addResourceLocations(
				"/build/vendor/");
		registry.addResourceHandler("/build/src/**").addResourceLocations(
				"/build/src/");
		registry.addResourceHandler("/build/assets/**").addResourceLocations(
				"/build/assets/");
		registry.addResourceHandler("/build/*.js").addResourceLocations(
				"/build/");
		registry.addResourceHandler("/build/*.html").addResourceLocations(
				"/build/");

		// The below are for compile java script code.
		registry.addResourceHandler("/bin/assets/**").addResourceLocations(
				"/bin/assets/");
		registry.addResourceHandler("/bin/*.html")
				.addResourceLocations("/bin/");
		/*
		 * The below generic configuration brings out of memory issue in tomcat
		 * and jboss. Not sure about the cause.
		 * 
		 * registry.addResourceHandler("/bin/**").addResourceLocations("/bin/");
		 * registry
		 * .addResourceHandler("/build/**").addResourceLocations("/build/");
		 */
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().defaultViewInclusion(true).build();
		converters.add(new MappingJackson2HttpMessageConverter(mapper));
	}
}
