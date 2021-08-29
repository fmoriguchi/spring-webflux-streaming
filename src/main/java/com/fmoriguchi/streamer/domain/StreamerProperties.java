/**
 * 
 */
package com.fmoriguchi.streamer.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author fmoriguchi
 *
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "streamer.video")
public class StreamerProperties {

	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}