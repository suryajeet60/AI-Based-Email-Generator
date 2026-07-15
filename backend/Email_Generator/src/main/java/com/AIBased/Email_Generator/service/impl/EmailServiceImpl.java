package com.AIBased.Email_Generator.service.impl;

import com.AIBased.Email_Generator.dto.EmailRequest;
import com.AIBased.Email_Generator.dto.EmailResponse;
import com.AIBased.Email_Generator.dto.HistoryResponse;
import com.AIBased.Email_Generator.entity.EmailHistory;
import com.AIBased.Email_Generator.entity.User;
import com.AIBased.Email_Generator.repository.EmailHistoryRepository;
import com.AIBased.Email_Generator.service.AIService;
import com.AIBased.Email_Generator.service.EmailService;
import com.AIBased.Email_Generator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService
{

    private final EmailHistoryRepository historyRepository;

    private final UserService userService;

    private final AIService aiService;

    @Override
    public EmailResponse generateEmail(Long userId, EmailRequest request)
    {

        User user = userService.getUserById(userId);

        String generatedEmail = aiService.generateEmail(request.getPrompt());

        EmailHistory history = EmailHistory.builder()
                .prompt(request.getPrompt())
                .generatedEmail(generatedEmail)
                .user(user)
                .build();

        historyRepository.save(history);

        return EmailResponse.builder()
                .generatedEmail(generatedEmail)
                .build();
    }

    @Override
    public List<HistoryResponse> getHistory(Long userId)
    {

        List<EmailHistory> historyList = historyRepository.findByUserId(userId);

        return historyList.stream()
                .map(history ->
                        HistoryResponse.builder()
                                .id(history.getId())
                                .prompt(history.getPrompt())
                                .generatedEmail(history.getGeneratedEmail())
                                .generatedAt(history.getGeneratedAt())
                                .build())
                .toList();
    }

    @Override
    public void deleteHistory(Long historyId)
    {

        EmailHistory history = historyRepository.findById(historyId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "History not found"));

        historyRepository.delete(history);
    }
}
