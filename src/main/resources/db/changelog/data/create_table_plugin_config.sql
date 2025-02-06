CREATE TABLE plugin_config
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    client_name  VARCHAR(255) NOT NULL,
    enabled      BOOLEAN      NOT NULL,
    ui_config_id BIGINT,
    FOREIGN KEY (ui_config_id) REFERENCES ui_config (id) ON DELETE SET NULL
);
