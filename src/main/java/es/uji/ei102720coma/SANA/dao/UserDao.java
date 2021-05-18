package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.UserDetails;

import java.util.Collection;

public interface UserDao {
    UserDetails loadUserByUsername(String email, String password);
    Collection<UserDetails> listAllUsers();
}