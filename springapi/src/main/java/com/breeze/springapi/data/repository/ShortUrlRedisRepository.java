package com.breeze.springapi.data.repository;

import com.breeze.springapi.data.dto.ShortUrlResponseDTO;
import org.springframework.data.repository.CrudRepository;

public interface ShortUrlRedisRepository extends CrudRepository<ShortUrlResponseDTO, String > {

}
