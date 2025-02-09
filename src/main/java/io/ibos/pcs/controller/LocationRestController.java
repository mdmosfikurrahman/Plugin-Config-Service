package io.ibos.pcs.controller;

import io.ibos.pcs.common.response.RestResponse;
import io.ibos.pcs.dto.response.DistrictResponse;
import io.ibos.pcs.dto.response.DivisionResponse;
import io.ibos.pcs.dto.response.UpazilaResponse;
import io.ibos.pcs.service.LocationRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location-details")
@RequiredArgsConstructor
public class LocationRestController {

    private final LocationRestService locationRestService;

    @GetMapping("/divisions")
    public RestResponse<List<DivisionResponse>> getAllDivisions() {
        List<DivisionResponse> response = locationRestService.getDivisions();
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved divisions", response);
    }

    @GetMapping("/districts")
    public RestResponse<List<DistrictResponse>> getAllDistricts() {
        List<DistrictResponse> response = locationRestService.getDistricts();
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved districts", response);
    }

    @GetMapping("/upazilas")
    public RestResponse<List<UpazilaResponse>> getAllUpazilas() {
        List<UpazilaResponse> response = locationRestService.getUpazilas();
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved upazilas", response);
    }

    @GetMapping("/districts/{divisionId}")
    public RestResponse<List<DistrictResponse>> getDistrictsByDivisionId(@PathVariable Long divisionId) {
        List<DistrictResponse> response = locationRestService.getDistrictsByDivisionId(divisionId);
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved districts", response);
    }

    @GetMapping("/upazilas/{districtId}/{divisionId}")
    public RestResponse<List<UpazilaResponse>> getUpazilasByDistrictIdAndDivisionId(@PathVariable Long districtId, @PathVariable Long divisionId) {
        List<UpazilaResponse> response = locationRestService.getUpazilasByDistrictIdAndDivisionId(districtId, divisionId);
        return RestResponse.success(HttpStatus.OK.value(), "Successfully retrieved upazilas", response);
    }

}
