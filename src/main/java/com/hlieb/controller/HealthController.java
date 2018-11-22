package com.hlieb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    private Logger LOGGER = LoggerFactory.getLogger(HealthController.class);

    @GetMapping
    public ResponseEntity<?> healthCheck() {
        LOGGER.info("Checking health...");
        return new ResponseEntity<>("healthy", HttpStatus.OK);

    }
}
