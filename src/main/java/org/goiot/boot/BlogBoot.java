package org.goiot.boot;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * Created by ChenXing on 2017/8/24 0024.
 */

@SpringBootApplication
@ServletComponentScan(value = "org.goiot")
@PropertySource(value = "classpath:application.properties")
@ImportResource(locations = "classpath:/spring/*.xml")
@ComponentScan(basePackages = "org.goiot")
public class BlogBoot extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(BlogBoot.class, args);
	}

	@Bean
	public ServletRegistrationBean restServlet() {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet);
		servletRegistrationBean.setLoadOnStartup(1);
		servletRegistrationBean.addUrlMappings("/*");
		return servletRegistrationBean;
	}


	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
		converters.add(new FastJsonHttpMessageConverter());
	}
}

