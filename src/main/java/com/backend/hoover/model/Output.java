package com.backend.hoover.model;

import java.util.Arrays;

public class Output {

    private final int[] coords;
    private final int patches;

    public Output(int[] coords, int patches) {
        this.coords = coords;
        this.patches = patches;
    }

    public int[] getCoords() {
        return coords;
    }

    public int getPatches() {
        return patches;
    }

    @Override
    public String toString() {
        return "Output{" + "coords=" + Arrays.toString(coords) + ", patches=" + patches + '}';
    }
}
