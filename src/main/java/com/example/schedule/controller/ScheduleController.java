package com.example.schedule.controller;

import com.example.schedule.dto.requestDto.CreateScheduleRequestDto;
import com.example.schedule.dto.responseDto.ScheduleResponseDto;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Controller 와 ResponseBody 가 합쳐진 Annotation 이며 주로 JSON형태의 객체 데이터를 반환
// 즉 JSON이나 문자열로 응답을 반환하기 위해 사용
@RequestMapping("/schedules") // 등록한 메서드들을 가지고 있다가 요청이 들어오면 Mapping 해주는 Annotation
// 클래스의 이전에 사용했으므로 기본적인 기초 매핑이 됨
@RequiredArgsConstructor // 초기화 되지않은 final 필드에 생성자를 생성해주는 Annotation (?)
public class ScheduleController {

    private final ScheduleService scheduleService; // ScheduleService 를 필드로 설정
    /*
     이 클래스 안에 ScheduleService 타입의 멤버 변수를 선언만 한것
     사용 하기 위해서는 의존성 주입을 해줘야하는데 이 때 RequiredArgsConstructor로 final 필드의
     생성자를 자동 주입
     final은 꼭 초기화를 해줘야 하는데 위 Required가 생성자를 자동 주입하면서 의존성 주입이 되며
     의종성 주입으로 인한 초기화가 된것이다.
     */

    @PostMapping // 일정 생성, 데이터 생성을 위한 어노테이션
    // 각각 아래도 조회, 수정, 삭제를 위한 어노테이션
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getUsername(), requestDto.getTitle(), requestDto.getTask());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
//        return ResponseEntity.ok(scheduleResponseDto); 위의 코드와 같음
    }
    /*
    ResponseEntity<>는 HTTP 응답 전체를 반환하기 위해 사용
    응답 코드를 바꾸거나 응답 헤더를 추가할 수 있기에 사용
    API 응답 전체 제어가 가능하기에 여러 상태 코드를 주거나 헤더를 붙이는 등 대부분 자유로이 사용 가능
    여기서 반환 타입을 <> 제네릭으로 쓰는 이유는 유연하게 반환타입을 받기 위해서이다.
    반환 타입이 없을 시 Void도 가능

    @RequestBody는 JSON을 Java객체로 바꾸기 위해 사용
    Get 방식에서는 일반적으로 사용하지 않고 POST/PUT/PATCH 등 JSON 데이터를 받을 때 사용

    new로 바뀐 새 ResponseEntity를 반환 하는 것
     */


    @GetMapping // 전체 일정 조회
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {

        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }


    @GetMapping("/{id}") // 특정 일정 조회
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id) {
//      @PathVariable은 URL 경로에 포합된 값을 메서드 파라미터로 받아오기 위해 사용
        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);

    }

    @PatchMapping("/{id}") // 부분 수정
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody CreateScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.updateById(id, requestDto.getTitle(), requestDto.getTask());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }


    @DeleteMapping("/{id}") // 일정 삭제
    public ResponseEntity<Void> delete(@PathVariable Long id) {
       // 위에서 말했듯 제네릭을 사용해 반환 바디가 없을때 Void 사용 가능
        scheduleService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
        // Void를 사용하여 받아 올 값을 넣지 않아도 됨
    }
}
