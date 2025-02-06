package io.ibos.pcs.service.impl;

import io.ibos.pcs.common.exception.NotFoundException;
import io.ibos.pcs.dto.request.PluginConfigRequest;
import io.ibos.pcs.dto.request.PluginRequest;
import io.ibos.pcs.dto.request.UiConfigRequest;
import io.ibos.pcs.dto.response.PluginConfigResponse;
import io.ibos.pcs.dto.response.UiConfigResponse;
import io.ibos.pcs.entity.PluginConfig;
import io.ibos.pcs.entity.UiConfig;
import io.ibos.pcs.repository.PluginConfigRepository;
import io.ibos.pcs.repository.UiConfigRepository;
import io.ibos.pcs.service.PluginConfigService;
import io.ibos.pcs.util.UiConfigMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PluginConfigServiceImpl implements PluginConfigService {

    private final PluginConfigRepository pluginConfigRepository;
    private final UiConfigRepository uiConfigRepository;
    private final UiConfigMapper uiConfigMapper;

    @Override
    public PluginConfigResponse savePluginConfig(PluginConfigRequest requestConfig) {
        PluginConfig existingPluginConfig = pluginConfigRepository
                .findByClientNameAndComponentName(requestConfig.getClientName(), requestConfig.getPluginUiConfig().getComponentName())
                .orElse(null);

        if (existingPluginConfig == null) {
            return createNewPluginConfig(requestConfig);
        }

        UiConfigRequest newUiConfigRequest = requestConfig.getPluginUiConfig();
        boolean isMatching = isUiConfigMatching(newUiConfigRequest, existingPluginConfig.getPluginUiConfig());

        if (isMatching) {
            return new PluginConfigResponse(existingPluginConfig.getClientName(),
                    uiConfigMapper.mapToUiConfigResponse(existingPluginConfig.getPluginUiConfig()));
        } else {
            existingPluginConfig.setEnabled(false);
            pluginConfigRepository.save(existingPluginConfig);

            return createNewPluginConfig(requestConfig);
        }
    }

    @Override
    public UiConfigResponse getPluginConfig(PluginRequest pluginRequest) {
        PluginConfig existingPluginConfig = pluginConfigRepository
                .findByClientNameAndComponentName(pluginRequest.getClientName(), pluginRequest.getComponentName())
                .orElseThrow(() -> new NotFoundException("PluginConfig not found for client: " + pluginRequest.getClientName() + " and component: " + pluginRequest.getComponentName()));

        UiConfig uiConfig = existingPluginConfig.getPluginUiConfig();

        UiConfigRequest requestConfig = new UiConfigRequest();
        requestConfig.setComponentName(pluginRequest.getComponentName());
        requestConfig.setConfigSettings(uiConfigMapper.stringToMap(uiConfig.getConfigSettings()));

        boolean isMatching = isUiConfigMatching(requestConfig, uiConfig);

        if (isMatching) {
            return uiConfigMapper.mapToUiConfigResponse(uiConfig);
        } else {
            throw new NotFoundException("UiConfig not found for component: " + pluginRequest.getComponentName());
        }
    }

    private PluginConfigResponse createNewPluginConfig(PluginConfigRequest requestConfig) {
        UiConfig uiConfig = uiConfigMapper.mapToUiConfig(requestConfig.getPluginUiConfig());
        uiConfigRepository.save(uiConfig);

        PluginConfig pluginConfig = new PluginConfig();
        pluginConfig.setClientName(requestConfig.getClientName());
        pluginConfig.setPluginUiConfig(uiConfig);
        pluginConfig.setEnabled(true);
        pluginConfigRepository.save(pluginConfig);

        return new PluginConfigResponse(requestConfig.getClientName(),
                uiConfigMapper.mapToUiConfigResponse(uiConfig));
    }

    private boolean isUiConfigMatching(UiConfigRequest requestConfig, UiConfig existingUiConfig) {
        if (!existingUiConfig.getComponentName().equals(requestConfig.getComponentName())) {
            return false;
        }

        Map<String, String> existingConfigMap = uiConfigMapper.stringToMap(existingUiConfig.getConfigSettings());
        Map<String, String> requestConfigMap = requestConfig.getConfigSettings();

        return existingConfigMap.equals(requestConfigMap);
    }

}
