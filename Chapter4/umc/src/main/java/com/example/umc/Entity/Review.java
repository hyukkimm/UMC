package com.example.umc.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Float star;

    private LocalDateTime createdAt;

    // N:1 리뷰 → 유저
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // N:1 리뷰 → 가게
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
}
