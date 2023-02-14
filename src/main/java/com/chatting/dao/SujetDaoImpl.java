package com.chatting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chatting.beans.Sujet;

public class SujetDaoImpl implements SujetDao{
	
	 private DaoFactory daoFactory;

	    SujetDaoImpl(DaoFactory daoFactory){
	        this.daoFactory = daoFactory;
	    }

	    @Override
	    public void ajouter(Sujet sujet){
	        Connection connexion = null; 
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO sujet(libelle, user) VALUES(?, ?);");
	            preparedStatement.setString(1, sujet.getLibelle());
	            preparedStatement.setInt(2, sujet.getUser());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e){
	            e.printStackTrace();
	            
	        }

	    }

	    @Override
	    public List<Sujet> lister(){
	        List<Sujet> sujets = new ArrayList<Sujet>();
	        Connection connexion = null;
	        Statement statement  = null;
	        ResultSet resultat   = null;

	        try{
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat  = statement.executeQuery("SELECT * FROM sujet INNER JOIN user ON sujet.user = user.id order by sujet.id desc;");

	            while (resultat.next()){
	            	String libelle = resultat.getString("libelle");
	                String nom = resultat.getString("nom");
	                String prenom = resultat.getString("prenom");
	                int id=resultat.getInt("id");
	                Sujet sujet = new Sujet();
	                sujet.setId(id);
	                sujet.setLibelle(libelle);
	                sujet.setUsernom(nom);
	                sujet.setUserprenom(prenom);
	                sujets.add(sujet);
	            }
	        } catch (SQLException e){
	            e.printStackTrace();
	        }
	        return sujets;
	    }
	    
	    public List<Sujet> sujetbyId(int $id){
	        List<Sujet> sujets = new ArrayList<Sujet>();
	        Connection connexion = null;
	       
	        try{
	            connexion = daoFactory.getConnection();
	            String sql  = "SELECT * FROM sujet INNER JOIN user ON sujet.user = user.id WHERE sujet.id = ?";
	            PreparedStatement statement = connexion.prepareStatement(sql);
	            statement.setInt(1, $id);
	    
	            ResultSet resultat = statement.executeQuery();

	            while (resultat.next()){
	            	String libelle = resultat.getString("libelle");
	                String nom = resultat.getString("nom");
	                String prenom = resultat.getString("prenom");
	                Sujet sujet = new Sujet();
	                sujet.setLibelle(libelle);
	                sujet.setUsernom(nom);
	                sujet.setUserprenom(prenom);
	                sujets.add(sujet);
	              
	            }
	        } catch (SQLException e){
	            e.printStackTrace();
	        }
	        return sujets;
	    }

}
