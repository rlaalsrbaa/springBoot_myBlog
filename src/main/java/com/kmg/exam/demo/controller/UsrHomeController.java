package com.kmg.exam.demo.controller;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kmg.exam.demo.service.ArticleService;
import com.kmg.exam.demo.service.BoardService;
import com.kmg.exam.demo.service.ReactionPointService;
import com.kmg.exam.demo.service.ReplyService;
import com.kmg.exam.demo.vo.Article;
import com.kmg.exam.demo.vo.Board;
import com.kmg.exam.demo.vo.Rq;

@Controller
public class UsrHomeController {
	
	@Autowired
	private ArticleService articleService;
	private BoardService boardService;
	private ReplyService replyService;
	private Rq rq;
	private ReactionPointService reactionPointService;

	public UsrHomeController(ArticleService articleService, BoardService boardService,
			ReactionPointService reactionPointService, ReplyService replyService, Rq rq) {
		this.articleService = articleService;
		this.boardService = boardService;
		this.replyService = replyService;
		this.reactionPointService = reactionPointService;
		this.rq = rq;

	}
	
	@RequestMapping("/usr/home/main")
	public String showMain(Model model) {
		
		Board noticeBoard = boardService.getBoardById(1);
		Board freeBoard = boardService.getBoardById(2);
		Board tipAndTechBoard = boardService.getBoardById(3);
		
		List<Article> noticeArticles = articleService.getShowMainArticles(1);
		List<Article> freeArticles = articleService.getShowMainArticles(2);
		List<Article> tipAndTechArticles = articleService.getShowMainArticles(3);
						

		model.addAttribute("noticeBoard", noticeBoard);
		model.addAttribute("noticeArticles", noticeArticles);
		model.addAttribute("freeBoard", freeBoard);
		model.addAttribute("freeArticles", freeArticles);
		model.addAttribute("tipAndTechBoard", tipAndTechBoard);
		model.addAttribute("tipAndTechArticles", tipAndTechArticles);
		
		return "usr/home/main";
	}

	@RequestMapping("/")
	public String showRoot() {
		return "redirect:/usr/home/main";
	}
}