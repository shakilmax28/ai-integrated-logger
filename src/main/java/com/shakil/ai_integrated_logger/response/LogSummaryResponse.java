package com.shakil.ai_integrated_logger.response;

import lombok.Data;
import java.util.List;

@Data
public class LogSummaryResponse {
    private String summary;
    private List<String> key_error_signatures;
    private List<String> patterns;
    private String root_cause;
    private String recommendation;
}
