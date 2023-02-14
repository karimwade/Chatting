package com.chatting.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chatting.dao.DaoFactory;
import com.chatting.dao.DiscussionDao;
import com.chatting.dao.SujetDao;
import com.chatting.forms.DiscussionForm;

public class Discussion extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	
	private DiscussionDao discussionDao;
	private SujetDao sujetdao;


    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.discussionDao = daoFactory.getDiscusssionDao();
        this.sujetdao=daoFactory.getSujetDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("sujets", sujetdao.lister());
        if(request.getParameter("sujet")!=null) {
        	 int sujet = Integer.parseInt(request.getParameter("sujet"));
     	    request.setAttribute("currentsujet", sujetdao.sujetbyId(sujet));
     	   request.setAttribute("discussions", discussionDao.getdiscussion(sujet));
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/discussion.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    
         DiscussionForm form = new DiscussionForm();
		 form.addDiscussion(request);
		 int sujet = Integer.parseInt(request.getParameter("sujet"));
	     request.setAttribute("name", sujet);
		 request.setAttribute("form", form); 
		 request.setAttribute("sujets", sujetdao.lister());
		 request.setAttribute("currentsujet", sujetdao.sujetbyId(sujet));
		 request.setAttribute("discussions", discussionDao.getdiscussion(sujet));
      
        this.getServletContext().getRequestDispatcher("/WEB-INF/discussion.jsp").forward(request, response);
    }


}
