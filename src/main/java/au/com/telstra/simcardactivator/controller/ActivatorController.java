package au.com.telstra.simcardactivator.controller;

import au.com.telstra.simcardactivator.model.request.ActivationCreateRequest;
import au.com.telstra.simcardactivator.service.ActivatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/activator")
public class ActivatorController {
    private final ActivatorService activatorService;

    @PostMapping
    public ResponseEntity<HttpStatus> active(@RequestBody ActivationCreateRequest activation) {
        activatorService.activate(activation);
        return ResponseEntity.ok().build();
    }
}
