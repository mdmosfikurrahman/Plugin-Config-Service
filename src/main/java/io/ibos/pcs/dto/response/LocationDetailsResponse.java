package io.ibos.pcs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDetailsResponse {

    private String divisionName;
    private String divisionNameBn;
    private String districtName;
    private String districtNameBn;
    private String upazilaName;
    private String upazilaNameBn;

}
