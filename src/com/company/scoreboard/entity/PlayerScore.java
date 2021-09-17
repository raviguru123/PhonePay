package com.company.scoreboard.entity;

import com.company.scoreboard.enums.RunType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PlayerScore {
    @Builder.Default
    private int score = 0;
    @Builder.Default
    private int bowlFaced = 0;
    @Builder.Default
    private int fours = 0;
    @Builder.Default
    private int sixs = 0;

    public void addRuns(Integer run) {
        this.score = this.score + run;
        bowlFaced += 1;

        switch (run) {
            case 4:
                fours += 1;
                break;
            case 6:
                sixs += 1;
                break;

            default:
                break;
        }
    }

    public String toString() {
        double strikeRate = (double) score / (double) bowlFaced;
        return score + "    " + fours + "   " + sixs + "   " + bowlFaced + "   " + String.format("%.2f", strikeRate * 100);
    }
}
