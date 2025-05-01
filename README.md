# Productos API

This project is a RESTful API for managing products, developed with **Spring Boot** and **PostgreSQL**.

## Prerequisites

1. **Java**: Ensure you have Java 17 or higher installed.
2. **Maven**: Install Maven for dependency management.
3. **PostgreSQL**: Install PostgreSQL and ensure it is running.

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/robertocaamanor/prueba-tecnica-ilis-backend.git
cd productos-api
```

### 2. Configure the Database

Update the database connection details in the `src/main/resources/application.properties` file:

```ini
spring.datasource.url=jdbc:postgresql://localhost:5432/transacciones_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Enable the `unaccent` Extension in PostgreSQL

The application requires the `unaccent` extension to perform accent-insensitive searches. Run the following commands in your PostgreSQL database:

```sql
CREATE EXTENSION IF NOT EXISTS unaccent;
```

### 4. Build and Run the Application

Use Maven to build and run the application:

```bash
mvn clean install
mvn spring-boot:run
```

### 5. Automatic Table Creation

Once the application is connected to the database, the `Producto` table will be created automatically based on the entity definition (`spring.jpa.hibernate.ddl-auto=update` is enabled).

### 6. Access the API

The API will be available at `http://localhost:8080/products`.

## API Endpoints

- **GET /products**: Search for products with optional filters (`name`, `category`, `inStock`).
- **GET /products/all**: Retrieve all products.
- **POST /products**: Create a new product.

## Notes

- Ensure the `unaccent` extension is properly installed and accessible in your PostgreSQL database.
- If you encounter issues with the `unaccent` function, verify the schema and `search_path` configuration in PostgreSQL.
```