package com.example.application.controller;

import com.example.application.entity.Placemark;
import com.example.application.entity.User;
import com.example.application.repo.PlacemarkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class PlacemarkController {
    @Autowired
    PlacemarkRepo placemarkRepo;

    @PostMapping("/placemarks")
    public boolean createMark(@AuthenticationPrincipal User user, @RequestBody Placemark placemark, BindingResult bindingResult) {
        if(user == null || bindingResult.hasErrors()){

            return false;
        }
        else{
            placemarkRepo.save(placemark);
        }

        return true;
    }

    @GetMapping("/placemarks")
    public List<Placemark> getPlacemarks(){
        List<Placemark> placemarks = placemarkRepo.findAll();

        for(Placemark p : placemarks){
            if(p.getActivityDate().after(new Date())){
                placemarkRepo.delete(p);
            }
        }

        placemarks = placemarkRepo.findAll();

        return placemarks;
    }
}
