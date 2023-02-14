package com.chatting.forms;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.chatting.beans.Discussion;
import com.chatting.dao.DaoFactory;
import com.chatting.dao.DiscussionDao;

public class DiscussionForm {

	 private DiscussionDao discussionDao;
		
	   Discussion discussion = new Discussion();
	  
	   public void addDiscussion(HttpServletRequest request) {
		    int myid;
		    Date date;
		    HttpSession session = request.getSession(false);
			DaoFactory daoFactory = DaoFactory.getInstance();
		    this.discussionDao = daoFactory.getDiscusssionDao();
		    discussion.setMessage(request.getParameter("message"));
		    discussion.setSujet(Integer.parseInt(request.getParameter("sujet")));
		    myid= (int) session.getAttribute("iduser");
		    long millis=System.currentTimeMillis();  
		    date= new java.sql.Date(millis);
	        discussion.setUser(myid);
	        discussion.setDate(date);
	        discussionDao.ajouter(discussion); 
	       
			
		}
}
