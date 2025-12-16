# 📚 API REST Biblioteca

> API REST para gestión de bibliotecas y libros con relación Uno a Muchos (One-To-Many) usando Spring Boot y JPA/Hibernate

---

## 📖 Descripción del Proyecto

Esta es una **API REST de Biblioteca** desarrollada con **Spring Boot**, cuyo objetivo es gestionar bibliotecas y libros aplicando una relación **Uno a Muchos (One-To-Many)** mediante **JPA / Hibernate**.

La API permite realizar operaciones **CRUD** (crear, leer, actualizar y eliminar) sobre las entidades `Biblioteca` y `Libros`, exponiendo endpoints REST que consumen y devuelven información en formato **JSON**.

### ✨ Características principales

- ✅ Operaciones CRUD completas
- ✅ Paginación de resultados
- ✅ Códigos de respuesta HTTP estándar
- ✅ Serialización JSON sin referencias circulares
- ✅ Arquitectura en capas (Controller, Service, Model)
- ✅ Buenas prácticas REST

---

## 🧠 Modelo de Datos

El proyecto implementa una relación **One-To-Many** entre las entidades:

```
Biblioteca (1) -----> (N) Libros
```

- 📚 **Una Biblioteca** puede contener **muchos Libros**
- 📖 **Cada Libro** pertenece a **una sola Biblioteca**

## 🛠️ Requisitos

### Software necesario

| Herramienta | Versión mínima | Descripción |
|------------|----------------|-------------|
| ☕ **Java JDK** | 17+ | Lenguaje de programación |
| 🧱 **Apache Maven** | 3.8+ | Gestor de dependencias |
| 🗄️ **MySQL** | 8.0+ | Base de datos relacional |
| 🔧 **IDE** | - | IntelliJ IDEA / NetBeans / Eclipse |
| 📮 **Postman** | - | Para probar la API |

---

## 🚀 Tecnologías Utilizadas

- ☕ **Java 17**
- 🌱 **Spring Boot** - Framework principal
- 🗄️ **Spring Data JPA** - Persistencia de datos
- 🐘 **Hibernate** - ORM (Object-Relational Mapping)
- 🧱 **Maven** - Gestión de dependencias
- 🗃️ **MySQL** - Base de datos relacional

---

## 📡 Endpoints de la API

### 📘 Biblioteca

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/biblioteca` | Listar todas las bibliotecas (paginado) |
| `GET` | `/biblioteca/{id}` | Obtener biblioteca por ID |
| `POST` | `/biblioteca` | Crear nueva biblioteca |
| `PUT` | `/biblioteca/{id}` | Editar biblioteca existente |
| `DELETE` | `/biblioteca/{id}` | Eliminar biblioteca |

#### 📌 Ejemplo: Crear Biblioteca

**Request:** `POST /biblioteca`

```json
{
  "nombre": "Biblioteca Central",
  "listaLibros": [
    {
      "nombre": "Clean Code",
      "autor": "Robert C. Martin"
    },
    {
      "nombre": "The Pragmatic Programmer",
      "autor": "Andrew Hunt"
    }
  ]
}
```

**Response:** `201 Created`

```json
{
  "id": 1,
  "nombre": "Biblioteca Central",
  "listaLibros": [
    {
      "id": 1,
      "nombre": "Clean Code",
      "autor": "Robert C. Martin"
    },
    {
      "id": 2,
      "nombre": "The Pragmatic Programmer",
      "autor": "Andrew Hunt"
    }
  ]
}
```

---

### 📗 Libros

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/libros` | Listar todos los libros (paginado) |
| `GET` | `/libros/{id}` | Obtener libro por ID |
| `POST` | `/libros` | Crear nuevo libro |
| `PUT` | `/libros/{id}` | Editar libro existente |
| `DELETE` | `/libros/{id}` | Eliminar libro |

#### 📌 Ejemplo: Crear Libro

**Request:** `POST /libros`

```json
{
  "nombre": "Spring in Action",
  "autor": "Craig Walls",
  "biblioteca": {
    "id": 1
  }
}
```

**Response:** `201 Created`

```json
{
  "id": 3,
  "nombre": "Spring in Action",
  "autor": "Craig Walls",
  "biblioteca": {
    "id": 1,
    "nombre": "Biblioteca Central"
  }
}

---

## ⚙️ Instalación y Ejecución

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/Nicko699/Api-Biblioteca.git
```

### 2️⃣ Entrar al directorio del proyecto

```bash
cd Api-Biblioteca
```

### 3️⃣ Configurar la base de datos

Edita el archivo `src/main/resources/application.properties`:

```properties
# Configuración de MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

# Configuración de JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Puerto del servidor
server.port=8080
```

### 4️⃣ Compilar el proyecto

```bash
mvn clean install
```

### 5️⃣ Ejecutar la aplicación

```bash
mvn spring-boot:run
```

O ejecutar el JAR generado:

```bash
java -jar target/biblioteca-0.0.1-SNAPSHOT.jar
```

### 6️⃣ Acceder a la API

La API estará disponible en:

```
http://localhost:8080
```

## 🧪 Probar la API con Postman

### Colección de ejemplos

1. **Crear una biblioteca**
   - `POST http://localhost:8080/biblioteca`
   - Body (JSON): Ver ejemplo anterior

2. **Listar bibliotecas**
   - `GET http://localhost:8080/biblioteca?page=0&size=10`

3. **Obtener biblioteca por ID**
   - `GET http://localhost:8080/biblioteca/1`

4. **Crear un libro**
   - `POST http://localhost:8080/libros`
   - Body (JSON): Ver ejemplo anterior

5. **Listar libros**
   - `GET http://localhost:8080/libros?page=0&size=5`

6. **Actualizar libro**
   - `PUT http://localhost:8080/libros/1`

7. **Eliminar libro**
   - `DELETE http://localhost:8080/libros/1`







