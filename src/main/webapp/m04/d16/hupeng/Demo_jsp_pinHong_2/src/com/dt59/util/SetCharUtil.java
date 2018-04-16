/**
 * Project Name:Demo_jsp_pinHong_1
 * File Name:SetCharUtil.java
 * Package Name:com.dt59.util
 * Date:2018年4月16日下午2:14:24
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:   <br/>
 * Date:     2018年4月16日 下午2:14:24 <br/>
 * @author   hupeng
 * @version
 * @see
 */
public class SetCharUtil  implements  Filter{

	@Override
	public void destroy() {
		
		//  Auto-generated method stub
		System.out.println("被摧毁了");
	}

	@Override
	/**
	 * *
	 *@param  arg0:ServletRequest(request) arg1 arg2
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		//  Auto-generated method stub
		HttpServletRequest  request=(HttpServletRequest)arg0;
		HttpServletResponse  response=(HttpServletResponse)arg1;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		//  Auto-generated method stub
		System.out.println("过滤器已经初始化");
	}

}

