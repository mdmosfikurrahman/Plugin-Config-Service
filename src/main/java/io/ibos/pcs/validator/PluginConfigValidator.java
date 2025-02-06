package io.ibos.pcs.validator;

import io.ibos.pcs.dto.request.PluginConfigRequest;
import io.ibos.pcs.dto.request.UiConfigRequest;
import io.ibos.pcs.common.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PluginConfigValidator {

    public static void validate(PluginConfigRequest request) {
        Map<String, String> errors = new HashMap<>();

        if (request.getClientName() == null || request.getClientName().isEmpty()) {
            errors.put("clientName", "Client name is required.");
        }

        if (request.getPluginUiConfig() == null) {
            errors.put("pluginUiConfig", "Plugin UI configuration is required.");
        } else {
            validateUiConfig(request.getPluginUiConfig(), errors);
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    private static void validateUiConfig(UiConfigRequest uiConfig, Map<String, String> errors) {
        if (uiConfig.getComponentName() == null || uiConfig.getComponentName().isEmpty()) {
            errors.put("componentName", "Component name is required.");
        }

        if (uiConfig.getConfigSettings() == null || uiConfig.getConfigSettings().isEmpty()) {
            errors.put("configSettings", "UI settings are required.");
        }
    }
}
