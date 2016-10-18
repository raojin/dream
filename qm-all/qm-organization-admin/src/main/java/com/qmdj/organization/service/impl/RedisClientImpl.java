package com.qmdj.organization.service.impl;

import org.springframework.stereotype.Service;

import com.qmdj.organization.service.RedisClient;

import redis.clients.jedis.Jedis;

/**
*@Description: redis简单处理,后面优化
*@author chenjin
*@date 2016/10/12
*/

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
