package com.sail.back.security.model.repository;

import com.sail.back.security.model.entity.Token;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<Token, Long> {
}
