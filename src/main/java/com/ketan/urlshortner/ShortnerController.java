package com.ketan.urlshortner;

import com.ketan.urlshortner.model.URL;
import com.ketan.urlshortner.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
public class ShortnerController {

    @Autowired
    private AppService service;

    @PostMapping("/shortURL")
    public String shortURL(@RequestBody URL url){
        String shortCode = randomCode(6);
        url.setShortURL(shortCode);
        service.addUrlObject(url);
        return "https://tinycut-pbtb.onrender.com" + shortCode;
    }

    private String randomCode(int length) {
        String alphabets = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYS";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            int index = (int) (Math.random() * alphabets.length());
            sb.append(alphabets.charAt(index));
        }
        return sb.toString();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> Redirect(@PathVariable String code){
        String longURL = service.getURL(code);
        if(!Objects.equals(longURL, "Not Found!"))
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longURL)).build();
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).location(URI.create("https://tinycut-pbtb.onrender.com/shortURL")).build();
    }

    @GetMapping("/health")
    public String health(){
        return "Server is running!";
    }

}
