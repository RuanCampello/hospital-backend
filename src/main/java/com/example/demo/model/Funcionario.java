package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Funcionario implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;
    @NotNull
    @Size(min = 11, max = 11, message = "CPF deve conter 11 dígitos")
    @Pattern(regexp = "[0-9]+", message = "CPF não pode conter letras")
    @Column(unique = true)
    private String cpf;
    @NotNull
    @Pattern(regexp = "[^0-9]+", message = "Nome não pode conter números")
    @Size(min = 3, message = "Nome deve conter pelo menos 3 letras")
    private String name;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @NotNull
    @Pattern(regexp = "[0-9]+", message = "Número do telefone não pode conter letras")
    private String personal_number;
    @NotNull
    @Pattern(regexp = "[^0-9]+", message = "Função não pode conter números")
    private String function;
}