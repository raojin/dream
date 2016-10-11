package com.service;

import redis.clients.jedis.Jedis;

public interface RedisClient {

    public	Jedis getJedis();

}
