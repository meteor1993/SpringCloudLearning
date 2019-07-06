package com.springcloud.zuulsimple;

import com.springcloud.zuulsimple.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulSimpleApplication.class, args);
	}

	@Bean
	public TokenFilter tokenFilter() {
		return new TokenFilter();
	}

}
