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
@RequestMapping("/schedules") // 등록한 메서드들을 가지고 있다가 요청이 들어오면 Mapping 해주는 Annotation
@RequiredArgsConstructor // 초기화 되지않은 final 필드에 생성자를 생성해주는 Annotation
public class ScheduleController {

    private final ScheduleService scheduleService; // ScheduleService 를 필드로 설정


    @PostMapping // 일정 생성
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getUsername(), requestDto.getTitle(), requestDto.getTask());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }


    @GetMapping // 전체 일정 조회
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {

        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }


    @GetMapping("/{id}") // 특정 일정 조회
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id) {

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
        scheduleService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
