package com.bigHead;


//
//@Getter
//@Setter
public class RateLimitConfig {
    private int capacity;
    private int refillRate;

    RateLimitConfig(int capacity,int refillRate){
        this.capacity=capacity;
        this.refillRate=refillRate;
    }
}
