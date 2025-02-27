package com.example.demo.service;

import com.example.demo.enums.AlarmType;
import com.example.demo.model.Alarm;
import com.example.demo.model.AlarmEvent;

import java.util.List;


public interface AlarmService {
//    Alarm createAlarm(Alarm alarm);
//
//    List<Alarm> getAllAlarms();
//
////    Optional<Alarm> getAlarmById(Long id);
//
//    Alarm acknowledgeAlarm(Long id);


    AlarmEvent addOrUpdateAlarm(String message, AlarmType alarmType );

    List<Alarm> getAllAlarms();

    void acknowledgeAlarmEvent(Long eventId);

    List<AlarmEvent> getAlarmEvents(Long id);
}
