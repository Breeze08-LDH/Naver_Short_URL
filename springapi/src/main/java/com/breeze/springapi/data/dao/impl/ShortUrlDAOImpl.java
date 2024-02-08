package com.breeze.springapi.data.dao.impl;

import com.breeze.springapi.data.dao.ShortUrlDAO;
import com.breeze.springapi.data.entity.ShortUrlEntity;
import com.breeze.springapi.data.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShortUrlDAOImpl implements ShortUrlDAO {
    private final ShortUrlRepository shortUrlRepository;

    @Autowired
    public ShortUrlDAOImpl(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    @Override
    public ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrlEntity) {
        ShortUrlEntity foundShortUrl = shortUrlRepository.save(shortUrlEntity);
        return foundShortUrl;
    }

    @Override
    public ShortUrlEntity getShortUrl(String originalUrl) {
        ShortUrlEntity foundShortUrl = shortUrlRepository.findByOrgUrl(originalUrl);
        return foundShortUrl;
    }

    @Override
    public ShortUrlEntity getOriginalUrl(String shortUrl) {
        ShortUrlEntity foundShortUrl = shortUrlRepository.findByUrl(shortUrl);
        return foundShortUrl;
    }
}
