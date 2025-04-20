package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter // Lombok 라이브러리에서 제공하는 Annotation, 필드에 대한 getter 메서드를 자동으로 생성해주기 위해 사용
@Entity // 선언한 클래스가 JPA가 관리하는 객채로 만들기 위해 사용
@Table(name = "user") // Table 이름 및 제약 조건을 지정하기 위해 사용
public class User extends BaseEntity {
// User 클래스 이면서 BaseEntity 클래스를 상속 받음

    @Id // 기본 키 지정 하기 위함이며 반드시 지정해야 함
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 기본 키 자동 생성 전략 지정하기 위함,
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    // Entity는 기본 생성자가 필요하기 때문에 만들어줌 (새로운 생성자 만들면 기본 생성자가 사라지기 때문)
    public User() {
    }

    // 회원가입에 필요한 생성자를 만들어줌 (Lv2 단계에서는 비밀번호를 넣지 않음)
//    public User(String username, String email) {
//        this.username = username;
//        this.email = email;
//    } 3단계에서 필드에 password를 넣어주고 유저 생성(회원가입)시 pasword 넣어주기

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void updateUsername(String username) {
        this.username = username;
    }

    public void updateEmail(String email) {
        this.email = email;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}