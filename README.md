📚 API REST Biblioteca
📖 Descripción del proyecto

Esta es una API REST de Biblioteca desarrollada con Spring Boot, cuyo objetivo es gestionar bibliotecas y libros aplicando una relación Uno a Muchos (One-To-Many) mediante JPA / Hibernate.

La API permite realizar operaciones CRUD (crear, leer, actualizar y eliminar) sobre las entidades Biblioteca y Libros, exponiendo endpoints REST que consumen y devuelven información en formato JSON.

En el modelo de datos:

Una Biblioteca puede contener muchos Libros.

Cada Libro pertenece a una sola Biblioteca.

El proyecto está estructurado en capas (Controller, Service y Model) y maneja correctamente:

Paginación de resultados

Códigos de respuesta HTTP

Serialización JSON sin referencias circulares

Buenas prácticas REST

🛠️ Requisitos

Para ejecutar el proyecto se necesita:

Java JDK 17 o superior

Apache Maven 3.8+

Spring Boot

IDE recomendado:

IntelliJ IDEA

NetBeans

Eclipse

Base de datos relacional:

MySQL 

Herramienta para probar la API:

Postman

🚀 Tecnologías utilizadas

☕ Java

🌱 Spring Boot

🗄️ Spring Data JPA

🐘 Hibernate

🧱 Maven

📡 Endpoints de la API
📘 Biblioteca
Método	Endpoint	Descripción
GET	/biblioteca	Listar bibliotecas (paginado)
GET	/biblioteca/{id}	Obtener biblioteca por ID
POST	/biblioteca	Crear biblioteca
PUT	/biblioteca/{id}	Editar biblioteca
DELETE	/biblioteca/{id}	Eliminar biblioteca

📌 Ejemplo POST /biblioteca

{
  "nombre": "Biblioteca Central",
  "listaLibros": [
    {
      "nombre": "Clean Code",
      "autor": "Robert C. Martin"
    }
  ]
}

📗 Libros
Método	Endpoint	Descripción
GET	/libros	Listar libros (paginado)
GET	/libros/{id}	Obtener libro por ID
POST	/libros	Crear libro
PUT	/libros/{id}	Editar libro
DELETE	/libros/{id}	Eliminar libro

📌 Ejemplo POST /libros

{
  "nombre": "Spring in Action",
  "autor": "Craig Walls",
  "biblioteca": {
    "id": 1
  }
}

📄 Paginación

Los endpoints GET soportan paginación usando Pageable.

Ejemplos:

/libros?page=0&size=5
/biblioteca?page=1&size=10

⚙️ Instalación y ejecución
1️⃣ Clonar el repositorio
git clone https://github.com/Nicko699/Biblioteca.git

2️⃣ Entrar al proyecto
cd Biblioteca

3️⃣ Ejecutar la aplicación
mvn spring-boot:run


La API quedará disponible en:

http://localhost:8080

🧪 Códigos de respuesta HTTP

200 OK → Operación exitosa

201 Created → Recurso creado correctamente

204 No Content → Recurso eliminado

400 Bad Request → Datos inválidos

404 Not Found → Recurso no encontrado

✅ Buenas prácticas aplicadas

✔ Arquitectura por capas
✔ API RESTful
✔ Uso de ResponseEntity
✔ Paginación
✔ Manejo correcto de relaciones JPA
✔ Serialización JSON segura
✔ Códigos HTTP estándar
