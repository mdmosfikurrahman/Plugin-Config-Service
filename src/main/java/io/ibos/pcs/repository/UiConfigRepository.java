package io.ibos.pcs.repository;

import io.ibos.pcs.entity.UiConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UiConfigRepository extends JpaRepository<UiConfig, Long> {
}
