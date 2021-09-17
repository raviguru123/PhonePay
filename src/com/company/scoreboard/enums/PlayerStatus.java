package com.company.scoreboard.enums;

import lombok.Getter;

@Getter
public enum PlayerStatus {
    OUT("out"),
    EXTRA("extra"),
    NOT_OUT("not_out"),
    STRIKE("strike"),
    NON_STRIKE("non_strike");

    private final String value;

    private PlayerStatus(final String value) {
        this.value = value;
    }
}
