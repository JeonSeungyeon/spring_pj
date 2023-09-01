package com.spring.project.repository;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MainRepository {
    private static final Logger logger = LoggerFactory.getLogger(MainRepository.class);
    private final SqlSession sqlSession;

    public MainRepository(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int main() {

        logger.info("[repository => main]");

        return sqlSession.selectOne("com.spring.project.repository.MainRepository.main");
    }
}
