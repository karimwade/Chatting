package com.chatting.dao;

import java.util.List;

import com.chatting.beans.Sujet;

public interface SujetDao {
	
	void ajouter( Sujet sujet );
    List<Sujet> lister(); 
    List<Sujet> sujetbyId(int id);

}
