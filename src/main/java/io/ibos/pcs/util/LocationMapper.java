package io.ibos.pcs.util;

import io.ibos.pcs.dto.response.DistrictResponse;
import io.ibos.pcs.dto.response.DivisionResponse;
import io.ibos.pcs.dto.response.UpazillaResponse;
import io.ibos.pcs.entity.location.District;
import io.ibos.pcs.entity.location.Division;
import io.ibos.pcs.entity.location.Upazilla;
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
                .upazillas(district.getUpazillas() != null
                        ? district.getUpazillas().stream().map(this::toUpazillaResponse).toList()
                        : null)
                .build();
    }

    public UpazillaResponse toUpazillaResponse(Upazilla upazilla) {
        return UpazillaResponse.builder()
                .upazillaId(upazilla.getId())
                .upazillaName(upazilla.getName())
                .upazillaNameBn(upazilla.getNameBn())
                .build();
    }
}
