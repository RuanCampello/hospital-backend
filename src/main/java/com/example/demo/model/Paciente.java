package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;


import java.io.Serializable;
import java.util.UUID;
@Data
@Entity
public class Paciente implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;
    private String cpf;
    private String name;
    private String date;
    private String personal_number;
    private String responsible_number;
}