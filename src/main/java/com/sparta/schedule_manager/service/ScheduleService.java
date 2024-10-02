package com.sparta.schedule_manager.service;


import com.sparta.schedule_manager.dto.ScheduleRequestDto;
import com.sparta.schedule_manager.dto.ScheduleResponseDto;
import com.sparta.schedule_manager.entity.Schedule;
import com.sparta.schedule_manager.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule();
        schedule.setTitle(requestDto.getTitle());
        schedule.setAuthor(requestDto.getAuthor());
        schedule.setPassword(requestDto.getPassword());
        // 기본 작성/수정일 설정
        schedule.setCreatedAt(LocalDateTime.now());
        schedule.setUpdatedAt(LocalDateTime.now());
        // 일정 저장
        scheduleRepository.save(schedule);
        // Response DTO 생성
        ScheduleResponseDto responseDto = new ScheduleResponseDto();
        responseDto.setId(schedule.getId());
        responseDto.setTitle(schedule.getTitle());
        responseDto.setAuthor(schedule.getAuthor());
        responseDto.setCreatedAt(schedule.getCreatedAt().toString());
        responseDto.setUpdatedAt(schedule.getUpdatedAt().toString());
        return responseDto;
    }
    public List<ScheduleResponseDto> getAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream().map(schedule -> {
            ScheduleResponseDto responseDto = new ScheduleResponseDto();
            responseDto.setId(schedule.getId());
            responseDto.setTitle(schedule.getTitle());
            responseDto.setAuthor(schedule.getAuthor());
            responseDto.setCreatedAt(schedule.getCreatedAt().toString());
            responseDto.setUpdatedAt(schedule.getUpdatedAt().toString());
            return responseDto;
        }).collect(Collectors.toList());
    }
    public ScheduleResponseDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        ScheduleResponseDto responseDto = new ScheduleResponseDto();
        responseDto.setId(schedule.getId());
        responseDto.setTitle(schedule.getTitle());
        responseDto.setAuthor(schedule.getAuthor());
        responseDto.setCreatedAt(schedule.getCreatedAt().toString());
        responseDto.setUpdatedAt(schedule.getUpdatedAt().toString());
        return responseDto;
    }
    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto, String password) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        // 비밀번호 확인
        if (!schedule.getPassword().equals(password)) {
            throw new RuntimeException("Wrong password");
        }
        // 필드 업데이트
        schedule.setTitle(requestDto.getTitle());
        schedule.setAuthor(requestDto.getAuthor());
        schedule.setUpdatedAt(LocalDateTime.now());
        scheduleRepository.update(schedule);
        // Response DTO 생성
        ScheduleResponseDto responseDto = new ScheduleResponseDto();
        responseDto.setId(schedule.getId());
        responseDto.setTitle(schedule.getTitle());
        responseDto.setAuthor(schedule.getAuthor());
        responseDto.setCreatedAt(schedule.getCreatedAt().toString());
        responseDto.setUpdatedAt(schedule.getUpdatedAt().toString());
        return responseDto;
    }
    @Transactional
    public void deleteSchedule(Long id, String password) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        // 비밀번호 확인
        if (!schedule.getPassword().equals(password)) {
            throw new RuntimeException("Wrong password");
        }
        scheduleRepository.deleteById(id);
    }
}