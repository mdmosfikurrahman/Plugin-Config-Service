package io.ibos.pcs.service;

import io.ibos.pcs.dto.response.UiConfigResponse;

public interface LocationService {

    UiConfigResponse getDivisions();

    UiConfigResponse getDistricts(String divisionName);

    UiConfigResponse getThanas(String districtName);


}
