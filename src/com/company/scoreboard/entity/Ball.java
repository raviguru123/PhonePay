package com.company.scoreboard.entity;

import com.company.scoreboard.enums.BallType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Ball {
    private BallType ballType;
    private Integer run;
}
