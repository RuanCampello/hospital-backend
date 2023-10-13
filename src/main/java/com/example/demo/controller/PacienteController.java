package com.example.demo.controller;

import com.example.demo.model.Paciente;
import com.example.demo.repository.PacienteRepository;
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
public class PacienteController {
    @Autowired
    PacienteRepository pacienteRepository;

    @CrossOrigin(value = "*")
    @GetMapping("/patient/all")
    public ResponseEntity<List<Paciente>> getAllProducts() {
        return new ResponseEntity<>(pacienteRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/patient{id}")
    public ResponseEntity<Paciente>
    getOneProduct(@PathVariable(value = "id") UUID id){
        Optional<Paciente> pacienteO = pacienteRepository.findById(id);
        if(pacienteO.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(pacienteO.get(), HttpStatus.OK);
    }
    @CrossOrigin(value = "*")
    @PostMapping("/patient/")
    public ResponseEntity<Paciente> saveProduct (@RequestBody @Valid Paciente paciente) {
        return new ResponseEntity<>(pacienteRepository.save(paciente), HttpStatus.CREATED);
    }
    @CrossOrigin(value = "*")
    @PutMapping("/patient/{id}")
    public ResponseEntity<Paciente>
    updateProduct (@PathVariable(value = "id") UUID id, @RequestBody @Valid Paciente paciente) {
        Optional<Paciente> productO = pacienteRepository.findById(id);
        if (productO.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        paciente.setId(id);
        return new ResponseEntity<>(pacienteRepository.save(paciente), HttpStatus.OK);
    }
    @CrossOrigin(value = "*")
    @DeleteMapping("/patient/{id}")
    public ResponseEntity<?>
    deleteProduct(@PathVariable(value = "id") UUID id){
        Optional<Paciente> productO = pacienteRepository.findById(id);
        if(productO.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        pacienteRepository.delete(productO.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}