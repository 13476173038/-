/**
 * Project Name:Demo_jsp_Shopping
 * File Name:TokenUtil.java
 * Package Name:com.dt59.util
 * Date:2018年4月22日下午10:42:35
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.util;

import java.util.UUID;

/**
 * Description:   <br/>
 * Date:     2018年4月22日 下午10:42:35 <br/>
 * @author   hupeng
 * @version
 * @see
 */
public class TokenUtil {
    private TokenUtil(){}
    static TokenUtil tu=null;
    public static TokenUtil getInstance(){
		if (tu==null) {
			tu=new TokenUtil();
		}    	
    	return tu;   	
    }
    public synchronized String get_token(){
		return UUID.randomUUID().toString();
    	
    }
}

