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

}
