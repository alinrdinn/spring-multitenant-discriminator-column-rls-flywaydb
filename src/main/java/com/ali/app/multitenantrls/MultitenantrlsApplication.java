package com.ali.app.multitenantrls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MultitenantrlsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MultitenantrlsApplication.class, args);
	}

}
