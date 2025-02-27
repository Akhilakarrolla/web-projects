//package com.example.demo.controller;
//
//
//import com.example.demo.service.AlarmEventService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/v1/alarm-configs")
//public class AlarmConfigController {
//
//    @Autowired
//    AlarmEventService alarmConfigService;
//
//    @PostMapping
//    public ResponseEntity<AlarmConfig> createAlarmConfig(@RequestBody AlarmConfig alarmConfig) {
//
//        AlarmConfig createdConfig = alarmConfigService.createAlarmConfig(alarmConfig);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdConfig);
//    }
//}
