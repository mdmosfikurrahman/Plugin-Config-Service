package io.ibos.pcs.repository;

import io.ibos.pcs.entity.PluginConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PluginConfigRepository extends JpaRepository<PluginConfig, Long> {

    @Query("SELECT pc FROM PluginConfig pc JOIN pc.pluginUiConfig ui " +
            "WHERE pc.clientName = :clientName AND pc.enabled = true AND ui.componentName = :componentName")
    Optional<PluginConfig> findByClientNameAndComponentName(String clientName, String componentName);

}
