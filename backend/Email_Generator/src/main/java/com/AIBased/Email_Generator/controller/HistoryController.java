package com.AIBased.Email_Generator.controller;

import com.AIBased.Email_Generator.dto.ApiResponse;
import com.AIBased.Email_Generator.dto.HistoryResponse;
import com.AIBased.Email_Generator.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class HistoryController
{

    private final EmailService emailService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<HistoryResponse>> getHistory(
            @PathVariable Long userId) {

        List<HistoryResponse> history = emailService.getHistory(userId);

        return ResponseEntity.ok(history);
    }

    @DeleteMapping("/{historyId}")
    public ResponseEntity<ApiResponse> deleteHistory(
            @PathVariable Long historyId) {

        emailService.deleteHistory(historyId);

        ApiResponse response = ApiResponse.builder()
                .success(true)
                .message("History deleted successfully")
                .build();

        return ResponseEntity.ok(response);
    }
}
