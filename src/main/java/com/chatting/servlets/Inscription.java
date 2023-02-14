package com.chatting.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chatting.dao.*;
import com.chatting.forms.InscriptionForm;

/**
 * Servlet implementation class Inscription
 */
//@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtilisateurDao utilisateurDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.utilisateurDao = daoFactory.getUtilisateurDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setAttribute("utilisateurs", utilisateurDao.lister());
        this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*User utilisateur = new User();
        utilisateur.setNom(request.getParameter("nom"));
        utilisateur.setPrenom(request.getParameter("prenom"));
        utilisateur.setTelephone(request.getParameter("telephone"));
        utilisateur.setEmail(request.getParameter("email"));
        utilisateur.setLogin(request.getParameter("login"));
        utilisateur.setPassword(request.getParameter("password"));
        utilisateurDao.ajouter(utilisateur);*/
        InscriptionForm form = new InscriptionForm();
		 form.addUser(request);
		 request.setAttribute("form", form); 
        //request.setAttribute("utilisateurs", utilisateurDao.lister());
      
        this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
    }

}
