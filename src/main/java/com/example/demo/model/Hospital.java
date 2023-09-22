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
    @Pattern(regexp = "[^0-9]+")
    private String name;
    @NotEmpty
    @Size(min = 5)
    private String address;
    @NotNull
    private Integer number;
    @Column(unique = true)
    @Size(min = 14, max = 14)
    @NotNull
    @Pattern(regexp = "[0-9]+")
    private String cnpj;
}