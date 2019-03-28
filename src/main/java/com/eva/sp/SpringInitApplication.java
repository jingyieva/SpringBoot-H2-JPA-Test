package com.eva.sp;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * SpringBoot Init 
 *
 */
@SpringBootApplication(scanBasePackages = {"com.eva.sp.*"})
//@EnableScheduling
public class SpringInitApplication extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringInitApplication.class);
	}
	
    public static void main(String[] args) {
    	SpringApplication.run(SpringInitApplication.class, args);
    	TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println( "Hello World!" );
    }
}
