package com.company.scoreboard.entity;

import com.company.scoreboard.enums.BallType;
import lombok.Getter;
import lombok.Setter;

import javax.sound.midi.SysexMessage;
import java.util.List;

@Getter
@Setter
public abstract class TeamScore {
    private int totalNoOfBowls;
    private int totalNoOfwickets;
    private int totalNoOfOvers;

    public TeamScore(int totalNoOfBowls, int totalNoOfwickets, int totalNoOfOvers) {
        this.totalNoOfBowls = totalNoOfBowls;
        this.totalNoOfwickets = totalNoOfwickets;
        this.totalNoOfOvers = totalNoOfOvers;
    }

    public void addOver(List<String> listBalls) {
        Over over = Over.builder().build();
        for (String bowl : listBalls) {
            int run = 0;
            BallType ballType;

            if (bowl.equals(BallType.WIDE_BALL.getValue())) {
                ballType = BallType.WIDE_BALL;
                run = 1;
            } else if (bowl.equals(BallType.WICKET_BALL.getValue())) {
                ballType = BallType.WICKET_BALL;
                totalNoOfwickets += 1;
            } else {
                ballType = BallType.RUN_BALL;
                run = Integer.parseInt(bowl);
            }
            totalNoOfBowls += 1;
            over.setBalls(Ball
                    .builder()
                    .ballType(ballType)
                    .run(run)
                    .build());


        }

        this.calculateScore(over);
    }

    public abstract void calculateScore(Over over);
}
