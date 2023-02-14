package com.chatting.dao;

import java.util.List;

import com.chatting.beans.Discussion;


public interface DiscussionDao { 
	void ajouter( Discussion sujet );
    List<Discussion> lister();
    List<Discussion> getdiscussion(int id);

}  
