package io.ibos.pcs.service.impl;

import io.ibos.pcs.dto.response.UiConfigResponse;
import io.ibos.pcs.enums.District;
import io.ibos.pcs.enums.Division;
import io.ibos.pcs.enums.Thana;
import io.ibos.pcs.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LocationServiceImpl implements LocationService {

    @Override
    public UiConfigResponse getDivisions() {
        String htmlCode = buildDropdownHtml(Division.values());

        Map<String, String> configSettings = new HashMap<>();
        configSettings.put("divisionDropdown", htmlCode);

        return new UiConfigResponse("divisionDropDown", configSettings);
    }

    @Override
    public UiConfigResponse getDistricts(String divisionName) {
        Division selectedDivision = Division.valueOf(divisionName);
        List<District> districts = filterDistrictsByDivision(selectedDivision);

        String htmlCode = buildDropdownHtml("districtDropdown", "Choose a District:", districts);

        Map<String, String> configSettings = new HashMap<>();
        configSettings.put("districtDropdown", htmlCode);

        return new UiConfigResponse("districtDropDown", configSettings);
    }

    @Override
    public UiConfigResponse getThanas(String districtName) {
        District selectedDistrict = District.valueOf(districtName);
        List<Thana> thanas = filterThanasByDistrict(selectedDistrict);

        String htmlCode = buildDropdownHtml("thanaDropdown", "Choose a Thana:", thanas);

        Map<String, String> configSettings = new HashMap<>();
        configSettings.put("thanaDropdown", htmlCode);

        return new UiConfigResponse("thanaDropDown", configSettings);
    }

    private List<District> filterDistrictsByDivision(Division division) {
        return Stream.of(District.values())
                .filter(district -> district.getDivision() == division)
                .collect(Collectors.toList());
    }

    private List<Thana> filterThanasByDistrict(District district) {
        return Stream.of(Thana.values())
                .filter(thana -> thana.getDistrict() == district)
                .collect(Collectors.toList());
    }

    private String buildDropdownHtml(Enum<?>[] values) {
        String options = Arrays.stream(values)
                .map(value -> "<option value='" + value.name() + "'>" + getName(value) + "</option>")
                .collect(Collectors.joining());

        return "<label for='" + "divisionDropdown" + "'>" + "Choose a Division:" + "</label>" +
                "<select id='" + "divisionDropdown" + "' name='" + "divisionDropdown" + "'>" +
                options +
                "</select>";
    }


    private String buildDropdownHtml(String selectId, String labelText, List<?> values) {
        String options = values.stream()
                .map(value -> "<option value='" + value.toString() + "'>" + getName(value) + "</option>")
                .collect(Collectors.joining());

        return "<label for='" + selectId + "'>" + labelText + "</label>" +
                "<select id='" + selectId + "' name='" + selectId + "'>" +
                options +
                "</select>";
    }

    private String getName(Object value) {
        if (value instanceof Thana) {
            return ((Thana) value).getName();
        } else if (value instanceof District) {
            return ((District) value).getName();
        } else if (value instanceof Division) {
            return ((Division) value).getName();
        }
        return value.toString();
    }

}
