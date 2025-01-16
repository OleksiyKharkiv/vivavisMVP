package com.example.vivavis.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sensors")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;  // Primary key

    @Column(name = "sensor_id", nullable = false, unique = true)
    private String sensorId;  // Unique sensor identifier

    @Column(name = "sensor_name", nullable = false)
    private String sensorName;  // Name of the sensor

    @Column(name = "sensor_type")
    private String sensorType;  // Type of the sensor (e.g., temperature, pressure)

    @Column(name = "location")
    private String location;  // Sensor location

    @Column(name = "status")
    private String status;  // Sensor status (e.g., active, inactive)

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;  // Timestamp of the last reading

    @ManyToOne
    @JoinColumn(name = "alert_id", referencedColumnName = "id")
    private Alert alert;  // Foreign key to Alert entity (Many sensors can have one alert)

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Sensor sensor = (Sensor) o;
        return getId() != null && Objects.equals(getId(), sensor.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
