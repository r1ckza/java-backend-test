package com.backend.hoover.controller;

import com.backend.hoover.model.Input;
import com.backend.hoover.model.Output;
import com.backend.hoover.service.DatabaseWriter;
import com.backend.hoover.service.HooverNavigate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/hoover")
public class ServiceController {

    private final HooverNavigate hooverNavigate;
    private final DatabaseWriter databaseWriter;

    @Autowired
    public ServiceController(HooverNavigate hooverNavigate, DatabaseWriter databaseWriter) {
        this.hooverNavigate = hooverNavigate;
        this.databaseWriter = databaseWriter;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Output getHooverNavigationOutput(@Valid @RequestBody Input request) {
        databaseWriter.write(request);
        Output output = hooverNavigate.getOutput(request);
        databaseWriter.write(output);
        return output;
    }

}
