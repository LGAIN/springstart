package com.gain.spring.springstart.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class PostEntity {
    @Id // 기본 키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 ID

    private Long id;

    private String title;
    private String content;
    private String writer;
    private int date;

    public PostEntity() {
    }

    public PostEntity(String title, String content, String writer, int date) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.date = date;
    }

}
