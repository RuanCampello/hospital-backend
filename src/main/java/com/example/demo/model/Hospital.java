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
    @Pattern(regexp = "[^0-9]+", message = "Name cannot contain numbers")
    private String name;
    @NotEmpty
    @Size(min = 5, message = "Address must contain at least 5 letters")
    private String address;
    @NotNull
    @Pattern(regexp = "[0-9]+", message = "Phone Number cannot contain letters")
    private String number;
    @Column(unique = true)
    @Size(min = 14, max = 14, message = "CNPJ length must be equal to 14")
    @NotNull
    @Pattern(regexp = "[0-9]+", message = "CNPJ cannot contain letters")
    private String cnpj;
}