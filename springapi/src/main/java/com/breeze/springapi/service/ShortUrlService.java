package com.breeze.springapi.service;

import com.breeze.springapi.data.dto.ShortUrlResponseDTO;

public interface ShortUrlService {
    ShortUrlResponseDTO getShortUrl(String client_Id, String client_Secret, String originalUrl);

    ShortUrlResponseDTO generateShortUrl(String client_Id, String client_Secret, String originalUrl);



    ShortUrlResponseDTO udpateShortUrl(String client_Id, String client_Secret, String originalUrl);
    ShortUrlResponseDTO deleteByShortUrl(String client_Id, String client_Secret, String originalUrl);
    ShortUrlResponseDTO deleteOriginaltUrl(String client_Id, String client_Secret, String originalUrl);
}
