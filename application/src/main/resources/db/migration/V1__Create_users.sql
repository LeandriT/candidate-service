CREATE TABLE users (
    uuid VARCHAR(36) NOT NULL PRIMARY KEY,
    first_name VARCHAR(255) DEFAULT NULL,
    last_name VARCHAR(255) DEFAULT NULL,
    password VARCHAR(255) DEFAULT NULL,
    role ENUM('USER', 'ADMIN') DEFAULT NULL,
    username VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL, -- Añadir columna email
    is_deleted BOOLEAN DEFAULT FALSE,
    deleted_at DATETIME,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE KEY UK_username (username),
    UNIQUE KEY UK_email (email)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
