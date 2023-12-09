/**
 * 
 */
package com.fmoriguchi.streamer.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author fmoriguchi
 *
 */
@ConfigurationProperties("streamer.video")
public record StreamerProperties(String path) {
	
}