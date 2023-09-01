package com.spring.project.dto;

import java.sql.Date;

public class BoardDTO {
    private int num;			// 글 번호
    private String title; 	    // 글 제목
    private String content;	    // 글 내용
    private String id;		    // 작성자
    private Date regDate;		// 등록일

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

}
