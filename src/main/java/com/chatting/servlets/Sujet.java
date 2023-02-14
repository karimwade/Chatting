package com.chatting.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chatting.dao.DaoFactory;
import com.chatting.dao.SujetDao;
import com.chatting.forms.SujetForm;


/**
 * Servlet implementation class Sujet
 */
//@WebServlet("/Sujet")
public class Sujet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private SujetDao sujetDao;

	 public void init() throws ServletException {
	        DaoFactory daoFactory = DaoFactory.getInstance();
	        this.sujetDao = daoFactory.getSujetDao();
	 }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sujet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("sujets", sujetDao.lister());
        this.getServletContext().getRequestDispatcher("/WEB-INF/sujet.jsp").forward(request, response);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 SujetForm form = new SujetForm();
		 form.addSujet(request);
		 request.setAttribute("form", form); 
         request.setAttribute("sujets", sujetDao.lister());
      
        this.getServletContext().getRequestDispatcher("/WEB-INF/sujet.jsp").forward(request, response);
	}

}
