CREATE TABLE ui_config
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    component_name  VARCHAR(255) NOT NULL,
    config_settings BLOB
);
