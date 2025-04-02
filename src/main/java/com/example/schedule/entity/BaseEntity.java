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
@EntityListeners(AuditingEntityListener.class) // Entity를 DB에 적용 전 커스텀 콜백을 요청할 수 있는 Annotation (?)
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
