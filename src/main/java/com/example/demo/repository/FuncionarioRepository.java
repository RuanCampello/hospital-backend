package com.example.demo.repository;

import com.example.demo.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;


public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {

}