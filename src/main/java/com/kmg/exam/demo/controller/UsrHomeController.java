package com.kmg.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kmg.exam.demo.vo.Article;



@Controller
public class UsrHomeController {
	private int count;

	public UsrHomeController() {
		count = 0;
	}

	@RequestMapping("/usr/home/main")
	@ResponseBody
	public String showMain() {
		return "안녕하세요.";
	}



	
}
