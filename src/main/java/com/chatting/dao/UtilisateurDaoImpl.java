package com.chatting.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.chatting.beans.User;

public class UtilisateurDaoImpl implements UtilisateurDao {
	
	 private DaoFactory daoFactory;

	    UtilisateurDaoImpl(DaoFactory daoFactory){
	        this.daoFactory = daoFactory;
	    }

	    @Override
	    public void ajouter(User utilisateur){
	        Connection connexion = null; 
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO user(nom, prenom,telephone,email,login,password) VALUES(?, ?,?,?,?,?);");
	            preparedStatement.setString(1, utilisateur.getNom());
	            preparedStatement.setString(2, utilisateur.getPrenom());
	            preparedStatement.setString(3, utilisateur.getTelephone());
	            preparedStatement.setString(4, utilisateur.getEmail());
	            preparedStatement.setString(5, utilisateur.getLogin());
	            preparedStatement.setString(6, utilisateur.getPassword());

	            preparedStatement.executeUpdate();
	        } catch (SQLException e){
	            e.printStackTrace();
	            
	        }

	    }

	    @Override
	    public List<User> lister(){
	        List<User> utilisateurs = new ArrayList<User>();
	        Connection connexion = null;
	        Statement statement  = null;
	        ResultSet resultat   = null;

	        try{
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat  = statement.executeQuery("SELECT nom, prenom,telephone,email FROM user;");

	            while (resultat.next()){
	                String nom = resultat.getString("nom");
	                String prenom = resultat.getString("prenom");
	                String telephone = resultat.getString("telephone");
	                String email = resultat.getString("email");

	                User utilisateur = new User();
	                utilisateur.setNom(nom);
	                utilisateur.setPrenom(prenom);
	                utilisateur.setPrenom(telephone);
	                utilisateur.setPrenom(email);

	                utilisateurs.add(utilisateur);
	            }
	        } catch (SQLException e){
	            e.printStackTrace();
	        }
	        return utilisateurs;
	    }
	    
	    public List<User> connection(String $log,String $pass){
	        List<User> utilisateurs = new ArrayList<User>();
	        Connection connexion = null;
	      //  Statement statement  = null;
	        //ResultSet resultat   = null;

	        try{
	            connexion = daoFactory.getConnection();
	            
	            //statement = connexion.createStatement();
	            //resultat  = statement.executeQuery("SELECT nom, prenom,telephone,email FROM user where login='"+$log);
	            
	            String sql = "SELECT * FROM user WHERE login = ? and password = ?";
	            PreparedStatement statement = connexion.prepareStatement(sql);
	            statement.setString(1, $log);
	            statement.setString(2, $pass);
	     
	            ResultSet resultat = statement.executeQuery();
	            while (resultat.next()){
	                String nom = resultat.getString("nom");
	                String prenom = resultat.getString("prenom");
	                String telephone = resultat.getString("telephone");
	                String email = resultat.getString("email");
	                Integer id = resultat.getInt("id");


	                User utilisateur = new User();
	                utilisateur.setNom(nom);
	                utilisateur.setPrenom(prenom);
	                utilisateur.setTelephone(telephone);
	                utilisateur.setEmail(email);
	                utilisateur.setId(id);
	                utilisateurs.add(utilisateur);
	            }
	        } catch (SQLException e){
	            e.printStackTrace();
	        }
	        return  utilisateurs; 
	    }


}
