package com.example.vivavis.adapter.out;

import com.example.vivavis.domain.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, UUID> {
}