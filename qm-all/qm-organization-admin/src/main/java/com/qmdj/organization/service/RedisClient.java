package com.qmdj.organization.service;

import redis.clients.jedis.Jedis;

public interface RedisClient {

    public	Jedis getJedis();

}
