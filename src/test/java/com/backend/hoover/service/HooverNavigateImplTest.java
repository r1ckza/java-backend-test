package com.backend.hoover.service;

import com.backend.hoover.model.Input;
import com.backend.hoover.model.Output;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class HooverNavigateImplTest {

    @Test
    public void assertThatOutputCoordinateIsZeroOneWithOnePatchWithGivenInput() {
        HooverNavigate hooverNavigate = new HooverNavigateImpl();
        Output output = hooverNavigate.getOutput(createInput());

        assertThat("X coordinate value", output.getCoords()[0], is(1));
        assertThat("Y coordinate value", output.getCoords()[1], is(3));
        assertThat("Number of patches", output.getPatches(), is(1));
    }

    private Input createInput() {
        Input input = new Input();
        input.setRoomSize(5,5);
        input.setCoords(1,2);
        List<int[]> patches = new ArrayList<>();
        patches.add(new int[]{1,0});
        patches.add(new int[]{2,2});
        patches.add(new int[]{2,3});
        input.setPatches(patches);
        input.setInstructions("NNESEESWNWW");
        return input;
    }
}

