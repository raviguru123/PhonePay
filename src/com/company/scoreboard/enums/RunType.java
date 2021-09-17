package com.company.scoreboard.enums;

public enum RunType {
    SINGLE(1),
    DOUBLE(2),
    TRIPPLE(3),
    FOUR(4),
    SIX(6);

    private final int value;

    RunType(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
