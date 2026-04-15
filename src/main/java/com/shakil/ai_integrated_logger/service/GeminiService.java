package com.shakil.ai_integrated_logger.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.shakil.ai_integrated_logger.config.PromptBuilder;
import com.shakil.ai_integrated_logger.request.LogEntry;
import com.shakil.ai_integrated_logger.response.LogSummaryResponse;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeminiService {

    private final PromptBuilder promptBuilder;
    private final ObjectMapper objectMapper;
    private final Client client;

    public GeminiService(PromptBuilder promptBuilder, ObjectMapper objectMapper, Client client) {
        this.promptBuilder = promptBuilder;
        this.objectMapper = objectMapper;
        this.client = client;
    }

    public LogSummaryResponse summarizeLogs(List<LogEntry> logs) throws Exception {
        String prompt = promptBuilder.buildPrompt(logs, objectMapper);
        GenerateContentResponse response = client.models.generateContent("gemini-2.5-flash", prompt, null);
        System.out.println(response.text());
        return objectMapper.readValue(response.text(), LogSummaryResponse.class);
    }
}
