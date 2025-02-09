CREATE TABLE upazila
(
    id          BIGINT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    name_bn     VARCHAR(255) NOT NULL,
    district_id BIGINT       NOT NULL,
    division_id BIGINT       NOT NULL,
    FOREIGN KEY (district_id) REFERENCES district (id) ON DELETE CASCADE
);