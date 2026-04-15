package com.shakil.ai_integrated_logger.controller;

import com.shakil.ai_integrated_logger.request.LogEntry;
import com.shakil.ai_integrated_logger.response.LogSummaryResponse;
import com.shakil.ai_integrated_logger.service.GeminiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoggerController {
    private final GeminiService geminiService;

    public LoggerController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping("/summarize-logs")
    public LogSummaryResponse summarize(@RequestBody List<LogEntry> logs) throws Exception{
        return geminiService.summarizeLogs(logs);
    }
}
