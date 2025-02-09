package io.ibos.pcs.repository;

import io.ibos.pcs.entity.location.Upazila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpazilaRepository extends JpaRepository<Upazila, Long> {

    List<Upazila> findByDistrict_IdAndDistrict_Division_Id(Long districtId, Long districtId1);

}
