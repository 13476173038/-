package com.dt59.initService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.News;
import com.dt59.entity.Product;
import com.dt59.service.impl.BizServiceImpl;

/**
 * Servlet implementation class InitService
 */
@WebServlet("/InitService")
public class InitService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitService() {
        super();
        // TODO Auto-generated constructor stub
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
		BizDaoImpl bizDao=new BizDaoImpl();
		BizServiceImpl bsi=new BizServiceImpl();
		bsi.setBizDao(bizDao);
		List<News> list=(List<News>)bsi.getAllNews();
//		request.setAttribute("list",list);
		HttpSession session=request.getSession();
		session.setAttribute("list", list);
		request.getRequestDispatcher("Jsp_Proscenium/M_Index.jsp").forward(request, response);
		List<Product> prolist=(List<Product>)bsi.getAllProduct();
		session.setAttribute("prolist", prolist);
		request.getRequestDispatcher("Jsp_Proscenium/ProductList.jsp").forward(request, response);
	}

}
