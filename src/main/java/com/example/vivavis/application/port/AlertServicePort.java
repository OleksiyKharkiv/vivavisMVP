package com.example.vivavis.application.port;

import com.example.vivavis.domain.entity.Alert;

import java.util.List;
import java.util.UUID;

public interface AlertServicePort {
    List<Alert> getAllAlerts();
    Alert getAlertById(UUID id);
    Alert createAlert(Alert alert);
    Alert updateAlert(UUID id, Alert updatedAlert);
    void deleteAlert(UUID id);
}
