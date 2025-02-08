CREATE TABLE division
(
    id          BIGINT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    name_bn     VARCHAR(255) NOT NULL,
    coordinates VARCHAR(255) NOT NULL UNIQUE
);