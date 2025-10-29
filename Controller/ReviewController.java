package com.example.umc.Controller;

import com.example.umc.Entity.Review;
import com.example.umc.Service.ReviewQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping
    public List<Review> searchReview(
            @RequestParam Long userId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Float star
    ) {
        // 서비스 호출
        List<Review> result = reviewQueryService.searchReview(userId,storeName, star);
        return result;
    }
}
