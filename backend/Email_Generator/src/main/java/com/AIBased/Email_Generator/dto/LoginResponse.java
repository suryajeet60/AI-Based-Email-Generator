package com.AIBased.Email_Generator.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse
{

    private Long id;
    private String fullName;
    private String email;
    private String message;
}
