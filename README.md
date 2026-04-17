# 🚀 AI Integrated Logger

An AI-powered log analysis service built with Spring Boot that summarizes logs, detects patterns, and suggests actionable recommendations using the Gemini API.

---

## 📌 Overview

`ai-integrated-logger` is a backend service designed to help developers and DevOps engineers quickly understand application logs. Instead of manually scanning logs, this service uses AI to:

- Generate concise summaries
- Identify key error signatures
- Detect recurring patterns
- Suggest root causes
- Provide recommendations

---

## ⚙️ Prerequisites

Make sure you have the following installed:

- Java 21
- Gradle 8.0+
- A valid Gemini API Key

### 🔑 Environment Setup

Set your Gemini API key as an environment variable:

**Windows (PowerShell):**
setx GEMINI_API_KEY "your_api_key_here"


**Linux/macOS:**
export GEMINI_API_KEY=your_api_key_here


---

## 🛠️ Build & Run

### 1. Build the Application
gradle clean bootJar


### 2. Run the Application
java -jar ./build/libs/ai-integrated-logger-0.0.1-SNAPSHOT.jar

The application will start at:
http://localhost:8080


---

## 📡 API Usage

### Endpoint

POST /summarize-logs


### Example Request (cURL)

curl --location 'http://localhost:8080/summarize-logs' --header 'Content-Type: application/json' --data '[{"timestamp": "2025-10-15T10:00:05Z","level": "ERROR","service": "payment-service","message": "Database connection timed out after 3001ms"}]'


---

## 📤 Response Format

The API returns strict JSON:

```json
{
  "summary": "string",
  "key_error_signatures": ["string"],
  "patterns": ["string"],
  "root_cause": "string",
  "recommendation": "string"
}
```

---

## 📤 Prompt Text

You are an expert backend reliability engineer.

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

Logs: <ARRAY OF LOGS>