package au.com.telstra.simcardactivator.controller;

import au.com.telstra.simcardactivator.model.dto.SimCardActivationDto;
import au.com.telstra.simcardactivator.model.request.ActivationCreateRequest;
import au.com.telstra.simcardactivator.service.ActivatorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ActivatorController {
    private final ActivatorService activatorService;

    @GetMapping
    public ResponseEntity<List<SimCardActivationDto>> getSimCards() {
        return ResponseEntity.ok().body(activatorService.getSimCards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SimCardActivationDto> getSimCardById(@PathVariable Long id) {
        return ResponseEntity.ok().body(activatorService.getSimCardById(id));
    }

    @PostMapping("/activator")
    public ResponseEntity<HttpStatus> active(@RequestBody ActivationCreateRequest activation) {
        activatorService.activate(activation);
        return ResponseEntity.ok().build();
    }
}
