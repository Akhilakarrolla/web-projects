package com.example.demo.controller;

import com.example.demo.enums.AlarmType;
import com.example.demo.model.Alarm;
import com.example.demo.model.AlarmEvent;
import com.example.demo.service.AlarmService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("v1/alarms")
@Tag(name = "Alarms API", description = "Endpoints for managing alarms")
public class AlarmController {


    @Autowired
    private AlarmService alarmService;

    @PostMapping
    public ResponseEntity<AlarmEvent> createOrUpdateAlarm(
                                                          @RequestParam String message,
                                                          @RequestParam AlarmType alarmType) {
        AlarmEvent event = alarmService.addOrUpdateAlarm( message, alarmType);
        return ResponseEntity.ok(event);
    }

    @GetMapping
    public ResponseEntity<List<Alarm>> getAllAlarms() {
        return ResponseEntity.ok(alarmService.getAllAlarms());
    }

    @GetMapping("/{id}/events")
    public ResponseEntity<List<AlarmEvent>> getAlarmEvents(@PathVariable Long id) {
        return ResponseEntity.ok(alarmService.getAlarmEvents(id));
    }

    @PostMapping("/events/{eventId}/acknowledge")
    public ResponseEntity<String> acknowledgeAlarmEvent(@PathVariable Long eventId) {
        alarmService.acknowledgeAlarmEvent(eventId);
        return ResponseEntity.ok("Alarm event acknowledged successfully.");
    }
}



//    @PostMapping
//    public Alarm createAlarm(@RequestBody Alarm alarm) {
//        return alarmService.createAlarm(alarm);
//    }
//
//
//    @GetMapping
//    public List<Alarm> getAllAlarms() {
//        return alarmService.getAllAlarms();
//    }
////
////    // Endpoint to get an alarm by ID
////    @GetMapping("/{id}")
////    public Optional<Alarm> getAlarmById(@PathVariable Long id) {
////        return alarmService.getAlarmById(id);
////    }
//
//    @PostMapping("/{id}/acknowledge")
//    public Alarm acknowledgeAlarm(@PathVariable Long id) {
//        return alarmService.acknowledgeAlarm(id);
//    }
//}
