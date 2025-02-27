package com.example.demo.serviceImpl;

import com.example.demo.Exception.AlarmAlreadyAcknowledgedException;
import com.example.demo.enums.AcknowledgementStatus;
import com.example.demo.enums.AlarmStatus;
import com.example.demo.enums.AlarmType;
import com.example.demo.model.Alarm;
import com.example.demo.model.AlarmEvent;
import com.example.demo.repository.AlarmEventRepository;
import com.example.demo.repository.AlarmRepository;
import com.example.demo.service.AlarmService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AlarmServiceImpl implements AlarmService {

   @Autowired
   private AlarmRepository alarmRepository;





    @Autowired
    private AlarmEventRepository alarmEventRepository;
    @Transactional
    public AlarmEvent addOrUpdateAlarm(String message, AlarmType alarmType) {
        // Find an existing alarm or create a new one
        Alarm alarm = alarmRepository.findByAlarmType(alarmType)
                .orElseGet(() -> {
                    Alarm newAlarm = new Alarm();
                    newAlarm.setAlarmType(alarmType);
                    return alarmRepository.save(newAlarm);
                });

        // Generate a unique alarm code
        String alarmCode = generateAlarmCode(alarmType);

        // Create a new independent event
        AlarmEvent event = new AlarmEvent();
        event.setAlarm(alarm);
        event.setAlarmCode(alarmCode);
        event.setMessage(message);
        event.setStatus(AlarmStatus.WARNING); // Default status is WARNING
        event.setStartedAt(LocalDateTime.now());
        event.setAcknowledgedStatus(AcknowledgementStatus.NEVER);

        return alarmEventRepository.save(event);
    }


    private String generateAlarmCode(AlarmType alarmType) {
        String prefix = Arrays.stream(alarmType.name().split("_"))
                .map(word -> word.substring(0, 1)) // Get first letter of each word
                .collect(Collectors.joining()); // Combine them

        long count = alarmEventRepository.countByAlarmType(alarmType) + 1; // Incremental unique number
        return prefix + "-" + String.format("%03d", count); // Format as 'XX-001'
    }


    public List<Alarm> getAllAlarms() {
        return alarmRepository.findAll();
    }

    public List<AlarmEvent> getAlarmEvents(Long alarmId) {
        return alarmEventRepository.findByAlarmId(alarmId);
    }

    @Transactional
    public void acknowledgeAlarmEvent(Long eventId) {
        AlarmEvent event = alarmEventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Alarm event not found"));

        if (event.getAcknowledgedStatus() == AcknowledgementStatus.ACKNOWLEDGED) {
            throw new AlarmAlreadyAcknowledgedException("Alarm with ID " + eventId + " is already acknowledged and cannot be changed again.");
        }

        event.setAcknowledgedStatus(AcknowledgementStatus.ACKNOWLEDGED);
        event.setAcknowledgedTimestamp(LocalDateTime.now());
        alarmEventRepository.save(event);
    }


}
