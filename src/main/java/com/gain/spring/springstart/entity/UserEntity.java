package com.gain.spring.springstart.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // user라는 테이블과 매핑
@Table(name = "users") // 테이블 이름 지정
@Getter
@Setter
public class UserEntity {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 ID
    private Long id;

    @Column(nullable = false)
    private String name; // column 이름은 name

    @Column(unique = true, nullable = false)
    private String email; // column 이름은 email
    private String password;
    private int age; // column 이름은 age

    @Column(nullable = false)
    private String role = "USER";


    // 기본 생성자
    public UserEntity() {

    }

    public UserEntity(String name, String email, String password, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

}
