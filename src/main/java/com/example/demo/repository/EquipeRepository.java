package com.example.demo.repository;

import com.example.demo.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipeRepository extends JpaRepository<Equipe, UUID> {

}