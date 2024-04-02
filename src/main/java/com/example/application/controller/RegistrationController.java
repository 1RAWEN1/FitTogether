package com.example.application.controller;

import com.example.application.entity.Role;
import com.example.application.entity.User;
import com.example.application.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController{
    @Autowired
    UserRepo userRepo;

    @PostMapping("/registration")
    public boolean addUser(User user, @RequestParam String password1){
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if(userFromDb != null){
            return false;
        }
        else if(!user.getPassword().equals(password1)){
            return false;
        }
        else {
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            userRepo.save(user);
        }

        return true;
    }
}
