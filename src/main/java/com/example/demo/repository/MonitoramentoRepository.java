package com.example.demo.repository;

import com.example.demo.model.Monitoramento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MonitoramentoRepository extends JpaRepository<Monitoramento, UUID> {
    @Query("SELECT m FROM Monitoramento m " +
            "WHERE m.paciente.id IN :pacienteIds " +
            "AND m.timestamp IN (SELECT MAX(m2.timestamp) FROM Monitoramento m2 WHERE m2.paciente.id = m.paciente.id GROUP BY m2.paciente.id)" +
            "ORDER BY m.blood_pressure DESC")
    List<Monitoramento> findLatestByPacienteIds(@Param("pacienteIds") List<UUID> pacienteIds);
}
