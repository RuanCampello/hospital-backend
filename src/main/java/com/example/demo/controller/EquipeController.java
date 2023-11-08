package com.example.demo.controller;

import com.example.demo.model.Equipe;
import com.example.demo.repository.EquipeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class EquipeController {
    @Autowired
    EquipeRepository equipeRepository;

    @CrossOrigin(value = "*")
    @GetMapping("/team/all")
    public ResponseEntity<List<Equipe>> getAllProducts() {
        return new ResponseEntity<>(equipeRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/team{id}")
    public ResponseEntity<Equipe>
    getOneProduct(@PathVariable(value = "id") UUID id){
        Optional<Equipe> equipeO = equipeRepository.findById(id);
        if(equipeO.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(equipeO.get(), HttpStatus.OK);
    }
    @CrossOrigin(value = "*")
    @PostMapping("/team/")
    public ResponseEntity<Equipe> saveProduct (@RequestBody @Valid Equipe equipe) {
        return new ResponseEntity<>(equipeRepository.save(equipe), HttpStatus.CREATED);
    }
    @CrossOrigin(value = "*")
    @PutMapping("/team/{id}")
    public ResponseEntity<Equipe>
    updateProduct (@PathVariable(value = "id") UUID id, @RequestBody @Valid Equipe equipe) {
        Optional<Equipe> productO = equipeRepository.findById(id);
        if (productO.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        equipe.setId(id);
        return new ResponseEntity<>(equipeRepository.save(equipe), HttpStatus.OK);
    }
    @CrossOrigin(value = "*")
    @DeleteMapping("/team/{id}")
    public ResponseEntity<?>
    deleteProduct(@PathVariable(value = "id") UUID id){
        Optional<Equipe> productO = equipeRepository.findById(id);
        if(productO.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        equipeRepository.delete(productO.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
