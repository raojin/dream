package com.qmdj.org.service;

import redis.clients.jedis.Jedis;

public interface RedisClient {

    public	Jedis getJedis();

}
