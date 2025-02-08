package io.ibos.pcs.repository;

import io.ibos.pcs.entity.location.Upazilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpazillaRepository extends JpaRepository<Upazilla, Long> {

    List<Upazilla> findByDistrict_IdAndDistrict_Division_Id(Long districtId, Long districtId1);

}
