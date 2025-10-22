package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class URLResponse {

    @JsonProperty("shortURL")
    private String shortURL;

}
