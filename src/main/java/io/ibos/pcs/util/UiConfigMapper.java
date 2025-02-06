package io.ibos.pcs.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ibos.pcs.dto.request.UiConfigRequest;
import io.ibos.pcs.dto.response.UiConfigResponse;
import io.ibos.pcs.entity.UiConfig;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class UiConfigMapper {

    private final ObjectMapper objectMapper;

    public UiConfigMapper() {
        this.objectMapper = new ObjectMapper();
    }

    public String mapToString(Map<String, String> configSettings) {
        try {
            return objectMapper.writeValueAsString(configSettings);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing config settings", e);
        }
    }

    public Map<String, String> stringToMap(String configSettings) {
        try {
            return objectMapper.readValue(configSettings, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing config settings", e);
        }
    }

    public UiConfig mapToUiConfig(UiConfigRequest requestConfig) {
        UiConfig uiConfig = new UiConfig();
        uiConfig.setComponentName(requestConfig.getComponentName());
        uiConfig.setConfigSettings(mapToString(requestConfig.getConfigSettings()));
        return uiConfig;
    }

    public UiConfigResponse mapToUiConfigResponse(UiConfig uiConfig) {
        return new UiConfigResponse(uiConfig.getComponentName(),
                stringToMap(uiConfig.getConfigSettings()));
    }
}
