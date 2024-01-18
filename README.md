# Hospital Management System API

This API is designed to manage hospital, patient, teams and employees information in a hospital setting. It is built using Spring Boot and connected to a PostgreSQL database.

## Base URL
https://localhost:8080/

## Database Configuration

The API is configured to connect to a PostgreSQL database with the following details:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hospital
spring.datasource.username=postgres
spring.datasource.password=123456
```

Ensure that a PostgreSQL server is running on localhost at port 5432, and create a database named hospital. Adjust the username and password based on your PostgreSQL setup.

Patient Endpoints
1. GET /patient/all

Retrieve a list of all patients.
```json
[
    {
        "id": "f11d4fea-f4e4-4fc7-9856-d9c9e75985c9",
        "cpf": "12345678211",
        "name": "patientname",
        "date": "2005-11-12",
        "personal_number": "1234567",
        "responsible_number": "7654321"
    },
    // ... other patient objects
]
```
2. GET /patient/{id}

Retrieve details of a specific patient.
```json
{
    "id": "f11d4fea-f4e4-4fc7-9856-d9c9e75985c9",
    "cpf": "12345678211",
    "name": "patientname",
    "date": "2005-11-12",
    "personal_number": "1234567",
    "responsible_number": "7654321"
}
```
Parameters:
Path Variable: id (String) - ID of the patient.

3. POST /patient/

Create a new patient.

Request Body:

```json

{
    "id": "auto-generated-id",
    "cpf": "12345678211", //Must be unique
    "name": "Jubileu ao Quadrado Três",
    "date": "2005-11-12",
    "personal_number": "1234567",
    "responsible_number": "7654321"
}
```
Response:

```json

{
    "id": "auto-generated-id",
    "cpf": "12345678211",
    "name": "Jubileu ao Quadrado Três",
    "date": "2005-11-12",
    "personal_number": "1234567",
    "responsible_number": "7654321"
}
```

4. PUT /patient/{id}

Update details of a specific patient.

Parameters:
Path Variable: id (String) - ID of the patient.

Request Body:

```json
{
    "id": "f11d4fea-f4e4-4fc7-9856-d9c9e75985c9",
    "cpf": "12345678211",
    "name": "patientname",
    "date": "2005-11-12",
    "personal_number": "1234567",
    "responsible_number": "7654321"
}
```
Response:

```json
{
    "id": "f11d4fea-f4e4-4fc7-9856-d9c9e75985c9",
    "cpf": "12345678211",
    "name": "updatedpatientname",
    "date": "2005-11-12",
    "personal_number": "1234567",
    "responsible_number": "7654321"
}
```

5. DELETE /api/patient/{id}

Delete a specific patient.

Parameters:

Path Variable: id (String) - ID of the patient.

Response:

    No response body.

Status Codes:

    200 No Content: Patient successfully deleted.
    404 Not Found: Patient not found.
