package com.aiToolFinder.aiToolFinder.controller;

import com.aiToolFinder.aiToolFinder.service.ReviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // USER: Submit review
    @PostMapping
    public String submitReview(@RequestParam Long toolId,
                               @RequestParam int rating,
                               @RequestParam(required = false) String comment) {

        reviewService.submitReview(toolId, rating, comment);
        return "Review submitted for approval";
    }
}
