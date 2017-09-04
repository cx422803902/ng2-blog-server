package org.goiot.boot;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * Created by ChenXing on 2017/8/24 0024.
 */

@SpringBootConfiguration
@ImportAutoConfiguration(value = {
		ConfigurationPropertiesBindingPostProcessor.class,
		TomcatEmbeddedServletContainerFactory.class,
		EmbeddedServletContainerCustomizerBeanPostProcessor.class,
		ServerProperties.class})
@ComponentScan(basePackages = "org.goiot")
@ImportResource(locations = "classpath:/spring/*.xml")
public class BlogBoot extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(BlogBoot.class)
				.contextClass(AnnotationConfigEmbeddedWebApplicationContext.class)
				.build()
				.run(args);
		SpringApplication.run(BlogBoot.class, args);
	}

	@Bean
	public ServletRegistrationBean restServlet() {
		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet);
		servletRegistrationBean.setLoadOnStartup(1);
		servletRegistrationBean.addUrlMappings("/");
		return servletRegistrationBean;
	}


	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
		converters.add(new FastJsonHttpMessageConverter());
	}
}

