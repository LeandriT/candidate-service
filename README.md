# Candidate Service

Este es un servicio RESTful desarrollado con **Spring Boot** que gestiona operaciones relacionadas con candidatos, como crear, actualizar, eliminar y obtener detalles de candidatos. El servicio también ofrece la funcionalidad de paginación.

## Requisitos previos

Asegúrate de tener instalados los siguientes componentes:

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Gradle](https://gradle.org/install/)
- [MySQL](https://www.mysql.com/downloads/)

## Configuración del proyecto

Este proyecto utiliza **Gradle** como herramienta de construcción. A continuación se muestra la configuración básica del archivo `build.gradle`:

# CandidateController

El `CandidateController` es un controlador RESTful en el servicio de gestión de candidatos. Proporciona operaciones para crear, actualizar, eliminar y obtener detalles de candidatos. Este controlador utiliza la arquitectura de Spring Boot y está diseñado para interactuar con un sistema de almacenamiento de datos a través de casos de uso.

## Rutas API

### 1. Obtener lista de candidatos paginados

- **Método:** `GET`
- **Endpoint:** `/api/v1/candidates`
- **Parámetros:**
    - `page`: Número de página a obtener (ejemplo: `0`)
    - `size`: Número de elementos por página (ejemplo: `10`)
- **Descripción:** Obtiene una lista paginada de candidatos.

#### Respuesta
- **Código 200:** Lista de candidatos obtenida correctamente.
- **Código 400:** Solicitud inválida.
- **Código 500:** Error interno del servidor.

### 2. Crear candidato

- **Método:** `POST`
- **Endpoint:** `/api/v1/candidates`
- **Cuerpo de la solicitud:**
    - `CandidateRequest`: Detalles del candidato a crear.

#### Respuesta
- **Código 201:** Candidato creado correctamente, devuelve los detalles del candidato.
- **Código 400:** Solicitud inválida.

### 3. Actualizar candidato

- **Método:** `PUT`
- **Endpoint:** `/api/v1/candidates/{uuid}`
- **Parámetros:**
    - `uuid`: UUID del candidato a actualizar.
- **Cuerpo de la solicitud:**
    - `CandidateRequest`: Detalles del candidato a actualizar.

#### Respuesta
- **Código 200:** Candidato actualizado correctamente, devuelve los detalles del candidato actualizado.
- **Código 404:** Candidato no encontrado.
- **Código 400:** Solicitud inválida.

### 4. Obtener candidato por UUID

- **Método:** `GET`
- **Endpoint:** `/api/v1/candidates/{uuid}`
- **Parámetros:**
    - `uuid`: UUID del candidato a obtener.

#### Respuesta
- **Código 200:** Detalles del candidato devueltos correctamente.
- **Código 404:** Candidato no encontrado.

### 5. Eliminar candidato por UUID

- **Método:** `DELETE`
- **Endpoint:** `/api/v1/candidates/{uuid}`
- **Parámetros:**
    - `uuid`: UUID del candidato a eliminar.

#### Respuesta
- **Código 204:** Candidato eliminado correctamente.
- **Código 404:** Candidato no encontrado.

## Dependencias y Anotaciones

- **Lombok:** Utilizado para inyección de dependencias y reducción de código boilerplate.
- **Spring Web:** Para la creación de APIs RESTful.
- **Swagger:** Para documentación automática de la API.
- **Validación:** Utiliza validaciones de Spring para la entrada del usuario.
