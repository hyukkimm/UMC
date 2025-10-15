package com.example.umc.Entity;

import com.example.umc.Entity.Enum.Gender;
import com.example.umc.Entity.Enum.Status;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 10)
    private String nickname;

    @Column(length = 20)
    private String email;

    @Column(length = 10)
    private String birth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    private Integer point;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime inactivedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    // 1:N 유저 → 리뷰
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    // 1:N 유저 → 유저미션
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissions = new ArrayList<>();

    // N:M 유저 ↔ 지역 (선호지역)
    @ManyToMany
    @JoinTable(
            name = "location_likes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private List<Location> likedLocations = new ArrayList<>();
}