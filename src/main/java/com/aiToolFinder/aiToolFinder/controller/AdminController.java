package com.aiToolFinder.aiToolFinder.controller;

import com.aiToolFinder.aiToolFinder.entity.Tool;
import com.aiToolFinder.aiToolFinder.service.ReviewService;
import com.aiToolFinder.aiToolFinder.service.ToolService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final ToolService toolService;
    private final ReviewService reviewService;

    public AdminController(ToolService toolService,
                           ReviewService reviewService) {
        this.toolService = toolService;
        this.reviewService = reviewService;
    }

    // ADMIN: Add tool
    @PostMapping("/tools")
    public Tool addTool(@RequestBody Tool tool) {
        return toolService.addTool(tool);
    }

    // ADMIN: Update tool
    @PutMapping("/tools/{id}")
    public Tool updateTool(@PathVariable Long id,
                           @RequestBody Tool tool) {
        return toolService.updateTool(id, tool);
    }

    // ADMIN: Approve review
    @PostMapping("/reviews/{id}/approve")
    public String approveReview(@PathVariable Long id) {
        reviewService.approveReview(id);
        return "Review approved";
    }
}
