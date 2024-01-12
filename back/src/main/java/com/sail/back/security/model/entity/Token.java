package com.sail.back.security.model.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@Builder
@RedisHash(value = "jwtToken", timeToLive = 604800)
public class Token implements Serializable {
    @Id
    private Long id;

    @Indexed
    private String accessToken;

    private String refreshToken;
}
