package com.shakil.ai_integrated_logger.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shakil.ai_integrated_logger.request.LogEntry;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PromptBuilder {
    public String buildPrompt(List<LogEntry> logs, ObjectMapper mapper) throws Exception{
        return """
        You are an expert log analyzer.

        Analyze the following logs and return ONLY valid JSON.

        Output format:
       {
            "summary": "string",
            "key_error_signatures": ["string"],
            "patterns": ["string"],
            "root_cause": "string",
            "recommendation": "string"
        }

        Rules:
        - No explanation
        - No markdown
        - Only JSON
        - Be concise and accurate

        Logs:
        """ + mapper.writeValueAsString(logs);
    }


}
