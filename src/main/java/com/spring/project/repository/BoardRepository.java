package com.spring.project.repository;

import com.spring.project.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {
    private final SqlSession sqlSession;

    public BoardRepository(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<BoardDTO> board() {

        List<BoardDTO> board = sqlSession.selectList("com.spring.project.repository.MainRepository.main");

        return board;
    }
}
