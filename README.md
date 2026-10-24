# Jersey RESTful Web Service

[![CI](https://github.com/Rob-Leggett/jersey_restful_webservice/actions/workflows/ci.yml/badge.svg)](https://github.com/Rob-Leggett/jersey_restful_webservice/actions/workflows/ci.yml)

A modern RESTful Web Service using Jersey 4.0 (Jakarta EE 11) with Jakarta Persistence 3.2 implemented using EclipseLink 5.0 and an H2 in-memory database.

## Technology Stack

| Technology | Version | Description |
|------------|---------|-------------|
| Java | 25+ | Language runtime |
| Jersey | 4.0.3 | Jakarta RESTful Web Services (JAX-RS) implementation |
| EclipseLink | 5.0.2 | Jakarta Persistence (JPA) implementation |
| H2 | 2.5.252 | In-memory database |
| JUnit | 6.1.3 | Testing framework |
| Mockito | 5.24.0 | Mocking framework |
| SLF4J | 2.0.20 |
| Jetty (dev server) | 12.1.14 | Local servlet container via `jetty-ee11-maven-plugin` | Logging facade |

## Features

- **RESTful API** - Full CRUD operations for Customer resources
- **Jakarta EE 11** - Modern Jakarta namespace (`jakarta.*`)
- **JPA Persistence** - Entity management with EclipseLink
- **In-Memory Database** - H2 for easy development and testing
- **Unit Tests** - Jersey Test Framework with Mockito mocking
- **CI/CD** - GitHub Actions for automated builds

## Prerequisites

- Java 25 or higher
- Maven 3.9+

## Building

```bash
mvn clean install
```

## Testing

```bash
mvn test
```

## Running

Run locally with the embedded Jetty plugin:

```bash
mvn jetty:run
```

Or deploy the generated `target/jrws.war` to any Jakarta EE 11 compatible servlet container (Tomcat 11+, Jetty 12.1+ with EE11, etc.).

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
