package com.wq.redis;

import redis.clients.jedis.Jedis;

public class testGetCache {

    public static void main(String[] args) {
    	Jedis Jedis = new Jedis("192.168.8.130", 6379);
    	Jedis.isConnected();
    	RedisCacheUtil a = new RedisCacheUtil();
    	a.setCacheObject("wangqi", 2);
    }
}
