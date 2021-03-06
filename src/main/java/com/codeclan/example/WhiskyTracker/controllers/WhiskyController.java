package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

//    @GetMapping(value = "/whiskys")
//    public ResponseEntity<List<Whisky>> getAllWhiskys() {
//        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
//    }


    @GetMapping(value="/whiskys/{id}")
    public ResponseEntity getWhisky(@PathVariable Long id){
        return new ResponseEntity(whiskyRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskys")
    public ResponseEntity<List<Whisky>> findByYear(@RequestParam(name = "year", required = false) Long year) {
        if (year != null) {
            return new ResponseEntity<>(whiskyRepository.findByYearEquals(Math.toIntExact(year)), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value="/whiskys")
    public ResponseEntity<Whisky> createWhisky(@RequestBody Whisky whisky){
        whiskyRepository.save(whisky);
        return new ResponseEntity<>(whisky, HttpStatus.CREATED);
    }

//    @GetMapping(value = "/whiskys")
//    public ResponseEntity<List<Whisky>> findByDistilleryAndAge(@RequestParam(name = "named", required = false) String name) {
//        if (year != null) {
//            return new ResponseEntity<>(whiskyRepository.findByYearEquals(Math.toIntExact(year)), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
//    }




}
