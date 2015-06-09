package com.aakam.sample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@Configuration
// TODO check with anand about below annotation. which is moved from
// applicationconfig.java
/*
 * @EnableEntityLinks
 * 
 * @EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
 */
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableEntityLinks
@Import({ MvcConfig.class})
@ComponentScan(basePackages = { "com.aakam.sample"})
public class ApplicationConfig {

    
}
