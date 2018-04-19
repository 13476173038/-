package com.dt59.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.shangping;
import com.dt59.service.impl.BizServiceImpl;

/**
 * Servlet implementation class ShoppingServlet
 */
@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Map<Integer,shangping >  map=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map=new HashMap<Integer,shangping >();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html");
	    BizDaoImpl bizdao=new BizDaoImpl();
		BizServiceImpl bsi=new BizServiceImpl();
		bsi.setBizdao(bizdao);
	    PrintWriter out=response.getWriter();
	    HttpSession session=request.getSession();
	    Object  obj=session.getAttribute("loginName");
	    String  sid=request.getParameter("sid");
	    Integer id=Integer.valueOf(sid);
	    if(obj!=null){
	    	shangping sp=bizdao.getShangpingById(Integer.valueOf(sid));
	    	if(map.containsKey(id)){
	    		sp.setNum(map.get(id).getNum()+1);
	    		map.put(id, sp);
	    	}else{
	    		map.put(id, sp);
	    	}
	    	
	    	//request.setAttribute("sp",sp );  
	    	request.setAttribute("map",map );
	    	request.getRequestDispatcher("show.jsp").forward(request, response);
	    }else{
	    	out.print("<script>");
			out.print("alert('尚未登录，请先登录');");
			out.print("window.location.href='init';");			
			out.print("</script>");
			out.flush();
			out.close();	
	    	}
	   
	    
	
	
	}

}
