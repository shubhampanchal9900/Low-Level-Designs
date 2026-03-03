package com.bigHead;

public interface RateLimiter {

    RateLimitResult allowRequest(String userId,String tier);
}
