package com.example.vivavis.application.service;

import com.example.vivavis.adapter.out.SensorRepository;
import com.example.vivavis.application.port.SensorServicePort;
import com.example.vivavis.domain.entity.Sensor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SensorServiceImpl implements SensorServicePort {

    private final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public Sensor getSensorById(UUID id) {
        return sensorRepository.findById(id).orElseThrow(() -> new RuntimeException("Sensor not found"));
    }

    @Override
    public Sensor createSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public Sensor updateSensor(UUID id, Sensor updatedSensor) {
        Sensor existingSensor = sensorRepository.findById(id).orElseThrow(() -> new RuntimeException("Sensor not found"));
        existingSensor.setSensorId(updatedSensor.getSensorId());
        existingSensor.setSensorName(updatedSensor.getSensorName());
        existingSensor.setSensorType(updatedSensor.getSensorType());
        return sensorRepository.save(existingSensor);
    }

    @Override
    public void deleteSensor(UUID id) {
        sensorRepository.deleteById(id);
    }
}