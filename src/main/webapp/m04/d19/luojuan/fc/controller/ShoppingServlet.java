package fc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fc.dao.impl.BizDaoImpl;
import fc.entity.Shangping;
import fc.service.impl.BizServiceImpl;

/**
 * Servlet implementation class ShoppingServlet
 */
public class ShoppingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("loginName");
        String sid = request.getParameter("sid");
        BizDaoImpl bizdao = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizdao(bizdao);
        if (obj != null) {
            Shangping sp = bsi.getShangpingById(Integer.valueOf(sid));
            request.setAttribute("sp", sp);
            request.getRequestDispatcher("show.jsp").forward(request, response);
        } else {
            out.print("<script>");
            out.print("alert('您好，请先登录！')");
            out.print("window.location.href='init';");
            out.print("</script>");
            out.flush();
            out.close();

        }
    }

}
