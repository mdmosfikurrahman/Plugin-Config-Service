package io.ibos.pcs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UiConfigRequest {

    private String componentName;
    private Map<String, String> configSettings;

}
