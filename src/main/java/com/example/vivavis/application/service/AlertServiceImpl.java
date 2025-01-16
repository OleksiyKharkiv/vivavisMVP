package com.example.vivavis.application.service;

import com.example.vivavis.adapter.out.AlertRepository;
import com.example.vivavis.application.port.AlertServicePort;
import com.example.vivavis.domain.entity.Alert;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlertServiceImpl implements AlertServicePort {

    private final AlertRepository alertRepository;

    public AlertServiceImpl(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @Override
    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    @Override
    public Alert getAlertById(UUID id) {
        return alertRepository.findById(id).orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    @Override
    public Alert createAlert(Alert alert) {
        return alertRepository.save(alert);
    }

    @Override
    public Alert updateAlert(UUID id, Alert updatedAlert) {
        Alert existingAlert = alertRepository.findById(id).orElseThrow(() -> new RuntimeException("Alert not found"));
        existingAlert.setAlertType(updatedAlert.getAlertType());
        existingAlert.setCreatedAt(updatedAlert.getCreatedAt());
        existingAlert.setSensors(updatedAlert.getSensors());
        return alertRepository.save(existingAlert);
    }

    @Override
    public void deleteAlert(UUID id) {
        alertRepository.deleteById(id);
    }
}
