package com.company.scoreboard.entity;

import com.company.scoreboard.enums.BallType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Setter
public class Over {
    private Player p;

    @Builder.Default
    List<Ball> balls = new ArrayList<>();

    public void setBalls(Ball ball) {
        this.balls.add(ball);
    }
}
