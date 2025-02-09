package io.ibos.pcs.service;

import io.ibos.pcs.dto.response.DistrictResponse;
import io.ibos.pcs.dto.response.DivisionResponse;
import io.ibos.pcs.dto.response.UpazilaResponse;

import java.util.List;

public interface LocationRestService {

    List<DivisionResponse> getDivisions();
    List<DistrictResponse> getDistricts();
    List<UpazilaResponse> getUpazilas();
    List<DistrictResponse> getDistrictsByDivisionId(Long divisionId);
    List<UpazilaResponse> getUpazilasByDistrictIdAndDivisionId(Long districtId, Long divisionId);

}

