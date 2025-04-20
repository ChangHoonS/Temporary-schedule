package com.example.schedule.service;

import com.example.schedule.dto.responseDto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Service bean 만들기 Annotation
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

    @Transactional // 영속성으로 변화를 감지하면 저장을 해주는 Annotation - 수정 때 유저는 보통 바뀌지 않기에 username은 빼보았다.
    public ScheduleResponseDto updateById(Long id, String newTitle, String newTask) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        findSchedule.updateTitle(newTitle);
        findSchedule.updateTask(newTask);

        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getUsername(), findSchedule.getTitle(), findSchedule.getTask());
    }

    public void delete(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);

    }


}
