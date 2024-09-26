CREATE TABLE users (
    uuid VARCHAR(36) NOT NULL PRIMARY KEY,
    first_name VARCHAR(255) DEFAULT NULL,
    last_name VARCHAR(255) DEFAULT NULL,
    password VARCHAR(255) DEFAULT NULL,
    role ENUM('USER', 'ADMIN') DEFAULT NULL,
    username VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    deleted_at DATETIME,
    created_at DATETIME,
    updated_at DATETIME,
    UNIQUE KEY UK_username (username(191)), -- Limitar el índice a los primeros 191 caracteres
    UNIQUE KEY UK_email (email(191)) -- Limitar el índice a los primeros 191 caracteres
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
