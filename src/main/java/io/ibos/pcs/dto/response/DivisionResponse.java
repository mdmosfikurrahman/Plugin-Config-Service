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
public class DivisionResponse {

    private Long divisionId;
    private String divisionName;
    private String divisionNameBn;
    private String divisionCoordinates;
    private List<DistrictResponse> districts;

}
