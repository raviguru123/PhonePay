package com.company.scoreboard.services;

import com.company.scoreboard.entity.Over;
import com.company.scoreboard.entity.Team;
import com.company.scoreboard.entity.BattingTeamPlayer;

import java.util.List;

public class BowlingTeam {
    Team team;
    Integer numberOfOvers;
    BattingTeamPlayer currentBowler;
    private List<Over> overs;

    public void addTeam(Team team, Integer numberOfOvers) {
        this.team = team;
        this.numberOfOvers = numberOfOvers;
    }
}
