package com.example.schedule.controller;

import com.example.schedule.dto.CreateScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
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

    @PostMapping // 서버에 리소스를 등록 할 때 사용하는 Mapping Annotation
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getUsername(), requestDto.getTitle(), requestDto.getTask());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {

        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }
}
