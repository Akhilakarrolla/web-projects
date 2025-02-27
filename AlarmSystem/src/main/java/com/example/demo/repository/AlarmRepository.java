package com.example.demo.repository;

import com.example.demo.enums.AlarmType;
import com.example.demo.model.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm,Long> {


    Optional<Alarm> findByAlarmType(AlarmType alarmType);
}

