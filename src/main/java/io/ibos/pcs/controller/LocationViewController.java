package io.ibos.pcs.controller;

import io.ibos.pcs.common.response.RestResponse;
import io.ibos.pcs.dto.response.UiConfigResponse;
import io.ibos.pcs.service.LocationViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationViewController {

    private final LocationViewService locationViewService;

    @GetMapping("/divisions")
    public RestResponse<UiConfigResponse> getDivisions() {
        UiConfigResponse response = locationViewService.getDivisions();
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved divisions", response);
    }

    @GetMapping("/districts")
    public RestResponse<UiConfigResponse> getDistricts() {
        UiConfigResponse response = locationViewService.getDistricts();
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved districts", response);
    }

    @GetMapping("/upazilas")
    public RestResponse<UiConfigResponse> getUpazilas() {
        UiConfigResponse response = locationViewService.getUpazilas();
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved upazilas", response);
    }

    @GetMapping("/districts/{divisionId}")
    public RestResponse<UiConfigResponse> getDistrictsByDivision(@PathVariable Long divisionId) {
        UiConfigResponse response = locationViewService.getDistrictsByDivision(divisionId);
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved districts", response);
    }

    @GetMapping("/upazilas/{districtId}/{divisionId}")
    public RestResponse<UiConfigResponse> getUpazilasByDistrictAndDivision(@PathVariable Long districtId, @PathVariable Long divisionId) {
        UiConfigResponse response = locationViewService.getUpazilasByDistrictAndDivision(districtId, divisionId);
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved upazilas", response);
    }
}
