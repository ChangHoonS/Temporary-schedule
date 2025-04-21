package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity // 선언한 클래스가 JPA가 관리하는 객채로 만들기 위해 사용
@Table(name = "user") // Table 이름 및 제약 조건을 지정하기 위해 사용
public class User extends BaseEntity {
// User 클래스 이면서 BaseEntity 클래스를 상속 받음

    @Id // 기본 키 지정 하기 위함이며 반드시 지정해야 함
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
    기본 키 자동 생성 전략 지정하기 위해 사용
    괄호 안의 형식으로 쓰되 맨뒤 타입은 DB의 종류에 따라 바뀜
    MySQL은 IDENTITY를 사용
     */
    private Long id;

    @Column(nullable = false) // null값이 들어가지 않게 지정할 때 사용
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
    /*
    다른 클래스에서 사용된 문자열을 String username인 지역변수로 받아오고
    위 필드와 동일한 this.username에 방금 가져온 지역변수의 문자열을
    username에 넣어서 객체의 username 필드에 받아온 username값을 넣는 것 (java 복습)
    고로, 새 username을 받아오기 위한 메서드
    아래 메서드들도 동일
    여기서 this.을 쓰는 이유는 이 클래스의 username임을 판별하기 위함
     */
    public void updateEmail(String email) {
        this.email = email;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}