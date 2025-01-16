# Vivavis Demo MVP - Backend

This is a demonstration MVP (Minimum Viable Product) backend application developed using **Java Spring Boot**. It utilizes **Hexagonal Architecture**, which helps keep the business logic in the core, isolated from potential changes in external infrastructure. This design enhances modularity and makes the application easier to maintain. The application showcases a segment of a **Dispatcher Monitoring System** used in energy (water) supply networks.

## Key Features
- **Hexagonal Architecture**: Ensures the core business logic is independent of external technologies, such as databases, messaging systems, or user interfaces. This makes the system more adaptable to changes.
- **Backend for Dispatcher System**: A fragment of a monitoring system for energy (water) supply networks, with real-time event tracking and user management.
- **Dockerization**: The application can be containerized using Docker, enabling easy deployment both locally and in the cloud.
- **Environment Variables**: The application supports environment variables for configuration.
- **DTO Layer in Adapters**: A DTO (Data Transfer Object) layer is planned for implementation in the adapter layer to ensure clear separation between internal domain models and external data representations. This will help in decoupling the internal business logic from external interfaces and simplify data transformation, validation, and transmission. The DTO layer is not yet integrated but is a part of the application's future architecture.
- **Unit Tests**: Unit tests using the JUnit framework are planned for implementation to ensure the reliability and correctness of the business logic and integrations. These tests are not yet included but are part of the upcoming development.
- **Security and Authorization**: A security and authorization layer is present in the application to manage user roles and permissions (currently disabled for easier demonstration of the project).


## Entity Relationship Diagram (ERD)

Below is the schema of the entities involved in this application, taken from the `vivavis_scheme.xml` (located in the root directory of the project).

![vivavis_scheme](vivavis_scheme.drawio.png)

## Project Structure

The project follows a hexagonal architecture and includes the following components:

- **Core (Business Logic)**: Contains the main application logic and business rules. This layer is independent of external systems, ensuring flexibility and maintainability. It handles the core functionalities and rules of the application.

- **Adapters**: Interfaces for external dependencies (e.g., database, APIs, etc.). Adapters implement the communication between the core business logic and external systems, making it easier to swap or modify external components without affecting the core logic.

- **Ports**: Define input and output contracts for interacting with the application core. Ports are used to communicate with the core business logic, ensuring a well-defined interface for external interactions, like fetching or sending data.

## Environment Setup

### Clone the Repository:

To get started with the project, clone the repository and navigate into the project folder:

```bash
git clone https://github.com/OleksiyKharkiv/vivavisMVP
cd vivavisMVP
````

## Docker setup:

You can run the application inside a Docker container by using the provided Docker Compose setup. Make sure Docker and Docker Compose are installed on your machine.

To build and run the application with Docker:

```bash
docker-compose up --build -d
````
The application will be available at http://localhost:8080.

## Authorization and Security
For ease of access during development, the Authorization and Security system is disabled. 
However, a complete security system with authentication and authorization (such as JWT, OAuth2) should be implemented in a production environment for secure access.

## How to Use

## API Endpoints
Please follow the order of entity creation as described below:

# POST /api/alerts:

Example Request:

```json
{
    "alertType": "Critical",
    "createdAt": "2025-01-16T12:30:00",
    "sensors": []
}
```
This will create an alert. After this request, you will get an id for the alert.

# POST /api/sensors:

Example Request:

```json
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
```
The "id" for the alert should be taken from the response of the POST /api/alerts request.

# POST /api/events:

Example Request:

```json

{
    "eventType": "Voltage drop 10%",
    "createdAt": "2025-01-16T12:00:00",
    "sensor": {
        "id": "3d46df33-b671-4f9e-b992-fbaa30016ae3"
    }
}
```
The "id" for the sensor should be taken from the response of the POST /api/sensors request.

# POST /api/users:

Example Request:

```json

{
    "username": "dispatcher_koblenz",
    "password": "securePassword123", 
    "email": "dispatcher@koblenz-grid.de",
    "role": "DISPATCHER"
}
```
This will create a new user in the system.