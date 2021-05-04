package com.simple.demo.dao;

import java.util.List;
import java.util.Optional;

import com.simple.demo.model.User;


public interface UserDao {
    
    int insertUser(User user); 

    public List<User> selectAllUsers();

    Optional<User> selectUser(String cpf, String email);

    int deleteUser(String cpf, String email);

    int updateUser(User user);

}
