package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동생성 Annotation - strategy 속성은 MySQL 에서 사용, 데이터베이스가 PK 자동 생성
    private Long id;

    @Column(nullable = false) // DDL 자동생성 제약조건 설정 - 필수 여부 {null 은 안된다는 뜻}(기본값은 true)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "Longtext") // 생성 시 데이터베이스 컬럼 정보를 직접 설정 가능 - VARCHAR()를 넘어서는 큰 용량의 문자열 저장 가능
    private String task;

    @ManyToOne // 연관관계 설정
    @JoinColumn(name = "user_id")
    private User user;

    // Entity 는 무조건 기본 생성자가 필수
    public Schedule() {
    }

    //연관 생성자 만들기
    public Schedule(String username, String title, String task) {
        this.username = username;
        this.title = title;
        this.task = task;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateTask(String task) {
        this.task = task;
    }
}
