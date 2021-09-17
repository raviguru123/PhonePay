package com.company.scoreboard.enums;

public enum BallType {

    WIDE_BALL("Wd"), NO_BALL("no"), DOT_BALL("dot"), WICKET_BALL("W"), RUN_BALL("run");


    private String value;

    public String getValue() {
        return this.value;
    }

    private BallType(String ball) {
        this.value = ball;
    }
}
