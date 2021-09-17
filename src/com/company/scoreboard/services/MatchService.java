package com.company.scoreboard.services;

import java.util.List;

public class MatchService {
    private static MatchService matchService = null;
    BattingTeam battingTeam;
    BowlingTeam bowlingTeam;

    private MatchService(BattingTeam battingTeam, BowlingTeam bowlingTeam) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
    }

    public static MatchService getInstance(BattingTeam battingTeam, BowlingTeam bowlingTeam) {
        if (matchService == null) {
            synchronized (MatchService.class) {
                if (matchService == null) {
                    matchService = new MatchService(battingTeam, bowlingTeam);
                }
            }
        }
        return matchService;
    }

    public void bowls(List<String> bowls) throws Exception{
        this.battingTeam.bowls(bowls);
    }


}
