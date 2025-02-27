package com.example.demo.model;

import com.example.demo.enums.AcknowledgementStatus;
import com.example.demo.enums.AlarmStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "alarm_events")
public class AlarmEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @ManyToOne
    @JoinColumn(name = "alarm_id", nullable = false)
    @JsonBackReference
    private Alarm alarm;

    @Column(name = "message")
    private String message;

    @Column(name = "alarm_code")
    private String alarmCode;


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AlarmStatus status = AlarmStatus.WARNING;

    @Column(name = "started_at", nullable = false)
    private LocalDateTime startedAt = LocalDateTime.now();

    @Column(name = "stopped_at")
    private LocalDateTime stoppedAt;

    @Column(name = "event_timestamp")
    private LocalDateTime eventTimestamp = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "acknowledged_status")
    private AcknowledgementStatus acknowledgedStatus = AcknowledgementStatus.NEVER;


    @Column(name = "acknowledged_timestamp")
    private LocalDateTime acknowledgedTimestamp;


    public void escalateEvent() {
        if (this.status == AlarmStatus.WARNING) {
            this.status = AlarmStatus.ALARM;
        }
    }
}
