package com.company.scoreboard.entity;

import com.company.scoreboard.enums.PlayerStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BattingTeamPlayer extends Player {

    private PlayerStatus playerStatus = PlayerStatus.NOT_OUT;
    private PlayerScore playerScore;
    private Integer position;

    public BattingTeamPlayer(String name, Integer position) {
        super(name);
        this.playerScore =  PlayerScore.builder().build();
        this.position = position;
    }

    public void addRun(Integer run) {
        this.playerScore.addRuns(run);
    }

    public String toString() {
        return this.getName() + "   " + playerScore;
    }
}

