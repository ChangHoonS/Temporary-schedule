package com.example.schedule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter // LomBok Getter 자동 구현
@MappedSuperclass // 부모클래스가 테이블과 매핑하지 않고 가지고 있는 칼럼만 매핑정보로 제공하는 Annotation
// 여러 엔티티에서 공동 필드가 반복될 때 각각 쓰기위해 사용 - 이 베이스엔티티를 자신것처럼 사용
@EntityListeners(AuditingEntityListener.class)
/*
JPA 엔티티 클래스에 대한 생명주기 생성,수정 등을 감지하고 특정 필드에 자동으로 값을
설정해주는 리스너를 등록하는 어노테이션
 */
// 상속을 통해 칼럼 정보만 제공하는 부모격 클래스 ( LocalDateTime 정보 제공 )
public class BaseEntity {

    @CreatedDate // 생성 시점의 날짜를 자동으로 기록하는 Annotation
    @Column(updatable = false) // DB 컬럼 매핑에 사용 - (설정된 업데이트 가능여부 default 값 true에서 false로 변경) (?)
    //@Temporal(TemporalType.TIMESTAMP)
    // 최신 버전의 Hibernate에서 LocalDate, LocalDateTime는 @Temporal이 생략이 가능
    private LocalDateTime createdAt;

    @LastModifiedDate // 수정 시점의 날짜를 자동으로 기록하는 Annotation
    private LocalDateTime modifiedAt;

}

// 보통 Class 앞에 Annotation을 사용하는 이유는 클래스 전체에 적용하기 위함이다.
// 모든 어노테이션이 Class 앞에 붙인다고 적용되는 것은 아니다. 일부는 다른 용도로 쓰인다.
// ex) 유효성 검사 어노테이션, 컨트롤러 메서드의 파라미터에 쓰는 어노테이션 등등

// 코드 리뷰에 정의/왜 사용하는가?/언제 사용하는가를 생각해서 주석 달기