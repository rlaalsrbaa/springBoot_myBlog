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

	private void makeTestData() {
		for (int i = 1; i <= 10; i++) {
			String title = "제목" + i;
			String body = "내용" + i;
			writeArticle(title, body);
		}
	}

	public Article writeArticle(String title, String body) {
		int id = articlesLastId + 1;
		Article article = new Article(id, title, body);

		articles.add(article);
		articlesLastId = id;
		return article;
	}

	public void deleteArticle(int id) {
		Article article = getArticle(id);

		articles.remove(article);
	}

	private Article getArticle(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}
	
	@RequestMapping("/usr/home/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articles;
	}
	

	@RequestMapping("/usr/home/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = getArticle(id);
	
		if ( article == null ) {
			return id + "번 게시물이 존재하지 않습니다.";
		}
		deleteArticle(id);
		
		return id + "번 게시물이 삭제됐습니다.";
	}
	
	@RequestMapping("/usr/home/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		return writeArticle(title, body);
	}
	
}
