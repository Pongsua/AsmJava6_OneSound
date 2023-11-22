package com.asm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlbumController {

	@RequestMapping("/album/index")
	public String index() {
		return "/admin/album/index.html";
	}
	
	@RequestMapping("/album/edit")
	public String edit() {
		return "admin/album/editor";
	}
}
