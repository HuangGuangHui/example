package com.zs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexCon{
	
	@RequestMapping("/goto/index")
	public String gotoIndex(){
		return "/index";
	}
	
}
