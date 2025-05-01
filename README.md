# Productos API

Este proyecto es una API RESTful para la gestión de productos, desarrollada con **Spring Boot** y **PostgreSQL**.

## Requisitos previos

1. **Java**: Asegúrate de tener Java 17 o superior instalado.
2. **Maven**: Instala Maven para la gestión de dependencias.
3. **PostgreSQL**: Instala PostgreSQL y asegúrate de que esté en ejecución.

## Instrucciones de configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/robertocaamanor/prueba-tecnica-ilis-backend.git
cd productos-api
```

### 2. Configurar la base de datos

Actualiza los detalles de conexión a la base de datos en el archivo `src/main/resources/application.properties`:

```ini
spring.datasource.url=jdbc:postgresql://localhost:5432/transacciones_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### 3. Habilitar la extensión `unaccent` en PostgreSQL

La aplicación requiere la extensión `unaccent` para realizar búsquedas insensibles a los acentos. Ejecuta los siguientes comandos en tu base de datos PostgreSQL:

```sql
CREATE EXTENSION IF NOT EXISTS unaccent;
```

### 4. Construir y ejecutar la aplicación

Usa Maven para construir y ejecutar la aplicación:

```bash
mvn clean install
mvn spring-boot:run
```

### 5. Creación automática de tablas

Una vez que la aplicación se conecte a la base de datos, la tabla `Producto` se creará automáticamente en la base de datos gracias a la configuración de `spring.jpa.hibernate.ddl-auto=update`.

### 6. Acceder a la API

La API estará disponible en `http://localhost:8080/products`.

## Endpoints de la API

- **GET /products**: Buscar productos con filtros opcionales (`name`, `category`, `inStock`).
- **GET /products/all**: Obtener todos los productos.
- **POST /products**: Crear un nuevo producto.

## Notas

- Asegúrate de que la extensión `unaccent` esté correctamente instalada y accesible en tu base de datos PostgreSQL.
- Si encuentras problemas con la función `unaccent`, verifica la configuración del esquema y el `search_path` en PostgreSQL.
```