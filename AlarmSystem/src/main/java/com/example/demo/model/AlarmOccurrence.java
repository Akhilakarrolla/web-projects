//package com.example.demo.model;
//
//import com.example.demo.enums.AcknowledgementStatus;
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.GenericGenerator;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class AlarmOccurrence {
//
//    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
//    @Column(name = "id", updatable = false, nullable = false)
//    private UUID id;
//
//    @ManyToOne
//    @JoinColumn(name = "alarm_id", nullable = false)
//    @JsonBackReference
//    private Alarm alarm;
//
//    @Column(name = "message", nullable = false)
//    private String message;
//
//    @Column(name = "alarm_code", length = 100, nullable = false)
//    private String alarmCode;
//
//    @Column(name = "occurred_at", nullable = false, updatable = false)
//    @CreationTimestamp
//    private LocalDateTime occurredAt;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "acknowledged_status", nullable = false)
//    private AcknowledgementStatus acknowledgedStatus = AcknowledgementStatus.NEVER;
//
//    @Column(name = "acknowledged", nullable = false)
//    private Boolean acknowledged = false;
//
//    @Column(name = "acknowledged_at")
//    private LocalDateTime acknowledgedAt;
//}
