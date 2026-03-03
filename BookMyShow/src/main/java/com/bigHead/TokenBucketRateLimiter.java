public RateLimitResult allowRequest(String userId, String tier) {
    // Step 1: Get config
    RateLimiterConfig config = configByTier.get(tier);

    // Step 2: Fetch from Redis
    String key = "ratelimit:" + userId + ":" + tier;
    BucketState state = redis.get(key);  // {tokens, lastRefillTimestamp}

    // Step 3: Calculate new tokens
    long currentTime = System.currentTimeMillis();
    double timeElapsedInSeconds = (currentTime - state.lastRefillTimestamp) / 1000.0;
    double newTokens = state.tokens + (timeElapsedInSeconds * config.refillRate);

    // Step 4: Cap at capacity (IMPORTANT!)
    newTokens = Math.min(newTokens, config.capacity);

    // Step 5: Check if request allowed
    if (newTokens >= 1.0) {
        // ALLOW request
        newTokens = newTokens - 1.0;

        // Update Redis
        state.tokens = newTokens;
        state.lastRefillTimestamp = currentTime;
        redis.set(key, state);

        return new RateLimitResult(true, 0, newTokens);
    } else {
        // REJECT request
        double retryAfter = (1.0 - newTokens) / config.refillRate;
        return new RateLimitResult(false, retryAfter, newTokens);
    }
}