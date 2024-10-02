package com.sparta.schedule_manager.entity;


import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter

public class Schedule {

    private Long id;
    private String title;
    private String Author;
    private String date;
    private String password;// 비밀번호는 DTO에 포함하지 않음
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Schedule(){}

    // Optional constructor
    public Schedule(Long id, String title, String author, String password, LocalDateTime createdDateTime, LocalDateTime updatedDateTime) {
        this.id = id;
        this.title = title;
        this.Author = author;
        this.password = password;
        this.createdAt = createdDateTime;
        this.updatedAt = updatedDateTime;
    }
}
