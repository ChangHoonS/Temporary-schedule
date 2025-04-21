package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
// Spring에서 지원하는 JpaRepository를 상속 받기 위해 사용하고 제네릭에 다룰 엔티티와 그 엔티티의 ID 필드 타입을 의미
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    default Schedule findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }
    /*
    default를 쓰면 인터페이스에서 메서드 구현이 가능하다
    그런데 원래 인터페이스에서는 메서드만 구현 가능하다고 알고있다.
    차이점이 무엇인가?


     */

}
