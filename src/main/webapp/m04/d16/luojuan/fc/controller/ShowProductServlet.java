package fc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fc.dao.impl.BizDaoImpl;
import fc.entity.Page;
import fc.entity.Product;
import fc.servie.impl.BizServiceImpl;

/**
 * Servlet implementation class ShowProductServlet
 */
public class ShowProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
        BizDaoImpl bizdao = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizdao(bizdao);
        // List<Product> listproduct = bsi.getAllProduct();
        int count = bsi.getProductNumber();

        Page pg = new Page();
        pg.setSumsize(count);
        pg.setLastpage(pg.getSumsize() % pg.getPagesize() == 0 ? pg.getSumsize() % pg.getPagesize() : pg.getSumsize()
                / pg.getPagesize() + 1);
        pg.setCurrentpage(1);
        List<Product> listproduct = bsi.getAllProductByPage(pg);

        HttpSession session = request.getSession(false);
        session.setAttribute("listproduct", listproduct);
        session.setAttribute("pg", pg);
        request.getRequestDispatcher("Jsp_Proscenium/M_ShowProduct.jsp").forward(request, response);

    }

}
