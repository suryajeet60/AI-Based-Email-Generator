package com.AIBased.Email_Generator.service.impl;

import com.AIBased.Email_Generator.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIServiceImpl implements AIService
{

    private final ChatClient.Builder chatClientBuilder;

    @Override
    public String generateEmail(String prompt)
    {

        ChatClient chatClient = chatClientBuilder.build();

        return chatClient.prompt()
                .system("""
                        You are a professional email writer.

                        Generate a professional email based on the user's request.

                        Requirements:
                        - Include a suitable subject line.
                        - Use proper email formatting.
                        - Use professional language.
                        - Return only the email.
                        """)
                .user(prompt)
                .call()
                .content();
    }
}
