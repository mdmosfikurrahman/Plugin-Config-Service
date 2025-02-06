package io.ibos.pcs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PluginConfigResponse {

    private String clientName;
    private UiConfigResponse pluginUiConfig;

}
