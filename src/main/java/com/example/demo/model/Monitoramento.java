package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "monitoramento")
public class Monitoramento implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;
    private Double heart_rate;
    private Double blood_pressure;
    private Double respiratory_frequency;
    private Double temperature;
    private Double blood_oxygen_concentration;
    @Column(name = "timestamp")
    @CreationTimestamp
    private LocalDateTime timestamp;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    public void setPacienteId(UUID pacienteId) {
        this.paciente = new Paciente();
        this.paciente.setId(pacienteId);
    }
}
