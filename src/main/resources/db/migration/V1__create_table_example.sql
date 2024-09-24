-- V1__create_table_candidates.sql

CREATE TABLE candidates (
    id CHAR(36) NOT NULL,          -- UUID almacenado como CHAR(36)
    name VARCHAR(100) NOT NULL,    -- Nombre del candidato
    email VARCHAR(100) NOT NULL,   -- Correo electrónico del candidato
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Fecha de creación
    PRIMARY KEY (id)
);
