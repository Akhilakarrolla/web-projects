package com.example.demo.repository;


import com.example.demo.enums.AlarmType;
import com.example.demo.model.AlarmEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlarmEventRepository extends JpaRepository<AlarmEvent, Long> {
    List<AlarmEvent> findByAlarmId(Long alarmId);

    long countByAlarmType(AlarmType alarmType);
}
