package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.URLRequest;
import org.example.model.URLResponse;
import org.example.service.URLService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@AllArgsConstructor
public class URLController {

    URLService urlService;

    @GetMapping("/{hash}")
    public ResponseEntity<URLResponse> getLongURL(@PathVariable("hash")  String hash) {
        log.info("Get short URL for: {}", hash);

        String longUrl = urlService.getLongURL(hash);

        if (longUrl == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .header("location", longUrl)
                .build();
    }

    @PostMapping("/")
    public ResponseEntity<URLResponse> createShortURL(@RequestBody URLRequest urlRequest, HttpServletRequest request) {
        log.info("Create short URL for:{}", urlRequest.getLongUrl());

        String shortUrl = urlService.createShortURL(request.getRequestURL().toString(), urlRequest.getLongUrl());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(URLResponse.builder()
                        .shortURL(shortUrl)
                        .build());
    }

}
