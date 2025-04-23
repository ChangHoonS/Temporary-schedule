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

    인터페이스는 구체적 코드 구현이 불가능하고
    단순 메서드를 만드는 것만 가능하다
    그런데 default를 사용함으로써 코드 구현이 가능하다
    인터페이스에 findByIdOrElseThrow를 리턴으로 구현해놓음으로써
    다른 곳에서 간단하게 사용가능하다

    orElseThrow는 JpaRepository에서 findById(id)가 Optional<Schedule>을 반환한다는 걸
    전제로 사용, orElseThrow는 Optional 없이 사용 불가
    orElseThrow는 null값이 아니면 반환, null이면 뒤의 예외를 throw 한다.
    null 값이 들어가도 되는 것은 Optional의 특징
    ResponseStatusException는 예외 상태 코드를 전달 하기위해 사용
     */

}
