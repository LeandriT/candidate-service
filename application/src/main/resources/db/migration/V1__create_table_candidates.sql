-- V1__create_candidates_table.sql

-- Creación de la tabla candidates para almacenar información de candidatos
CREATE TABLE candidates (
    uuid VARCHAR(36) PRIMARY KEY, -- UUID en formato de cadena, se utiliza como clave primaria
    name VARCHAR(255) NOT NULL, -- Nombre del candidato, no puede ser nulo
    email VARCHAR(255) NOT NULL, -- Correo electrónico del candidato, no puede ser nulo
    gender VARCHAR(50) NOT NULL, -- Género del candidato, no puede ser nulo
    salary_expected DECIMAL(19, 4) NOT NULL, -- Salario esperado, se almacena como número decimal con precisión y escala
    phone_number VARCHAR(50), -- Número de teléfono del candidato, puede ser nulo
    address VARCHAR(255), -- Dirección del candidato, puede ser nulo
    is_deleted BOOLEAN DEFAULT FALSE, -- Indica si el registro ha sido eliminado (soft delete), por defecto es FALSE
    deleted_at DATETIME, -- Marca de tiempo de cuándo fue eliminado el registro, puede ser nulo
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP, -- Marca de tiempo de cuándo fue creado el registro, por defecto se establece a la hora actual
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- Marca de tiempo de cuándo fue actualizado el registro, se actualiza automáticamente en cada modificación
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci; -- Configuración de caracteres y collation para soportar caracteres Unicode

-- Índices o restricciones adicionales pueden ser necesarios según tu modelo
-- Por ejemplo, si deseas agregar un índice para facilitar las búsquedas por nombre:
CREATE INDEX idx_candidates_name ON candidates (name); -- Índice en la columna name para optimizar las consultas que la incluyan
