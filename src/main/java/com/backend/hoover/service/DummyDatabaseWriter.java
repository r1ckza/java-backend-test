package com.backend.hoover.service;

import com.backend.hoover.model.Input;
import com.backend.hoover.model.Output;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DummyDatabaseWriter implements DatabaseWriter {

    @Override
    public boolean write(Output output) {
        System.out.println("Writing to database: " + output);
        return true;
    }

    @Override
    public boolean write(Input input) {
        System.out.println("Writing to database: " + input);
        System.out.print("patches:");
        input.getPatches().forEach(x -> System.out.print(Arrays.toString(x)));
        return true;
    }
}
