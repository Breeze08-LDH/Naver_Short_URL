package com.breeze.springapi.service;

import com.breeze.springapi.data.dto.ShortUrlResponseDTO;

public interface ShortUrlService {
    ShortUrlResponseDTO getShortUrl(String clientId, String clientSecret, String originalUrl);

    ShortUrlResponseDTO generateShortUrl(String clientId, String clientSecret, String originalUrl);



    ShortUrlResponseDTO udpateShortUrl(String clientId, String clientSecret, String originalUrl);
    ShortUrlResponseDTO deleteByShortUrl(String clientId, String clientSecret, String originalUrl);
    ShortUrlResponseDTO deleteOriginaltUrl(String clientId, String clientSecret, String originalUrl);
}
