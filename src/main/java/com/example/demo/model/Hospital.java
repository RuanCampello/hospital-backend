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
public class Hospital implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;
    @NotNull
    @Pattern(regexp = "[^0-9]+", message = "Nome não pode conter números")
    private String name;
    @NotEmpty
    @Size(min = 5, message = "Endereço deve conter pelo menos 5 letras")
    private String address;
    @NotNull
    @Pattern(regexp = "[0-9]+", message = "Número de telefone não pode conter letras")
    private String number;
    @Column(unique = true)
    @Size(min = 14, max = 14, message = "CNPJ deve conter 14 dígitos")
    @NotNull
    @Pattern(regexp = "[0-9]+", message = "CNPJ não pode conter letras")
    private String cnpj;
}