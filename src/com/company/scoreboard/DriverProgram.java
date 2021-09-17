package com.company.scoreboard;

import com.company.pp.CricketMatch;
import com.company.scoreboard.entity.Player;
import com.company.scoreboard.entity.Team;
import com.company.scoreboard.services.BattingTeam;
import com.company.scoreboard.services.BowlingTeam;
import com.company.scoreboard.services.MatchService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DriverProgram {
    public static void main(String args[]) throws  Exception{
        List<Player> p1s = Arrays.stream(new String[]{"p11", "p12", "p13", "p14"}).map(Player::new).collect(Collectors.toList());
        List<Player> p2s = Arrays.stream(new String[]{"p21", "p22", "p23", "p24"}).map(Player::new).collect(Collectors.toList());


        Team team1 = Team.builder().name("team1").noOffPlayers(4).playerList(p1s).build();
        Team team2 = Team.builder().name("team2").noOffPlayers(4).playerList(p2s).build();

        BattingTeam battingTeam = new BattingTeam();
        battingTeam.addTeam(team1, 3);

        BowlingTeam bowlingTeam = new BowlingTeam();
        bowlingTeam.addTeam(team2, 3);


        MatchService matchService = MatchService.getInstance(battingTeam, bowlingTeam);
        matchService.bowls(Arrays.asList("4", "6", "W", "1", "1", "Wd", "Wd", "Wd", "1"));

        matchService.bowls(Arrays.asList("3", "0", "0", "0", "W", "6"));


//        match.bowls(Arrays.asList("3", "0", "0", "0", "W", "6"));
//
//        team1.printScore();
//
//        match.changeBatting();
//
//        match.bowls(Arrays.asList("4", "6", "1", "1", "1", "1"));
//        match.bowls(Arrays.asList("3", "0", "0", "0", "W", "6"));
//        team2.printScore();
//        System.out.println("Winner is " + match.winner());
    }
}
