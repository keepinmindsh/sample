package com.lines.redis.code;

public enum RedisType {
    LINES_REDIS_KEY("LINES:LOGS");

    private final String key;

    RedisType(String key){
        this.key = key;
    }
}
