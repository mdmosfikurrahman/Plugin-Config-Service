package io.ibos.pcs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PluginConfigRequest {

    private String clientName;
    private UiConfigRequest pluginUiConfig;

}
