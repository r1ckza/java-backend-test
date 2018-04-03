package com.backend.hoover.service;

import com.backend.hoover.model.Input;
import com.backend.hoover.model.Output;
import org.springframework.stereotype.Component;

@Component
public class HooverNavigateImpl implements HooverNavigate {

    @Override
    public Output getOutput(Input input) {
        return calculateOutput(input);
    }

    private Output calculateOutput(Input input) {
        int x = input.getCoords()[0];
        int xBoundary = input.getRoomSize()[0] - 1;

        int y = input.getCoords()[1];
        int yBoundary = input.getRoomSize()[1] - 1;

        int count = 0;
        char[] chars = input.getInstructions().toCharArray();
        for (char c : chars) {
            if (c == 'N' && y != yBoundary) {
                y = y + 1;
                count = count + countIncrement(input, x, y);
            } else if (c == 'S' && y != 0) {
                y = y - 1;
                count = count + countIncrement(input, x, y);
            } else if (c == 'E' && x != xBoundary) {
                x = x + 1;
                count = count + countIncrement(input, x, y);
            } else if (c == 'W' && x != 0) {
                x = x - 1;
                count = count + countIncrement(input, x, y);
            }
        }

        return new Output(new int[]{x,y}, count);
    }

    private int countIncrement(Input input, int x, int y) {
        return input.getPatches().removeIf(patch -> patch[0] == x && patch[1] == y) ? 1 : 0;
    }

}

