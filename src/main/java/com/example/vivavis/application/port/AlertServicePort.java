package com.example.vivavis.application.port;

import com.example.vivavis.domain.entity.Alert;

import java.util.List;

public interface AlertServicePort {
    List<Alert> getAllAlerts();
    Alert getAlertById(Long id);
    Alert createAlert(Alert alert);
    Alert updateAlert(Long id, Alert updatedAlert);
    void deleteAlert(Long id);
}
