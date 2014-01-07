package com.racket.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.baldy.commons.web.config", "com.racket.web"})
@PropertySource({"classpath:app.properties", "classpath:mvc.properties"})
@EnableAspectJAutoProxy
public class WebConfig extends WebMvcConfigurerAdapter {

	//Message source
    @Bean  
    public ResourceBundleMessageSource messageSource() {  
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();  
        source.setBasename("messages");  
        source.setUseCodeAsDefaultMessage(true);  
        return source;  
    }  
	
	//Default validator
    @Bean
    public LocalValidatorFactoryBean defaultValidator() {
    	return new LocalValidatorFactoryBean();
    }

    /**
     * Should be equivalent to
     * <mvc:resources mapping="/css/**" location="/css/"/> 
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/libs/**").addResourceLocations("/libs/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/javascript/**").addResourceLocations("/javascript/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/modules/**").addResourceLocations("/modules/");
    }

    /**
     * Should be equivalent to 
     * <mvc:interceptors>
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //
    }
}
