package com.chatting.forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.chatting.beans.Sujet;
import com.chatting.dao.DaoFactory;
import com.chatting.dao.SujetDao;

public class SujetForm  {
 
	   private SujetDao sujetDao;
		
	   Sujet sujet = new Sujet();
	  
	   public void addSujet(HttpServletRequest request) {
		    int myid;
		    HttpSession session = request.getSession(false);
			DaoFactory daoFactory = DaoFactory.getInstance();
		    this.sujetDao = daoFactory.getSujetDao();
		    sujet.setLibelle(request.getParameter("libelle"));
		    myid= (int) session.getAttribute("iduser");
	        sujet.setUser(myid);
	        sujetDao.ajouter(sujet); 
	       
			
		}
	   

		
}
