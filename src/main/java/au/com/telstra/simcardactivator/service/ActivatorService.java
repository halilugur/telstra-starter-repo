package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.model.request.ActivationCreateRequest;
import au.com.telstra.simcardactivator.model.response.ActivatorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ActivatorService {
    @Value("${rest.actuator-url}")
    private String actuatorEndpoint;
    private final RestTemplate restTemplate;

    public void activate(ActivationCreateRequest activationCreateRequest) {
        System.out.println(activationCreateRequest);
        ActivatorResponse response = restTemplate.postForObject(actuatorEndpoint, activationCreateRequest, ActivatorResponse.class);
        System.out.println(response);
    }
}
