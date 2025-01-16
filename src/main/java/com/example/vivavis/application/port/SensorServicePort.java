package com.example.vivavis.application.port;

import com.example.vivavis.domain.entity.Sensor;

import java.util.List;
import java.util.UUID;

public interface SensorServicePort {
    List<Sensor> getAllSensors();
    Sensor getSensorById(UUID id);
    Sensor createSensor(Sensor sensor);
    Sensor updateSensor(UUID id, Sensor updatedSensor);
    void deleteSensor(UUID id);
}
