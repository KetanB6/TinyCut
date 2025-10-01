package com.ketan.urlshortner.service;

import com.ketan.urlshortner.model.URL;
import com.ketan.urlshortner.repo.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Autowired
    UrlRepo repo;

    public void addUrlObject(URL url) {
        if(repo.save(url)){
            System.out.println("Inserted");
        } else {
            System.out.println("Failed, may be code already exist.");
        }
    }

    public String getURL(String code){
        for(URL url: repo.getURL(code)){
            if(url.getShortURL().equals(code)){
                return url.getLongURL();
            }
        }
        return "Not Found!";
    }
}
