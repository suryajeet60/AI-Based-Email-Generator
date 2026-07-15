package com.AIBased.Email_Generator.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailRequest
{

    @NotBlank(message = "Prompt cannot be empty")
    private String prompt;
}
