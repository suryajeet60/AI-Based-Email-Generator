package com.AIBased.Email_Generator.controller;

import com.AIBased.Email_Generator.dto.EmailRequest;
import com.AIBased.Email_Generator.dto.EmailResponse;
import com.AIBased.Email_Generator.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmailController
{

    private final EmailService emailService;

    @PostMapping("/generate/{userId}")
    public ResponseEntity<EmailResponse> generateEmail(
            @PathVariable Long userId,
            @Valid @RequestBody EmailRequest request) {

        EmailResponse response = emailService.generateEmail(userId, request);

        return ResponseEntity.ok(response);
    }
}
