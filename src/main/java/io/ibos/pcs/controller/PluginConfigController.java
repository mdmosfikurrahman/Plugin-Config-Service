package io.ibos.pcs.controller;

import io.ibos.pcs.common.response.RestResponse;
import io.ibos.pcs.dto.request.PluginConfigRequest;
import io.ibos.pcs.dto.request.PluginRequest;
import io.ibos.pcs.dto.response.PluginConfigResponse;
import io.ibos.pcs.dto.response.UiConfigResponse;
import io.ibos.pcs.service.PluginConfigService;
import io.ibos.pcs.validator.PluginConfigValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pluginConfig")
@RequiredArgsConstructor
public class PluginConfigController {

    private final PluginConfigService service;

    @PostMapping("/savePlugin")
    public RestResponse<PluginConfigResponse> savePluginConfig(@RequestBody PluginConfigRequest requestConfig) {
        PluginConfigValidator.validate(requestConfig);

        PluginConfigResponse response = service.savePluginConfig(requestConfig);
        return RestResponse.success(HttpStatus.CREATED.value(), "Plugin configuration saved successfully!", response);
    }

    @PostMapping("/getPlugin")
    public RestResponse<UiConfigResponse> getPluginConfig(@RequestBody PluginRequest pluginRequest) {
        UiConfigResponse response = service.getPluginConfig(pluginRequest);
        return RestResponse.success(HttpStatus.OK.value(), "Success", response);
    }
}
