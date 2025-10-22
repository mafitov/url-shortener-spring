package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class URLService {

    @Value("${app.hashLength}")
    private int hashLength;

    private final Map<String, String> urls = new HashMap<>();

    private final RandomStringGenerator generator = new RandomStringGenerator.Builder()
            .withinRange('0', 'z')
            .filteredBy(Character::isLetterOrDigit)
            .build();

    public String getLongURL(String hash) {
        return urls.get(hash);
    }

    public String createShortURL(String uri, String longUrl) {
        String hash = generator.generate(hashLength);
        urls.put(hash, longUrl);
        return uri + hash;
    }

}
