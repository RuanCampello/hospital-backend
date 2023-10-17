package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class FuncionarioController {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @CrossOrigin(value = "*")
    @GetMapping("/employee/all")
    public ResponseEntity<List<Funcionario>> getAllProducts() {
        return new ResponseEntity<>(funcionarioRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/employee{id}")
    public ResponseEntity<Funcionario>
    getOneProduct(@PathVariable(value = "id") UUID id){
        Optional<Funcionario> funcionarioO = funcionarioRepository.findById(id);
        if(funcionarioO.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(funcionarioO.get(), HttpStatus.OK);
    }
    @CrossOrigin(value = "*")
    @PostMapping("/employee/")
    public ResponseEntity<Funcionario> saveProduct (@RequestBody @Valid Funcionario funcionario) {
        return new ResponseEntity<>(funcionarioRepository.save(funcionario), HttpStatus.CREATED);
    }
    @CrossOrigin(value = "*")
    @PutMapping("/employee/{id}")
    public ResponseEntity<Funcionario>
    updateProduct (@PathVariable(value = "id") UUID id, @RequestBody @Valid Funcionario funcionario) {
        Optional<Funcionario> productO = funcionarioRepository.findById(id);
        if (productO.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        funcionario.setId(id);
        return new ResponseEntity<>(funcionarioRepository.save(funcionario), HttpStatus.OK);
    }
    @CrossOrigin(value = "*")
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?>
    deleteProduct(@PathVariable(value = "id") UUID id){
        Optional<Funcionario> productO = funcionarioRepository.findById(id);
        if(productO.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        funcionarioRepository.delete(productO.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
