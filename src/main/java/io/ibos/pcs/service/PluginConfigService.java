package io.ibos.pcs.service;

import io.ibos.pcs.dto.request.PluginConfigRequest;
import io.ibos.pcs.dto.request.PluginRequest;
import io.ibos.pcs.dto.response.PluginConfigResponse;
import io.ibos.pcs.dto.response.UiConfigResponse;

public interface PluginConfigService {

    PluginConfigResponse savePluginConfig(PluginConfigRequest requestConfig);
    UiConfigResponse getPluginConfig(PluginRequest pluginRequest);

}
