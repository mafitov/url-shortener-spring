# URL Shortener
A lightweight and efficient URL Shortener built with Spring Boot.
It provides REST APIs to shorten long URLs and redirect users via short hashes.
The service uses a simple hash-based algorithm and can easily integrate with databases or caching layers.

## Features

* Shorten long URLs into compact hash-based identifiers
* Redirect users to original URLs via short links
* Validate and normalize input URLs
* Configurable expiration and cleanup policies
* Detailed logging for tracing and debugging
* Easily extensible for analytics and rate limiting

## Tech Stack

* **Java 21+**
* **Spring Boot 3+**
* **Maven**
* **Slf4j / Logback** for logging

## Configuration

You can adjust rate-limiting parameters in `application.yml`:

```yaml
app:
  hashLength: 10 # length of generated hash
```

## Running the Application

```bash
mvn clean install
mvn spring-boot:run
