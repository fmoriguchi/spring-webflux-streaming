package com.fmoriguchi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * 
 * @author fmoriguchi
 *
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class StreamingVideosApplication {

	public static void main(String[] args) {

		SpringApplication.run(StreamingVideosApplication.class, args);
	}

}
