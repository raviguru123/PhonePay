package com.company.scoreboard.entity;

import com.company.scoreboard.enums.BallType;

public class BattingTeamScore extends TeamScore {
    public int totalRun;
    public int extraRun;

    public BattingTeamScore() {
        super(0, 0, 0);
    }

    @Override
    public void calculateScore(Over over) {
        this.setTotalNoOfOvers(this.getTotalNoOfOvers() + 1);
        for (Ball ball : over.getBalls()) {

            if (ball.getBallType().getValue().equals(BallType.NO_BALL.getValue()) ||
                    ball.getBallType().getValue().equals(BallType.WIDE_BALL.getValue())) {
                extraRun += 1;
            }
            totalRun += ball.getRun();
        }
    }

    public String toString() {
        String res = "Total Runs: " + totalRun + "\n";
        res += "Wickets:" + this.getTotalNoOfwickets() + "\n";
        res += "Overs:" + this.getTotalNoOfOvers() + "\n";
        res += "ExtraRuns:" + extraRun + "\n";
        return res;
    }
}
