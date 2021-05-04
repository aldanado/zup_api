package com.simple.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.simple.demo.model.User;

import org.springframework.stereotype.Repository;

@Repository("userTest")
public class UserDataService implements UserDao{

    private static List<User> DB = new ArrayList<>();      
    
    @Override
    public int insertUser(User user) {
        Optional<User> userToInsert = selectUser(user.getCPF(), user.getEmail());
        if (!userToInsert.isPresent()){
            DB.add(user);
            return 1;
        }else{
            System.out.println("2");
            return 0;
        }
    }
    
    @Override
    public List<User> selectAllUsers() {
        return DB;
    }

    @Override
    public Optional<User> selectUser(String cpf, String email) {
        Optional<User> userFound = DB.stream()
        .filter(userF -> userF.getCPF().equals(cpf) && userF.getEmail().equals(email))
        .findFirst();
        System.out.println(userFound);
        return userFound;
    }

    @Override
    public int deleteUser(String cpf, String email) {
        Optional<User> userToDelete = selectUser(cpf, email);
        if (userToDelete.isEmpty()){
            return 0;
        }
        DB.remove(userToDelete.get());
        return 1;
    }

    @Override
    public int updateUser(User user) {
        return selectUser(user.getCPF(), user.getEmail()).map(userToUpdate -> {
                                            int userIndexToUpdate = DB.indexOf(userToUpdate);
                                            if (userIndexToUpdate >= 0){
                                                DB.set(userIndexToUpdate, new User(user.getNome(), user.getEmail(), user.getCPF(), user.getBirthdate()));
                                                return 1;
                                            }
                                            return 0;
        }).orElse(-1);
    }
    
}
