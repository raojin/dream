package com.qmdj.biz.util.core;

public class QmdjUtils {
	
	public static String getCode(Integer value) {
		if(value==1){
			return "O"+System.currentTimeMillis();
		}
		return "T"+System.currentTimeMillis();
	}

}
