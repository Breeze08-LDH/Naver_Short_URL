package com.breeze.springapi.controller;

import com.breeze.springapi.data.dto.ShortUrlResponseDTO;
import com.breeze.springapi.service.ShortUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/short-url")
public class ShortUrlController {
    private final Logger LOGGER = LoggerFactory.getLogger(ShortUrlController.class);

    @Value("${breeze.spring.short.url.id}")
    private String CLIENT_ID;

    @Value("${breeze.spring.short.url.secret}")
    private String CLIENT_SECRET;

    ShortUrlService shortUrlService;

    @Autowired
    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @PostMapping("/")
    public ShortUrlResponseDTO generateShortUrl(String originalUrl) {
        LOGGER.info("[C][generateShortUrl] perform API. CLIENT_ID:[{}], CLIENT_SECRET:[{}]. originalUrl:[{}]", CLIENT_ID, CLIENT_SECRET, originalUrl);
        return shortUrlService.generateShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl);
    }

    @GetMapping("/")
    public ShortUrlResponseDTO getShortUrl(String originalUrl) {
        return shortUrlService.getShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl);
    }

}

