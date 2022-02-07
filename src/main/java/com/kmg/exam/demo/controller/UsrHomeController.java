package com.kmg.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Data;

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
	@RequestMapping("/usr/home/getArticles")
	@ResponseBody
	public List doGetArticles() {
		Article article1 = new Article(1, "제목1");
		Article article2 = new Article(2, "제목2");
		
		List<Article> list = new ArrayList<>();
		list.add(article1);
		list.add(article2);
		
		return list;
	}

	
}

@Data
@AllArgsConstructor
class Article{
	private int id;
	private String title;
}