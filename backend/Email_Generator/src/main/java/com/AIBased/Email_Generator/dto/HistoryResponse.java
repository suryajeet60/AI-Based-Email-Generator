package com.AIBased.Email_Generator.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryResponse
{

    private Long id;

    private String prompt;

    private String generatedEmail;

    private LocalDateTime generatedAt;
}
