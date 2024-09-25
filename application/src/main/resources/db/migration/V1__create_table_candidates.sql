-- V1__create_candidates_table.sql

CREATE TABLE candidates (
    uuid VARCHAR(36) PRIMARY KEY, -- UUID en formato de cadena
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    gender VARCHAR(50) NOT NULL,
    salary_expected DECIMAL(19, 4) NOT NULL, -- Ajusta la precisión y escala según sea necesario
    phone_number VARCHAR(50),
    address VARCHAR(255),
    is_deleted BOOLEAN DEFAULT FALSE,
    deleted_at DATETIME,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Índices o restricciones adicionales pueden ser necesarios según tu modelo
-- Por ejemplo, si deseas agregar un índice para facilitar las búsquedas por nombre:
CREATE INDEX idx_candidates_name ON candidates (name);
