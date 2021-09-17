package com.company.scoreboard.entity;

import java.util.ArrayList;
import java.util.List;

public class BowlingTeamPlayer extends Player {
    private Player player;
    private List<Over> overList;

    private BowlingTeamPlayer(String name) {
        super(name);
        this.overList = new ArrayList<>();
    }
}
