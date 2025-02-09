package io.ibos.pcs.service;

import io.ibos.pcs.dto.response.LocationDetailsResponse;
import io.ibos.pcs.dto.response.UiConfigResponse;

public interface LocationViewService {

    UiConfigResponse getDivisions();
    UiConfigResponse getDistricts();
    UiConfigResponse getUpazilas();
    UiConfigResponse getDistrictsByDivision(Long divisionId);
    UiConfigResponse getUpazilasByDistrictAndDivision(Long districtId, Long divisionId);
    LocationDetailsResponse getLocationDetails(Long upazilaId, Long divisionId, Long divisionId1);
}
