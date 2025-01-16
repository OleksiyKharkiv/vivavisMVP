# Vivavis Demo MVP - Backend

This is a demonstration MVP (Minimum Viable Product) backend application developed using **Java Spring Boot**. It utilizes **Hexagonal Architecture**, which helps keep the business logic in the core, isolated from potential changes in external infrastructure. This design enhances modularity and makes the application easier to maintain. The application showcases a segment of a **Dispatcher Monitoring System** used in energy (water) supply networks.

## Key Features
- **Hexagonal Architecture**: Ensures the core business logic is independent of external technologies, such as databases, messaging systems, or user interfaces. This makes the system more adaptable to changes.
- **Backend for Dispatcher System**: A fragment of a monitoring system for energy (water) supply networks, with real-time event tracking and user management.
- **Dockerization**: The application can be containerized using Docker, enabling easy deployment both locally and in the cloud.
- **Environment Variables**: The application supports environment variables for configuration.

## Entity Relationship Diagram (ERD)

Below is the **YAML** schema of the entities involved in this application, taken from the `vivavis_scheme.xml` (located in the root directory of the project).

```xml
<mxfile>
    <diagram name="Database Schema with Relationships">
        <mxGraphModel dx="1000" dy="1000" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="1000" pageHeight="1000" math="0" shadow="0">
            <root>
                <mxCell id="0" />
                <mxCell id="1" parent="0" />

                <!-- Entity: Sensor -->
                <mxCell id="2" value="Sensor" style="shape=swimlane" vertex="1" parent="1">
                    <mxGeometry x="10" y="10" width="200" height="180" as="geometry" />
                </mxCell>
                <mxCell id="3" value="id: UUID (PK)" vertex="1" parent="2">
                    <mxGeometry x="10" y="40" width="180" height="20" as="geometry" />
                </mxCell>
                <mxCell id="4" value="sensor_id: String" vertex="1" parent="2">
                    <mxGeometry x="10" y="70" width="180" height="20" as="geometry" />
                </mxCell>
                <mxCell id="5" value="sensor_name: String" vertex="1" parent="2">
                    <mxGeometry x="10" y="100" width="180" height="20" as="geometry" />
                </mxCell>
                <mxCell id="6" value="sensor_type: String" vertex="1" parent="2">
                    <mxGeometry x="10" y="130" width="180" height="20" as="geometry" />
                </mxCell>
                <mxCell id="7" value="location: String" vertex="1" parent="2">
                    <mxGeometry x="10" y="160" width="180" height="20" as="geometry" />
                </mxCell>
                <mxCell id="8" value="status: String" vertex="1" parent="2">
                    <mxGeometry x="10" y="190" width="180" height="20" as="geometry" />
                </mxCell>
                <mxCell id="9" value="timestamp: TIMESTAMP" vertex="1" parent="2">
                    <mxGeometry x="10" y="220" width="180" height="20" as="geometry" />
                </mxCell>

                <!-- Entity: Alert -->
                <mxCell id="10" value="Alert" style="shape=swimlane" vertex="1" parent="1">
                    <mxGeometry x="250" y="10" width="200" height="120" as="geometry" />
                </mxCell>
                <mxCell id="11" value="id: UUID (PK)" vertex="1" parent="10">
                    <mxGeometry x="10" y="40" width="180" height="20" as="geometry" />
                </mxCell>
                <mxCell id="12" value="alert_type: String" vertex="1" parent="10">
                    <mxGeometry x="10" y="70" width="180" height="20" as="geometry" />
                </mxCell>
                <mxCell id="13" value="created_at: TIMESTAMP" vertex="1" parent="10">
                    <mxGeometry x="10" y="100" width="180" height="20" as="geometry" />
                </mxCell>

                <!-- Entity: User -->
                <mxCell id="14" value="User" style="shape=swimlane" vertex="1" parent="1">
                    <mxGeometry x="10" y="200" width="200" height="120" as="geometry" />
                </mxCell>
                <mxCell id="15" value="id: UUID (PK)" vertex="1" parent="14">
                    <mxGeometry x="10" y="40" width="180" height="20" as="geometry" />
                </mxCell>
                <mxCell id="16" value="username: String" vertex="1" parent="14">
                    <mxGeometry x="10" y="70" width="180" height="20" as="geometry" />
                </mxCell>
                <mxCell id="17" value="email: String" vertex="1" parent="14">
                    <mxGeometry x="10" y="100" width="180" height="20" as="geometry" />
                </mxCell>

                <!-- Entity: EventLog -->
                <mxCell id="18" value="EventLog" style="shape=swimlane" vertex="1" parent="1">
                    <mxGeometry x="250" y="200" width="200" height="120" as="geometry" />
                </mxCell>
                <mxCell id="19" value="id: UUID (PK)" vertex="1" parent="18">
                    <mxGeometry x="10" y="40" width="180" height="20" as="geometry" />
                </mxCell>
                <mxCell id="20" value="event_type: String" vertex="1" parent="18">
                    <mxGeometry x="10" y="70" width="180" height="20" as="geometry" />
                </mxCell>
                <mxCell id="21" value="created_at: TIMESTAMP" vertex="1" parent="18">
                    <mxGeometry x="10" y="100" width="180" height="20" as="geometry" />
                </mxCell>

                <!-- Relationships -->
                <mxCell id="22" value="" edge="1" parent="1" source="2" target="10">
                    <mxGeometry relative="1" as="geometry" />
                </mxCell>
                <mxCell id="23" value="" edge="1" parent="1" source="10" target="14">
                    <mxGeometry relative="1" as="geometry" />
                </mxCell>
                <mxCell id="24" value="" edge="1" parent="1" source="14" target="18">
                    <mxGeometry relative="1" as="geometry" />
                </mxCell>
                <mxCell id="25" value="" edge="1" parent="1" source="10" target="18">
                    <mxGeometry relative="1" as="geometry" />
                </mxCell>
            </root>
        </mxGraphModel>
    </diagram>
</mxfile>
```

## How to Use

## API Endpoints
Please follow the order of entity creation as described below:

POST /api/alerts:

Example Request:

json
{
    "alertType": "Critical",
    "createdAt": "2025-01-16T12:30:00",
    "sensors": []
}
This will create an alert. After this request, you will get an id for the alert.

POST /api/sensors:

Example Request:

json
{
    "sensorId": "VS-12345",
    "sensorName": "Voltage Drop Sensor",
    "sensorType": "Voltage Drop",
    "location": "Power Grid - Substation A",
    "status": "active",
    "timestamp": "2025-01-16T12:30:00",
    "alert": {
        "id": "d832b0df-e8a2-4b0b-9a39-7b23e4663c1e"
    }
}
The "id" for the alert should be taken from the response of the POST /api/alerts request.

POST /api/events:

Example Request:

json

{
    "eventType": "Voltage drop 10%",
    "createdAt": "2025-01-16T12:00:00",
    "sensor": {
        "id": "3d46df33-b671-4f9e-b992-fbaa30016ae3"
    }
}
The "id" for the sensor should be taken from the response of the POST /api/sensors request.

POST /api/users:

Example Request:

json

{
    "username": "dispatcher_koblenz",
    "password": "securePassword123", 
    "email": "dispatcher@koblenz-grid.de",
    "role": "DISPATCHER"
}
This will create a new user in the system.