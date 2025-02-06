package io.ibos.pcs.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PluginConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientName;

    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "ui_config_id")
    private UiConfig pluginUiConfig;
}
