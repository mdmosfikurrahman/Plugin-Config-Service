package io.ibos.pcs.service.impl;

import io.ibos.pcs.dto.response.*;
import io.ibos.pcs.service.LocationRestService;
import io.ibos.pcs.service.LocationViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationViewServiceImpl implements LocationViewService {

    private final LocationRestService locationRestService;

    @Override
    public UiConfigResponse getDivisions() {
        List<DivisionResponse> divisions = locationRestService.getDivisions();

        String htmlCode = buildDropdownHtml(
                "divisionAllDropdown",
                "Choose a Division:",
                divisions,
                DivisionResponse::getDivisionId,
                DivisionResponse::getDivisionName
        );

        Map<String, String> configSettings = new HashMap<>();
        configSettings.put("divisionDropdown", htmlCode);

        return new UiConfigResponse("divisionDropdown", configSettings);
    }

    @Override
    public UiConfigResponse getDistricts() {
        List<DistrictResponse> districts = locationRestService.getDistricts();

        String htmlCode = buildDropdownHtml(
                "districtAllDropdown",
                "Choose a District:",
                districts,
                DistrictResponse::getDistrictId,
                DistrictResponse::getDistrictName
        );

        Map<String, String> configSettings = new HashMap<>();
        configSettings.put("districtDropdown", htmlCode);

        return new UiConfigResponse("districtDropdown", configSettings);
    }

    @Override
    public UiConfigResponse getUpazilas() {
        List<UpazilaResponse> upazilas = locationRestService.getUpazilas();

        String htmlCode = buildDropdownHtml(
                "upazilaAllDropdown",
                "Choose an Upazila:",
                upazilas,
                UpazilaResponse::getUpazilaId,
                UpazilaResponse::getUpazilaName
        );

        Map<String, String> configSettings = new HashMap<>();
        configSettings.put("upazilaDropdown", htmlCode);

        return new UiConfigResponse("upazilaDropdown", configSettings);
    }

    @Override
    public UiConfigResponse getDistrictsByDivision(Long divisionId) {
        List<DistrictResponse> districts = locationRestService.getDistrictsByDivisionId(divisionId);

        String htmlCode = buildDropdownHtml(
                "districtDropdown",
                "Choose a District:",
                districts,
                DistrictResponse::getDistrictId,
                DistrictResponse::getDistrictName
        );

        Map<String, String> configSettings = new HashMap<>();
        configSettings.put("districtDropdown", htmlCode);

        return new UiConfigResponse("districtDropdown", configSettings);
    }

    @Override
    public UiConfigResponse getUpazilasByDistrictAndDivision(Long districtId, Long divisionId) {
        List<UpazilaResponse> upazilas = locationRestService.getUpazilasByDistrictIdAndDivisionId(districtId, divisionId);

        String htmlCode = buildDropdownHtml(
                "upazilaDropdown",
                "Choose an Upazila:",
                upazilas,
                UpazilaResponse::getUpazilaId,
                UpazilaResponse::getUpazilaName
        );

        Map<String, String> configSettings = new HashMap<>();
        configSettings.put("upazilaDropdown", htmlCode);

        return new UiConfigResponse("upazilaDropdown", configSettings);
    }

    @Override
    public LocationDetailsResponse getLocationDetails(Long upazilaId, Long districtId, Long divisionId) {
        return locationRestService.getLocationDetails(upazilaId, districtId, divisionId);
    }

    private <T> String buildDropdownHtml(
            String selectId,
            String labelText,
            List<T> items,
            Function<T, Long> getId,
            Function<T, String> getName
    ) {
        String options = items.stream()
                .map(item -> "<option value='" + getId.apply(item) + "'>" + getName.apply(item) + "</option>")
                .collect(Collectors.joining());

        return "<label for='" + selectId + "'>" + labelText + "</label>" + "<select id='" + selectId + "' name='" + selectId + "'>" + options + "</select>";
    }

}
