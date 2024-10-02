package com.sparta.schedule_manager.repository;

import com.sparta.schedule_manager.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // 일정 저장 메소드
    public void save(Schedule schedule) {
        String sql = "INSERT INTO schedule(title, author, password, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, schedule.getTitle(), schedule.getAuthor(), schedule.getPassword(),
                schedule.getCreatedAt(), schedule.getUpdatedAt());
    }
    // 전체 일정 조회 메소드
    public List<Schedule> findAll() {
        String sql = "SELECT * FROM schedule";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Schedule schedule = new Schedule();
            schedule.setId(rs.getLong("id"));
            schedule.setTitle(rs.getString("title"));
            schedule.setAuthor(rs.getString("author"));
            schedule.setPassword(rs.getString("password"));
            schedule.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            schedule.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
            return schedule;
        });
    }
    // 선택한 일정 조회 메소드
    public Optional<Schedule> findById(Long id) {
        String sql = "SELECT * FROM schedule WHERE id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            Schedule schedule = new Schedule();
            schedule.setId(rs.getLong("id"));
            schedule.setTitle(rs.getString("title"));
            schedule.setAuthor(rs.getString("author"));
            schedule.setPassword(rs.getString("password"));
            schedule.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            schedule.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
            return schedule;
        }).stream().findFirst();
    }
    // 일정 수정 메소드
    public void update(Schedule schedule) {
        String sql = "UPDATE schedule SET title = ?, author = ?, updated_at = ? WHERE id = ?";
        jdbcTemplate.update(sql, schedule.getTitle(), schedule.getAuthor(), schedule.getUpdatedAt(), schedule.getId());
    }
    // 일정 삭제 메소드
    public void deleteById(Long id) {
        String sql = "DELETE FROM schedule WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}