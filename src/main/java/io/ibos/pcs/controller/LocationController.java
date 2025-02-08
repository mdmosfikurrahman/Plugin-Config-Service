package io.ibos.pcs.controller;

import io.ibos.pcs.common.response.RestResponse;
import io.ibos.pcs.dto.response.DistrictResponse;
import io.ibos.pcs.dto.response.DivisionResponse;
import io.ibos.pcs.dto.response.UiConfigResponse;
import io.ibos.pcs.dto.response.UpazillaResponse;
import io.ibos.pcs.service.LocationRestService;
import io.ibos.pcs.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;
    private final LocationRestService locationRestService;

    @GetMapping("/getDivisions")
    public RestResponse<UiConfigResponse> getDivisions() {
        UiConfigResponse response = locationService.getDivisions();
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved divisions", response);
    }

    @GetMapping("/getDistricts/{divisionName}")
    public RestResponse<UiConfigResponse> getDistricts(@PathVariable String divisionName) {
        UiConfigResponse response = locationService.getDistricts(divisionName);
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved districts", response);
    }

    @GetMapping("/getThanas/{districtName}")
    public RestResponse<UiConfigResponse> getThanas(@PathVariable String districtName) {
        UiConfigResponse response = locationService.getThanas(districtName);
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved thanas", response);
    }

    @GetMapping("/divisions")
    public RestResponse<List<DivisionResponse>> getAllDivisions() {
        List<DivisionResponse> response = locationRestService.getAllDivisions();
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved divisions", response);
    }

    @GetMapping("/districts/{divisionId}")
    public RestResponse<List<DistrictResponse>> getDistrictsByDivisionId(@PathVariable Long divisionId) {
        List<DistrictResponse> response = locationRestService.getDistrictsByDivisionId(divisionId);
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved districts", response);
    }

    @GetMapping("/upazillas/{districtId}/{divisionId}")
    public RestResponse<List<UpazillaResponse>> getUpazillasByDistrictIdAndDivisionId(@PathVariable Long districtId, @PathVariable Long divisionId) {
        List<UpazillaResponse> response = locationRestService.getUpazillasByDistrictIdAndDivisionId(districtId, divisionId);
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved upazillas", response);
    }
}
