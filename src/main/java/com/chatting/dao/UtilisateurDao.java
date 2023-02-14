package com.chatting.dao;
import java.util.List;

import com.chatting.beans.User;

public interface UtilisateurDao {
	void ajouter( User utilisateur );
    List<User> lister();
    List<User> connection(String $log,String $pass);

}
