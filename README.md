# Jersey RESTful Web Service

[![CI](https://github.com/Rob-Leggett/jersey_restful_webservice/actions/workflows/ci.yml/badge.svg)](https://github.com/Rob-Leggett/jersey_restful_webservice/actions/workflows/ci.yml)

A modern RESTful Web Service using Jersey 4.0 (Jakarta EE 11) with JPA 3.0 implemented using EclipseLink 4.0 and Derby In-Memory Database.

## Technology Stack

| Technology | Version | Description |
|------------|---------|-------------|
| Java | 21+ | Language runtime |
| Jersey | 4.0.0 | Jakarta RESTful Web Services (JAX-RS) implementation |
| EclipseLink | 4.0.2 | Jakarta Persistence (JPA) implementation |
| Derby | 10.16.1.1 | In-memory database |
| JUnit | 5.10.1 | Testing framework |
| Mockito | 5.6.0 | Mocking framework |
| SLF4J | 2.0.9 | Logging facade |

## Features

- **RESTful API** - Full CRUD operations for Customer resources
- **Jakarta EE 11** - Modern Jakarta namespace (`jakarta.*`)
- **JPA Persistence** - Entity management with EclipseLink
- **In-Memory Database** - Derby for easy development and testing
- **Unit Tests** - Jersey Test Framework with Mockito mocking
- **CI/CD** - GitHub Actions for automated builds

## Prerequisites

- Java 21 or higher
- Maven 3.8+

## Building

```bash
mvn clean install
```

## Testing

```bash
mvn test
```

## Running

Deploy the generated `target/jrws.war` to any Jakarta EE compatible servlet container (Tomcat 10+, Jetty 12+, etc.).

Ensure the context root is set to `jrws` and the web server port is `8080` (for example purposes).

Once the application is running:

- http://localhost:8080/jrws - Navigate to index.jsp to verify the application is running

## API Endpoints

All endpoints accept and return `application/json`.

### Save Customer

```
POST /jrws/rest/customer/save
Content-Type: application/json

{
    "id": 1,
    "firstName": "Robert",
    "lastName": "Leggett"
}
```

### Retrieve Customer

```
GET /jrws/rest/customer/retrieve/{id}
```

### Delete Customer

```
DELETE /jrws/rest/customer/{id}
```

## Project Structure

```
src/
├── main/
│   ├── java/au/com/example/
│   │   ├── api/              # REST resources and DTOs
│   │   ├── config/           # Application configuration
│   │   ├── entity/           # JPA entities
│   │   ├── persistence/      # DAO layer
│   │   └── service/          # Business logic
│   ├── resources/
│   │   └── META-INF/         # JPA persistence configuration
│   └── webapp/
│       └── WEB-INF/          # Web application config
└── test/
    └── java/                 # Unit tests
```

## License

See [LICENSE](LICENSE) file.

## Author

**Robert Leggett** - Solution Architect
