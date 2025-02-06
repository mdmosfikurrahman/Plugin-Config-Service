package io.ibos.pcs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UiConfigResponse {

    private String componentName;
    private Map<String, String> configSettings;

}
