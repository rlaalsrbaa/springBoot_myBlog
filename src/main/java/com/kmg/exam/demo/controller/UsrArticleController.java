package com.kmg.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kmg.exam.demo.vo.Article;

@Controller
public class UsrArticleController {
	List<Article> articles;
	int articlesLastId;

	public UsrArticleController() {
		articles = new ArrayList<>();
		articlesLastId = 0;
		makeTestData();
	}
	
	private void makeTestData(){
		for (int i=1; i<=10; i++){
			int id = articlesLastId + 1;
			articlesLastId = id;
			String title = "제목"+i;
			String body = "내용"+i;
			Article article = new Article(id, title, body);
			
			articles.add(article);
			
		}
	}
	@RequestMapping("/usr/home/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		int id = articlesLastId + 1;
		Article article = new Article(id, title, body);

		articlesLastId = id;
		articles.add(article);

		return article;
	}

	@RequestMapping("/usr/home/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articles;
	}
}
