# 🚀 AI Integrated Logger

An AI-powered log analysis service built with Spring Boot that summarizes logs, detects patterns, and suggests actionable recommendations using the Gemini API.

---

## 📌 Overview

`ai-integrated-logger` is a backend service designed to help developers and DevOps engineers quickly understand application logs. The codebase is structured using separation of concerns principles in a Spring Boot application, making it easier to navigate and maintain. Instead of manually scanning logs, this service uses AI to:

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

curl "http://localhost:8080/summarize-logs" -H "Content-Type: application/json" -d "[{\"timestamp\":\"2025-10-15T10:00:05Z\",\"level\":\"ERROR\",\"service\":\"payment-service\",\"message\":\"Database connection timed out after 3001ms\"}]"


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
<LOGS_JSON_ARRAY>
