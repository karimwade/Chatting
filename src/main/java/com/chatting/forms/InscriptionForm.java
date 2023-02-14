package com.chatting.forms;
import javax.servlet.http.HttpServletRequest;


import com.chatting.beans.User;
import com.chatting.dao.DaoFactory;
import com.chatting.dao.UtilisateurDao;

public class InscriptionForm {
	
	    private UtilisateurDao utilisateurDao;
		
		private String resultat;
		User utilisateur = new User();


	  
		
		public String getResultat() {
			return resultat;
		}




		public void setResultat(String resultat) {
			this.resultat = resultat;
		}




		public void addUser(HttpServletRequest request) {
			DaoFactory daoFactory = DaoFactory.getInstance();
		    this.utilisateurDao = daoFactory.getUtilisateurDao();
		    utilisateur.setNom(request.getParameter("nom"));
	        utilisateur.setPrenom(request.getParameter("prenom"));
	        utilisateur.setTelephone(request.getParameter("telephone"));
	        utilisateur.setEmail(request.getParameter("email"));
	        utilisateur.setLogin(request.getParameter("login"));
	        utilisateur.setPassword(request.getParameter("password"));
	        utilisateurDao.ajouter(utilisateur);
	        
	        resultat="Inscription reussi,veuillez vous connecter  !";
			
		}

		


}
