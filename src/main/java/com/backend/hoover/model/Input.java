package com.backend.hoover.model;

import java.util.Arrays;
import java.util.List;

public class Input {

    private int[] roomSize;
    private int[] coords;
    private List<int[]> patches;
    private String instructions;

    public void setRoomSize(int... roomSize) {
        this.roomSize = roomSize;
    }

    public void setCoords(int... coords) {
        this.coords = coords;
    }

    public void setPatches(List<int[]> patches) {
        this.patches = patches;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int[] getRoomSize() {
        return roomSize;
    }

    public int[] getCoords() {
        return coords;
    }

    public List<int[]> getPatches() {
        return patches;
    }

    public String getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        StringBuilder patchesOutput = new StringBuilder();
        patches.forEach(x -> patchesOutput.append(Arrays.toString(x)));
        return "Input{" + "roomSize=" + Arrays.toString(roomSize) + ", coords=" + Arrays.toString(coords) + ", patches="
                + patchesOutput + ", instructions='" + instructions + '\'' + '}';
    }

}
