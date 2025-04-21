package com.example.schedule.dto.responseDto;

import com.example.schedule.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String username;

    private final String title;

    private final String task;

    public ScheduleResponseDto(Long id, String username, String title, String task) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.task = task;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getUsername(), schedule.getTitle(), schedule.getTask());
    }
    // ScheduleResponseDto 생성 방식과 직접 생상자 호출 toDto 방식이 혼용 되어있음
    // 이 부분을 잘 모르겠다.
    // 이 부분을 User 엔티티에 만들어서 한번에 사용하는 방식이 가능한가?

}
