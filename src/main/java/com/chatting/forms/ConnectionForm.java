package com.chatting.forms;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.chatting.beans.User;
import com.chatting.dao.DaoFactory;
import com.chatting.dao.UtilisateurDao;

public class ConnectionForm {
  
   private UtilisateurDao utilisateurDao;
	
	private String resultat;
	private int iduser;
	private List<User> currentuser = new ArrayList<User>();
	//private Integer myuser;


	private String url; 

  
	
	public void verifierIdentifiants(HttpServletRequest request) {
		DaoFactory daoFactory = DaoFactory.getInstance();
	    this.utilisateurDao = daoFactory.getUtilisateurDao();
		String login = request.getParameter("login");
		String pass = request.getParameter("password");		
		this.currentuser=this.utilisateurDao.connection(login,pass);

		if(this.currentuser.isEmpty()) {
			resultat="Identifiant incorrect !";
			url="login.jsp";
			
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("nom", this.currentuser.get(0).getNom());
			session.setAttribute("prenom", this.currentuser.get(0).getPrenom());
			session.setAttribute("iduser", this.currentuser.get(0).getId());
			iduser=this.currentuser.get(0).getId();
			resultat="Vous étes bien connecté !" ;
			url="accueil.jsp";
		} 
	}

	

	public int getIduser() {
		return iduser;
	}



	public void setIduser(int iduser) {
		this.iduser = iduser;
	}



	public List<User> getCurrentuser() {
		return currentuser;
	}

	public void setCurrentuser(List<User> currentuser) {
		this.currentuser = currentuser;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
