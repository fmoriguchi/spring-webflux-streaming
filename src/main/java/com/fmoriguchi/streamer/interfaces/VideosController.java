/**
 * 
 */
package com.fmoriguchi.streamer.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author fmoriguchi
 *
 */
@Controller
@RequestMapping("videos/view")
class VideosController {
	
	@GetMapping("{name}/show")
	String showVideo(@PathVariable String name, Model model) {

		model.addAttribute("name", name);

		return "show-video";
	}

	@GetMapping
	String postView() {

		return "post-video";
	}
}
