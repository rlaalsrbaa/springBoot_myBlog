package com.kmg.exam.demo.service;

import org.springframework.stereotype.Service;

import com.kmg.exam.demo.repository.BoardRepository;
import com.kmg.exam.demo.vo.Board;

@Service
public class BoardService {
	private BoardRepository boardRepository;

	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	public Board getBoardById(int id) {
		return boardRepository.getBoardById(id);
	}
}