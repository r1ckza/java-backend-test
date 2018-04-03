package com.backend.hoover.service;

import com.backend.hoover.model.Input;
import com.backend.hoover.model.Output;

public interface HooverNavigate {

    Output getOutput(Input input);
}
