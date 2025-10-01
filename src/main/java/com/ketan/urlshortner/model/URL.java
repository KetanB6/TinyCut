package com.ketan.urlshortner.model;

import org.springframework.stereotype.Component;

@Component
public class URL {
    private String shortURL;
    private String longURL;

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }
}
