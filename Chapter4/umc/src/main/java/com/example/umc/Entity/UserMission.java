package com.example.umc.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_mission")
public class UserMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isSuccess;

    // N:1 유저미션 → 유저
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // N:1 유저미션 → 미션
    @ManyToOne
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;
}
