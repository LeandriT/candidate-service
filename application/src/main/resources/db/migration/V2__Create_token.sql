CREATE TABLE tokens (
    uuid VARCHAR(36) NOT NULL PRIMARY KEY,
    is_logged_out BOOLEAN DEFAULT NULL,
    token VARCHAR(255) DEFAULT NULL,
    user_id VARCHAR(36) DEFAULT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    deleted_at DATETIME,
    created_at DATETIME,  -- Sin valor por defecto
    updated_at DATETIME,
    KEY FKe32ek7ixanakfqsdaokm4q9y2 (user_id),
    CONSTRAINT FKe32ek7ixanakfqsdaokm4q9y2 FOREIGN KEY (user_id) REFERENCES users (uuid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
