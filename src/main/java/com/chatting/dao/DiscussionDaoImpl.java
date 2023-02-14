package com.chatting.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chatting.beans.Discussion;

public class DiscussionDaoImpl implements DiscussionDao{ 
	
	 private DaoFactory daoFactory;

	    DiscussionDaoImpl(DaoFactory daoFactory){
	        this.daoFactory = daoFactory;
	    }

	    @Override
	    public void ajouter(Discussion discussion){
	        Connection connexion = null; 
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO discussion(sujet, message,user,date) VALUES(?, ?, ?,?);");
	            preparedStatement.setInt(1, discussion.getSujet());
	            preparedStatement.setString(2, discussion.getMessage());
	            preparedStatement.setInt(3, discussion.getUser());
	            preparedStatement.setDate(4, (Date) discussion.getDate());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e){
	            e.printStackTrace();
	            
	        }

	    }

	    @Override
	    public List<Discussion> lister(){
	        List<Discussion> discussions = new ArrayList<Discussion>();
	        Connection connexion = null;
	        Statement statement  = null;
	        ResultSet resultat   = null;

	        try{
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat  = statement.executeQuery("SELECT * FROM discussion INNER JOIN user ON discussion.user = user.id;");

	            while (resultat.next()){
	            	String message = resultat.getString("message");
	                String nom = resultat.getString("nom");
	                String prenom = resultat.getString("prenom");
	                Discussion discussion = new Discussion();
	                discussion.setMessage(message);
	                discussion.setUsernom(nom);
	                discussion.setUserprenom(prenom);
	                discussions.add(discussion);
	            }
	        } catch (SQLException e){
	            e.printStackTrace();
	        }
	        return discussions;
	    }
	    
	    public List<Discussion> getdiscussion(int $id){
	        List<Discussion> discussions = new ArrayList<Discussion>();
	        Connection connexion = null;


	        try{
	            connexion = daoFactory.getConnection();
	     
	            String sql = "SELECT * FROM discussion INNER JOIN user ON discussion.user = user.id WHERE sujet = ? order by discussion.id desc";
	            PreparedStatement statement = connexion.prepareStatement(sql);
	            statement.setInt(1, $id);
	    
	            ResultSet resultat = statement.executeQuery();

	            while (resultat.next()){
	            	String message = resultat.getString("message");
	                String nom = resultat.getString("nom");
	                String prenom = resultat.getString("prenom");
	                Discussion discussion = new Discussion();
	                discussion.setMessage(message);
	                discussion.setUsernom(nom);
	                discussion.setUserprenom(prenom);
	                discussions.add(discussion);
	            }
	        } catch (SQLException e){
	            e.printStackTrace();
	        }
	        return discussions;
	    }

}
