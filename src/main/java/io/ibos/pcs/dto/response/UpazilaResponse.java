package io.ibos.pcs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpazilaResponse {

    private Long upazilaId;
    private String upazilaName;
    private String upazilaNameBn;

}
