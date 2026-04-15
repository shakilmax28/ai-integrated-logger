package com.shakil.ai_integrated_logger.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class LogEntry implements Serializable {
    private String timestamp;
    private String level;
    private String service;
    private String message;
}
