/**
 * 
 */
package com.fmoriguchi.streamer.service;

import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;

import com.fmoriguchi.streamer.domain.Streamer;
import com.fmoriguchi.streamer.domain.StreamerProperties;

import reactor.core.publisher.Mono;

/**
 * @author fmoriguchi
 *
 */
@Service
public class VideoService {
	
    private static final Logger log = LoggerFactory.getLogger(VideoService.class);

    private final StreamerProperties properties;

	private final Streamer streamer;

	public VideoService(Streamer streamer, StreamerProperties properties) {

		this.streamer = streamer;
		this.properties = properties;
	}

	public Mono<Resource> byName(String name) {

		var path = Paths.get(properties.getPath(), name);
		
		log.info("path > {}", path);
		
		return streamer.streaming("file:" + path.toString());
	}
	
	public Mono<Void> post(String name, Mono<FilePart> video) {
		
		var path = Paths.get(properties.getPath());
		
		log.info(name);
		
		return video//.doOnNext(v -> log.info("filename > ", v.filename()))
					.flatMap(v -> v.transferTo(path.resolve(name)))
					.then();
	}
}
