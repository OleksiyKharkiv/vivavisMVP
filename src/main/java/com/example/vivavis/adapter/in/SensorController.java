package com.example.vivavis.adapter.in;

import com.example.vivavis.application.port.SensorServicePort;
import com.example.vivavis.domain.entity.Sensor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    private final SensorServicePort sensorService;

    public SensorController(SensorServicePort sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping
    public ResponseEntity<List<Sensor>> getAllSensors() {
        return ResponseEntity.ok(sensorService.getAllSensors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> getSensorById(@PathVariable UUID id) {
        return ResponseEntity.ok(sensorService.getSensorById(id));
    }

    @PostMapping
    public ResponseEntity<Sensor> createSensor(@RequestBody Sensor sensor) {
        return ResponseEntity.ok(sensorService.createSensor(sensor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sensor> updateSensor(@PathVariable UUID id, @RequestBody Sensor updatedSensor) {
        return ResponseEntity.ok(sensorService.updateSensor(id, updatedSensor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable UUID id) {
        sensorService.deleteSensor(id);
        return ResponseEntity.noContent().build();
    }
}