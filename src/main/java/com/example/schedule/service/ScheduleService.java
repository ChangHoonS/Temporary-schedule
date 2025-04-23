package com.example.schedule.service;

import com.example.schedule.dto.responseDto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Service bean 만들기 Annotation, 실질적으로 @Component와 같지만 서비스부분인걸 표시하기 위함
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(String username, String title, String task) {

        Schedule schedule = new Schedule(username, title, task);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getUsername(), savedSchedule.getTitle(), savedSchedule.getTask());
    }

    public List<ScheduleResponseDto> findAll() {

        // Stream 잘 모르니 알아보기
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    public ScheduleResponseDto findById(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getUsername(), findSchedule.getTitle(), findSchedule.getTask());
    }

    @Transactional // 영속성으로 변화를 감지하면 저장을 해주는 Annotation
    public ScheduleResponseDto updateById(Long id, String newTitle, String newTask) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        // findByIdOrElseThrow(id) - Repository에 메서드를 만들어 줘야함
        findSchedule.updateTitle(newTitle);
        findSchedule.updateTask(newTask);

        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getUsername(), findSchedule.getTitle(), findSchedule.getTask());
    }

    public void delete(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);

    }


}
