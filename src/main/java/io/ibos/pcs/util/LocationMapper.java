package io.ibos.pcs.util;

import io.ibos.pcs.dto.response.DistrictResponse;
import io.ibos.pcs.dto.response.DivisionResponse;
import io.ibos.pcs.dto.response.UpazilaResponse;
import io.ibos.pcs.entity.location.District;
import io.ibos.pcs.entity.location.Division;
import io.ibos.pcs.entity.location.Upazila;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public DivisionResponse toDivisionResponse(Division division) {
        return DivisionResponse.builder()
                .divisionId(division.getId())
                .divisionName(division.getName())
                .divisionNameBn(division.getNameBn())
                .divisionCoordinates(division.getCoordinates())
                .districts(division.getDistricts() != null
                        ? division.getDistricts().stream().map(this::toDistrictResponse).toList()
                        : null)
                .build();
    }

    public DistrictResponse toDistrictResponse(District district) {
        return DistrictResponse.builder()
                .districtId(district.getId())
                .districtName(district.getName())
                .districtNameBn(district.getNameBn())
                .districtCoordinates(district.getCoordinates())
                .upazilas(district.getUpazilas() != null
                        ? district.getUpazilas().stream().map(this::toUpazilaResponse).toList()
                        : null)
                .build();
    }

    public UpazilaResponse toUpazilaResponse(Upazila upazila) {
        return UpazilaResponse.builder()
                .upazilaId(upazila.getId())
                .upazilaName(upazila.getName())
                .upazilaNameBn(upazila.getNameBn())
                .build();
    }
}
