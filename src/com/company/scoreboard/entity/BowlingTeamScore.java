package com.company.scoreboard.entity;

import com.company.scoreboard.enums.BallType;

import java.util.ArrayList;
import java.util.List;


public class BowlingTeamScore extends TeamScore {
    private List<Over> overs;
    private int extraRun;
    private int wickets;
    private int bowls;

    public BowlingTeamScore() {
        super(0, 0, 0);
    }

    public void calculateScore(Over overs) {

    }

    public String toString() {
        String res = "Overs:" + overs.size() + "\n";
        res += "wickets:" + wickets + "\n";
        res += "bowls:" + bowls + "\n";
        res += "extraRun:" + extraRun + "\n";
        return res;
    }
}
