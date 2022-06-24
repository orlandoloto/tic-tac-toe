package com.tictactoe.helper;

public class ConvertCoordinates {
    private final int limit;

    public ConvertCoordinates(int limit) {
        this.limit = limit;
    }

    public int convertRow(int value) {
        return (value - 1) / limit;
    }

    public int convertColumn(int value) {
        return (value - 1) % limit;
    }
}
