package com.company.scoreboard.entity;

import lombok.Getter;

@Getter
public class Player {
    private String name;

    public Player(String id) {
        this.name = id;
    }
}
