package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.dao.repository.SimCardActivationRepository;
import au.com.telstra.simcardactivator.mapper.SimCardActivationMapper;
import au.com.telstra.simcardactivator.model.dto.SimCardActivationDto;
import au.com.telstra.simcardactivator.model.request.ActivationCreateRequest;
import au.com.telstra.simcardactivator.model.response.ActivatorResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
    private final SimCardActivationRepository simCardActivationRepository;

    public void activate(ActivationCreateRequest request) {
        ActivatorResponse response = restTemplate.postForObject(actuatorEndpoint, request, ActivatorResponse.class);
        simCardActivationRepository.save(SimCardActivationMapper.toDto(request,
                Optional.ofNullable(response).orElse(ActivatorResponse.builder().success(false).build())));
    }

    public SimCardActivationDto getSimCardById(Long id) {
        return simCardActivationRepository.findById(id).map(SimCardActivationMapper::toDto).orElseThrow();
    }

    public List<SimCardActivationDto> getSimCards() {
        return simCardActivationRepository.findAll().stream().map(SimCardActivationMapper::toDto).collect(Collectors.toList());
    }
}
