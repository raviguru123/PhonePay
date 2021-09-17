package com.company.scoreboard.services;

import com.company.scoreboard.entity.BattingTeamScore;
import com.company.scoreboard.entity.Player;
import com.company.scoreboard.entity.Team;
import com.company.scoreboard.entity.BattingTeamPlayer;
import com.company.scoreboard.entity.TeamScore;
import com.company.scoreboard.enums.PlayerStatus;

import java.util.ArrayList;
import java.util.List;

public class BattingTeam {
    Team team;
    Integer overs;
    BattingTeamPlayer strikePlayer;
    BattingTeamPlayer nonStrikePlayer;
    List<BattingTeamPlayer> battingTeamPlayerList = new ArrayList<>();
    private BattingTeamScore battingTeamScore;

    public BattingTeam() {
        this.battingTeamScore = new BattingTeamScore();
    }

    public List<BattingTeamPlayer> addTeam(Team team, Integer overs) {
        this.overs = overs;
        this.team = team;
        int position = 0;
        for (Player player : team.getPlayerList()) {
            battingTeamPlayerList.add(new BattingTeamPlayer(player.getName(), position + 1));
        }
        this.strikePlayer = battingTeamPlayerList.get(0);
        this.nonStrikePlayer = battingTeamPlayerList.get(1);
        return battingTeamPlayerList;
    }

    public void bowls(List<String> bowling) throws Exception {
        battingTeamScore.addOver(bowling);
        for (String bowl : bowling) {
            if (bowl.equals("W")) {
                if (battingTeamScore.getTotalNoOfwickets() == battingTeamPlayerList.size() - 1) {
                    System.out.println("All out Team " + team.getName());
                } else {
                    this.strikePlayer = getNextPlayer();
                }
            }
            if (bowl == "1" || bowl == "3" || bowl == "4" || bowl == "6") {
                Integer run = Integer.parseInt(bowl);
                this.increaseRun(run);
                if (bowl == "1" || bowl == "3") {
                    changeCrease();
                }
            }
        }

        printScore();
    }

    private void increaseRun(int run) {
        try {
            this.strikePlayer.addRun(run);
        } catch (Exception ex) {

        }
    }

    private BattingTeamPlayer getNextPlayer() {
        for (BattingTeamPlayer battingTeamPlayer : battingTeamPlayerList) {
            if (battingTeamPlayer.getPlayerStatus().equals(PlayerStatus.NOT_OUT.getValue())) {
                return battingTeamPlayer;
            }
        }
        return null;
    }

    private void changeCrease() {
        BattingTeamPlayer battingTeamPlayer = this.strikePlayer;
        this.strikePlayer = this.nonStrikePlayer;
        this.nonStrikePlayer = battingTeamPlayer;
    }

    public void printScore() {
        for (BattingTeamPlayer p : this.battingTeamPlayerList) {
            System.out.println(p);
        }
        System.out.println(battingTeamScore);
    }
}
