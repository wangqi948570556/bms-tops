package com.wq.redis;

import java.util.LinkedList;

import redis.clients.jedis.Jedis;

public class testGetCache {

    public static void main(String[] args) {
    	Jedis jedis = new Jedis("192.168.8.130", 6379);
//    	Jedis.isConnected();
//    	RedisCacheUtil a = new RedisCacheUtil();
//    	a.setCacheObject("wangqi", 2);
//    	Jedis.set("wangqi", "34");
        RedisPoolUtil s = new RedisPoolUtil();
    	LinkedList<String> queue = new LinkedList<String>();
    	  queue.add("fdsafds");
    	  queue.add("3333");
    	  queue.add("fd32");
    	  queue.add("5555");
    	  System.out.println(queue.get(2));
    }
}
