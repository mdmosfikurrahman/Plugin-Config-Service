package io.ibos.pcs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DistrictResponse {

    private Long districtId;
    private String districtName;
    private String districtNameBn;
    private String districtCoordinates;
    private List<UpazilaResponse> upazilas;

}
