package com.dt59.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
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

@WebServlet("/InitService")
public class InitServlet extends HttpServlet {

    public InitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    public void destroy() {
        // TODO Auto-generated method stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
        BizDaoImpl bizdao = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizDao(bizdao);
        List<News> listnews = bsi.getAllNews();
        // request.setAttribute("listnews", listnews);
        // null true false null=true创建一个session false：检测 有就直接用 没有创建一个
        HttpSession session = request.getSession();
        session.setAttribute("listnews", listnews);
        List<Product> listpro = bsi.getAllProduct();
        session.setAttribute("listpro", listpro);
        request.getRequestDispatcher("Jsp_Proscenium/M_Index.jsp").forward(request, response);
    }
}
