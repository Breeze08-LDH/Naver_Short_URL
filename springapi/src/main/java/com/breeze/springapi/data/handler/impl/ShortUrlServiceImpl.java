package com.breeze.springapi.data.handler.impl;

import com.breeze.springapi.data.dao.ShortUrlDAO;
import com.breeze.springapi.data.dto.NaverUriDTO;
import com.breeze.springapi.data.dto.ShortUrlResponseDTO;
import com.breeze.springapi.data.repository.ShortUrlRedisRepository;
import com.breeze.springapi.service.ShortUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    private final Logger LOGGER = LoggerFactory.getLogger(ShortUrlServiceImpl.class);
    private final ShortUrlDAO shortUrlDAO;
    private final ShortUrlRedisRepository shortUrlRedisRepository;

    @Autowired
    public ShortUrlServiceImpl(ShortUrlDAO shortUrlDAO, ShortUrlRedisRepository shortUrlRedisRepository) {
        this.shortUrlDAO = shortUrlDAO;
        this.shortUrlRedisRepository = shortUrlRedisRepository;
    }





    @Override
    public ShortUrlResponseDTO getShortUrl(String client_Id, String client_Secret, String originalUrl) {
        return null;
    }

    @Override
    public ShortUrlResponseDTO generateShortUrl(String clientId, String clientSecret, String originalUrl) {

        LOGGER.info("[generateShortUrl] request data : {}", originalUrl);
        ResponseEntity<NaverUriDTO> responseEntity = requestShortUrl(clientId, clientSecret, originalUrl);

        String orgUrl = responseEntity.getBody().g



        return null;
    }








    @Override
    public ShortUrlResponseDTO udpateShortUrl(String client_Id, String client_Secret, String originalUrl) {
        return null;
    }

    @Override
    public ShortUrlResponseDTO deleteByShortUrl(String client_Id, String client_Secret, String originalUrl) {
        return null;
    }

    @Override
    public ShortUrlResponseDTO deleteOriginaltUrl(String client_Id, String client_Secret, String originalUrl) {
        return null;
    }





    private ResponseEntity<NaverUriDTO> requestShortUrl(String clientId, String clientSecret, String originalUrl) {
        LOGGER.info("[requestShortUrl] client ID : ***, client Secret : ***, original URL : {}", originalUrl);

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/util/shorturl")
                .queryParam("url", originalUrl)
                .encode()
                .build()
                .toUri();


        LOGGER.info("[requestShortUrl] set HTTP Request Header");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        HttpEntity<String> entity = new HttpEntity<>("", headers);

        RestTemplate restTemplate = new RestTemplate();

        LOGGER.info("[requestShortUrl] request by restTemplate");
        ResponseEntity<NaverUriDTO> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, NaverUriDTO.class);
        LOGGER.info("[requestShortUrl] request has been successfully complete.");

        return responseEntity;
    }








}
