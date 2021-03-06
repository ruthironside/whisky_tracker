package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository  distilleryRepository;


    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> findByRegion(@RequestParam(name = "region", required = false) String region) {
        if (region != null) {
            return new ResponseEntity<>(distilleryRepository.findByRegionEquals(region), HttpStatus.OK);
        }
//            else if(age != null) {
//                return new ResponseEntity<>(distilleryRepository.findDistilleriesByWhiskysAge(age), HttpStatus.OK);
//            }  DO WE MAYBE ATTACH IT IN HERE SOMEHOW?

        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/distilleries/{id}")
    public ResponseEntity getDistillery(@PathVariable Long id){
        return new ResponseEntity(distilleryRepository.findById(id), HttpStatus.OK);
    }

//    @GetMapping(value = "/distilleries/whiskys")
//    public ResponseEntity<List<Distillery>> findByNameAndAge(@RequestParam(name = "name", required = false) String name) {
//        if (name != null) {
//            return new ResponseEntity<>(distilleryRepository.findByNameEquals(age), HttpStatus.OK);
//            if(age != null)
//        }
//        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
//    }




}
