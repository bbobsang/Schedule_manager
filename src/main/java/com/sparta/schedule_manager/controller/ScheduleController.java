package com.sparta.schedule_manager.controller;

import com.sparta.schedule_manager.dto.ScheduleRequestDto;
import com.sparta.schedule_manager.dto.ScheduleResponseDto;
import com.sparta.schedule_manager.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto responseDto = scheduleService.createSchedule(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules() {
        List<ScheduleResponseDto> schedules = scheduleService.getAllSchedules();
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getScheduleById(@PathVariable Long id) {
        ScheduleResponseDto schedule = scheduleService.getScheduleById(id);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id,
                                                              @RequestBody ScheduleRequestDto requestDto,
                                                              @RequestParam String password) {
        ScheduleResponseDto updatedSchedule = scheduleService.updateSchedule(id, requestDto, password);
        return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id,
                                               @RequestParam String password) {
        scheduleService.deleteSchedule(id, password);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}













