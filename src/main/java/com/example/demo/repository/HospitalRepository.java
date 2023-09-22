package com.example.demo.repository;

import com.example.demo.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface HospitalRepository extends JpaRepository<Hospital, UUID> {

}
