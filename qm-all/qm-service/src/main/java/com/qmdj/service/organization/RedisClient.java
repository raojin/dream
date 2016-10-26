package com.qmdj.service.organization;

import redis.clients.jedis.Jedis;

public interface RedisClient {

    public	Jedis getJedis();

}
