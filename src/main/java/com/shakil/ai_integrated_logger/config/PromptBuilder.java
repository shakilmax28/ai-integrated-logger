package com.shakil.ai_integrated_logger.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shakil.ai_integrated_logger.request.LogEntry;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PromptBuilder {
    public String buildPrompt(List<LogEntry> logs, ObjectMapper mapper) throws Exception{
        return """
                You are an expert backend reliability engineer.
                        
                Analyze the provided logs and return ONLY a valid JSON object.
                        
                Strict Output Rules:
                        
                * Output must be valid JSON (no trailing commas)
                * Do NOT include any text before or after the JSON
                * Do NOT use markdown or code blocks
                * If information is missing, use "unknown" instead of guessing
                * Keep responses concise and factual
                        
                Output format:
                {
                "summary": "string",
                "key_error_signatures": ["string"],
                "patterns": ["string"],
                "root_cause": "string",
                "recommendation": "string"
                }
                        
                Guidelines:
                        
                * "summary": brief overview of the issue
                * "key_error_signatures": exact or near-exact error messages
                * "patterns": repeated behaviors or trends in logs
                * "root_cause": most likely underlying issue
                * "recommendation": clear and actionable fix
                        
                Logs:
        """ + mapper.writeValueAsString(logs);
    }


}
