package com.simple.demo.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.simple.demo.model.User;
import com.simple.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> insertUser(@Valid  @NotNull @RequestBody User user){
        if(userService.addUser(user) == 1) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User already registered!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path = "{cpf}/{email}")
    public User getUser(@PathVariable("cpf") String cpf, @PathVariable("email") String email){
        return userService.getUser(cpf, email).orElse(null);
    }

    @DeleteMapping(path = "{cpf}")
    public void deleteUser(@PathVariable("cpf") String cpf, @PathVariable("email") String email){
        userService.deleteUser(cpf, email);
    }

    @PutMapping(path = "{cpf}")
    public int updatUser(@Valid @NotNull @RequestBody User user){
        return userService.updateUser(user);
    } 
}
