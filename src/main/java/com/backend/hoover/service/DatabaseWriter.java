package com.backend.hoover.service;

import com.backend.hoover.model.Input;
import com.backend.hoover.model.Output;

public interface DatabaseWriter {

    boolean write(Output output);

    boolean write(Input input);
}
