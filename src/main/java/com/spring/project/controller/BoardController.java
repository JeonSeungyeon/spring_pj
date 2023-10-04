package com.spring.project.controller;

import com.google.gson.Gson;
import com.spring.project.dto.BoardDTO;
import com.spring.project.service.BoardService;
import com.spring.project.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    BoardService service;

    @RequestMapping("/board")
    public String main(HttpServletRequest req, Model model) {
        logger.info("[url => main]");

        List<BoardDTO> board = service.board();
        req.setAttribute("board", board);

        return "main/board";
    }
    
//    젠킨스 테스트용 주석
}
