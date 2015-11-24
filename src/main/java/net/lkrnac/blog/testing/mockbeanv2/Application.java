package net.lkrnac.blog.testing.mockbeanv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;

import net.lkrnac.blog.testing.mockbeanv2.annotation.BeanMock;

import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(excludeFilters = @Filter(BeanMock.class))
@EnableAutoConfiguration
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
