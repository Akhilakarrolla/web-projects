package com.example.demo.model;


import com.example.demo.enums.AlarmType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "alarms")
public class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) // Store as String in DB
    @Column(nullable = false, unique = true) // Only one alarm per type
    private AlarmType alarmType;

    @OneToMany(mappedBy = "alarm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AlarmEvent> events = new ArrayList<>();


}

//    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
//    @Column(name = "id", updatable = false, nullable = false)
//    private UUID id;
//
//    @ManyToOne
//    @JoinColumn(name = "alarm_type_id", nullable = false)
//    private AlarmConfig alarmConfig;
//
//    @Column(name = "created_at", nullable = false, updatable = false)
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//
//    @OneToMany(mappedBy = "alarm", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<AlarmOccurrence> occurrences = new ArrayList<>();
//}


