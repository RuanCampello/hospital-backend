package com.example.demo.controller;

import com.example.demo.model.Monitoramento;
import com.example.demo.model.Paciente;
import com.example.demo.repository.MonitoramentoRepository;
import com.example.demo.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class MonitoramentoController {
    private final MonitoramentoRepository monitoramentoRepository;
    private final PacienteRepository pacienteRepository;
    @Autowired
    public MonitoramentoController(MonitoramentoRepository monitoramentoRepository, PacienteRepository pacienteRepository) {
        this.monitoramentoRepository = monitoramentoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/track/all")
    public ResponseEntity<List<Monitoramento>> getAllProducts() {
        return new ResponseEntity<>(monitoramentoRepository.findAll(), HttpStatus.OK);
    }
    @CrossOrigin("*")
    @GetMapping("/track/latest")
    public ResponseEntity<List<Monitoramento>> getLatestTracks() {
        List<UUID> allPacienteIds = pacienteRepository.findAll().stream()
                .map(Paciente::getId)
                .collect(Collectors.toList());
        List<Monitoramento> latestTracks = monitoramentoRepository.findLatestByPacienteIds(allPacienteIds);
        return new ResponseEntity<>(latestTracks, HttpStatus.OK);
    }
    @CrossOrigin("*")
    @PostMapping("/patient/{id}/track")
    public ResponseEntity<Monitoramento> saveProduct(@PathVariable(value = "id") UUID id, @RequestBody @Valid Monitoramento monitoramento) {
        if(id != null) monitoramento.setPacienteId(id);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Monitoramento savedMonitoramento = monitoramentoRepository.save(monitoramento);
        return new ResponseEntity<>(savedMonitoramento, HttpStatus.CREATED);
    }
}
