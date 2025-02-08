package io.ibos.pcs.repository;

import io.ibos.pcs.entity.location.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

    List<District> findByDivision_Id(Long divisionId);

}
