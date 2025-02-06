package io.ibos.pcs.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UiConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String componentName;

    @Lob
    @Column(name = "config_settings", columnDefinition = "BLOB")
    private String configSettings;
}
