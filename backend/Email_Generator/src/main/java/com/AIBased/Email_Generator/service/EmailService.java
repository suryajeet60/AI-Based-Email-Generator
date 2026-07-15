package com.AIBased.Email_Generator.service;

import com.AIBased.Email_Generator.dto.EmailRequest;
import com.AIBased.Email_Generator.dto.EmailResponse;
import com.AIBased.Email_Generator.dto.HistoryResponse;

import java.util.List;

public interface EmailService
{

    EmailResponse generateEmail(Long userId, EmailRequest request);

    List<HistoryResponse> getHistory(Long userId);

    void deleteHistory(Long historyId);
}
