/**
 * 
 */
package com.fmoriguchi.streamer.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author fmoriguchi
 *
 */
@Controller
public class VideoController {

	@GetMapping("videos/{name}/show")
	public String showVideo(@PathVariable("name") String name, Model model) {

		model.addAttribute("name", name);

		return "show-video";
	}

	@GetMapping("videos/post")
	public String postVideo() {

		return "post-video";
	}
}
