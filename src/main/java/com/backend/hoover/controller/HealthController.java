package com.backend.hoover.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping(value = "/health", method = RequestMethod.GET, produces = "application/json")
    public String getHealthCheck() {
        return "{\"status\":\"ok\"}";
    }

}

