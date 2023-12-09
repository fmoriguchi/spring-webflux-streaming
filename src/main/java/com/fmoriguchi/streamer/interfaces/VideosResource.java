/**
 * 
 */
package com.fmoriguchi.streamer.interfaces;

import org.springframework.core.io.Resource;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fmoriguchi.streamer.service.VideoService;

import reactor.core.publisher.Mono;

/**
 * @author fmoriguchi
 *
 */
@RestController
@RequestMapping("/videos")
class VideosResource {

	private final VideoService videos;

	VideosResource(VideoService videos) {

		this.videos = videos;
	}

	@GetMapping("/{name}")
	Mono<Resource> getBy(@PathVariable String name) {

		return videos.byName(name);
	}

	@PostMapping
	Mono<VideoDetails> post(@RequestPart String name, @RequestPart Mono<FilePart> video) {

		return videos.post(name, video).thenReturn(new VideoDetails(name));
	}

	record VideoDetails(String name) {

	}
}