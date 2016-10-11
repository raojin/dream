package com.service.impl;

import org.springframework.stereotype.Service;

import com.service.RedisClient;

import redis.clients.jedis.Jedis;

@Service
public class RedisClientImpl implements RedisClient{
	
  private Jedis jedis=null;

  public RedisClientImpl(){
	   if(jedis==null){
		   jedis=new Jedis("127.0.0.1", 6379);
	   }
   }
   
  public Jedis getJedis(){
	   if(jedis==null){
		   jedis=new Jedis("127.0.0.1", 6379);
	   }
	   return jedis;
   }
   
}
