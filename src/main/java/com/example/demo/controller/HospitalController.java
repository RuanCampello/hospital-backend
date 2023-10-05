package com.example.demo.controller;

import com.example.demo.model.Hospital;
import com.example.demo.repository.HospitalRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class HospitalController {
    @Autowired
    HospitalRepository hospitalRepository;

    @CrossOrigin(value = "*")
    @GetMapping("/hospital/all")
    public ResponseEntity<List<Hospital>> getAllProducts() {
        return new ResponseEntity<>(hospitalRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/hospital{id}")
    public ResponseEntity<Hospital>
        getOneProduct(@PathVariable(value = "id") UUID id){
        Optional<Hospital> hospitalO = hospitalRepository.findById(id);
        if(hospitalO.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(hospitalO.get(), HttpStatus.OK);
    }
    @CrossOrigin(value = "*")
    @PostMapping("/hospital/")
    public ResponseEntity<Hospital> saveProduct (@RequestBody @Valid Hospital hospital) {
        return new ResponseEntity<>(hospitalRepository.save(hospital), HttpStatus.CREATED);
    }
    @CrossOrigin(value = "*")
    @PutMapping("/hospital/{id}")
    public ResponseEntity<Hospital>
    updateProduct (@PathVariable(value = "id") UUID id, @RequestBody @Valid Hospital hospital) {
        Optional<Hospital> productO = hospitalRepository.findById(id);
        if (productO.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        hospital.setId(id);
        return new ResponseEntity<>(hospitalRepository.save(hospital), HttpStatus.OK);
    }
    @CrossOrigin(value = "*")
    @DeleteMapping("/hospital/{id}")
    public ResponseEntity<?>
    deleteProduct(@PathVariable(value = "id") UUID id){
        Optional<Hospital> productO = hospitalRepository.findById(id);
        if(productO.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        hospitalRepository.delete(productO.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}