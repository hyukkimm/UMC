package com.example.umc.Controller;

import com.example.umc.Entity.Review;
import com.example.umc.Service.ReviewQueryService;
import com.example.umc.common.apiPayload.ApiResponse;
import com.example.umc.common.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<List<Review>>> searchReview(
            @RequestParam Long userId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Float star
    ) {
        // 서비스 호출
        List<Review> result = reviewQueryService.searchReview(userId,storeName, star);
        return ResponseEntity
                .status(GeneralSuccessCode.OK.getStatus())
                .body(ApiResponse.onSuccess(GeneralSuccessCode.OK, result));
    }
}
