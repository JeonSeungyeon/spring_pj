package com.spring.project.service;

import com.spring.project.dto.BoardDTO;
import com.spring.project.repository.BoardRepository;
import com.spring.project.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository repository;

    public List<BoardDTO> board() {

        List<BoardDTO> board = repository.board();

        return board;
    }
}
