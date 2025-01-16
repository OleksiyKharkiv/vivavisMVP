package com.example.vivavis.adapter.in;

import com.example.vivavis.domain.entity.Alert;
import com.example.vivavis.application.port.AlertServicePort;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertServicePort alertService;

    public AlertController(AlertServicePort alertService) {
        this.alertService = alertService;
    }

    @GetMapping
    public ResponseEntity<List<Alert>> getAllAlerts() {
        return ResponseEntity.ok(alertService.getAllAlerts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alert> getAlertById(@PathVariable UUID id) {
        return ResponseEntity.ok(alertService.getAlertById(id));
    }

    @PostMapping
    public ResponseEntity<Alert> createAlert(@RequestBody Alert alert) {
        return ResponseEntity.ok(alertService.createAlert(alert));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alert> updateAlert(@PathVariable UUID id, @RequestBody Alert updatedAlert) {
        return ResponseEntity.ok(alertService.updateAlert(id, updatedAlert));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable UUID id) {
        alertService.deleteAlert(id);
        return ResponseEntity.noContent().build();
    }
}
