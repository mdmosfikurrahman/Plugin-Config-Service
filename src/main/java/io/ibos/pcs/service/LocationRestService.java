package io.ibos.pcs.service;

import io.ibos.pcs.dto.response.DistrictResponse;
import io.ibos.pcs.dto.response.DivisionResponse;
import io.ibos.pcs.dto.response.UpazillaResponse;

import java.util.List;

public interface LocationRestService {

    List<DivisionResponse> getAllDivisions();
    List<DistrictResponse> getDistrictsByDivisionId(Long divisionId);
    List<UpazillaResponse> getUpazillasByDistrictIdAndDivisionId(Long districtId, Long divisionId);
}

