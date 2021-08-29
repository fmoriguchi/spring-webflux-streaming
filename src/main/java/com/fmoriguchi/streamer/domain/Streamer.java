/**
 * 
 */
package com.fmoriguchi.streamer.domain;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

/**
 * @author fmoriguchi
 *
 */
@Component
public class Streamer {

	private final ResourceLoader loader;

	public Streamer(ResourceLoader loader) {

		this.loader = loader;
	}

	public Mono<Resource> streaming(String path) {

		return Mono.fromSupplier(() -> loader.getResource(path));
	}
}
