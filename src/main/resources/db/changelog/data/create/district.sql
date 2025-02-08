CREATE TABLE district
(
    id          BIGINT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    name_bn     VARCHAR(255) NOT NULL,
    coordinates VARCHAR(255) NOT NULL UNIQUE,
    division_id BIGINT       NOT NULL,
    FOREIGN KEY (division_id) REFERENCES division (id) ON DELETE CASCADE
);