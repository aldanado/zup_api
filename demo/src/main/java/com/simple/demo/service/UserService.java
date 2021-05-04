package com.simple.demo.service;

import java.util.List;
import java.util.Optional;

import com.simple.demo.dao.UserDao;
import com.simple.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDAO;

    @Autowired
    public UserService(@Qualifier("userTest") UserDao userDao){
        this.userDAO = userDao;
    }

    public int addUser(User user){
        return userDAO.insertUser(user);
    }

    public List<User> getAllUsers(){
        return userDAO.selectAllUsers();
    }

    public Optional<User> getUser(String cpf, String email){
        return userDAO.selectUser(cpf, email);
    }

    public int deleteUser(String cpf, String email){
        return userDAO.deleteUser(cpf, email);
    }

    public int updateUser(User user){
        return userDAO.updateUser(user);
    }
}
