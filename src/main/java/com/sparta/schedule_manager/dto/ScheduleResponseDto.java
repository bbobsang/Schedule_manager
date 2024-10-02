package com.sparta.schedule_manager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String author;
    private String createdAt;
    private String updatedAt;
}
