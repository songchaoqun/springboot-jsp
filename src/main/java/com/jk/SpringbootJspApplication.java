package com.jk;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.HttpMessageConverter;

@SpringBootApplication
@MapperScan("com.jk.mapper")
/*@ImportResource(value = {"classpath:dubbo-provider.xml"})*/
public class SpringbootJspApplication {

	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		//声明fastJson配置对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

		//设置fastJson配置
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

		//把配置放入配置对象
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		//返回配置对象
		return new HttpMessageConverters(converter);
	}
	@Bean
	public Queue getQueue(){
		return new Queue("B1804");
	}

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled","false");
		SpringApplication.run(SpringbootJspApplication.class, args);
	}
}
