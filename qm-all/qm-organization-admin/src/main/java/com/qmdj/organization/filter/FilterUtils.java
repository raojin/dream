package com.qmdj.organization.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import com.qmdj.biz.dao.UserDAO;
import com.qmdj.biz.util.core.Constant;

public class FilterUtils implements MethodInterceptor {
	private static final Logger log = Logger  
		    .getLogger(FilterUtils.class);  
		  
		    @Override  
		    public Object invoke(MethodInvocation invocation) throws Throwable {  
		        log.info("拦截开始！");  
		        Object[] args = invocation.getArguments();    
		        HttpServletRequest request = null;  
		        HttpServletResponse response = null;  
		        UserDAO mapping = null;  
		        for (int i = 0 ; i < args.length ; i++ )    {  
		          if (args[i] instanceof HttpServletRequest) request = (HttpServletRequest)args[i];     
		          if (args[i] instanceof HttpServletResponse) response = (HttpServletResponse)args[i];     
		          if (args[i] instanceof UserDAO) mapping = (UserDAO)args[i];     
		        }  
		        if (request != null && mapping != null) {  
		            String url=request.getRequestURI();     
		            HttpSession session = request.getSession(true);       
//		            String usercode =request.getRemoteUser();// 登录人  
		            String user = (String)session.getAttribute(Constant.SESSION_BEAN);//登录人
		              
		            if (user == null || user.equals("")) {  
		            	
		            	return 0;
//		                if ( url.indexOf("Login")<0 && url.indexOf("login")<0 ) {  
//		                      
//		                    return mapping.queryUserByUserId(1);
//		                }    
//		                return invocation.proceed();   
		            }else {  
		                return invocation.proceed();  
		            }  
		        }  
		        else {  
		            return invocation.proceed();  
		        }  
		    }  

}
