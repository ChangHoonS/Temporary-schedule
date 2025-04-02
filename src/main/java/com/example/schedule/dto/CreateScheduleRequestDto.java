package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private final String username;

    private final String title;

    private final String task;


    public CreateScheduleRequestDto(String username, String title, String task) {
        this.username = username;
        this.title = title;
        this.task = task;
    }
}
