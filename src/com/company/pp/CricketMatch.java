package com.company.pp;

import java.util.*;
import java.util.stream.Collectors;

public class CricketMatch {
    public  Team team1;
    public  Team team2;
    public  int overs;
    public Team  batting;

    public CricketMatch(Team team1, Team team2, int overs){
        this.team1 = team1;
        this.team2 = team2;
        this.overs = overs;
        batting = team1;
    }

    public void bowls(List<String> bowling){
        int bowlCount = 0;
        for(String bowl : bowling){
            if(bowl.equals("W")){
                batting.addScore(0);
                if(batting.outAndNextPlayer()==null){
                    break;
                }
                bowlCount++;
            }else if(bowl.equals("Wd")){
                batting.wideScore(1);

            }else{
                bowlCount++;
                int runs = Integer.parseInt(bowl);
                batting.addScore(runs);
            }
            if(bowlCount%6==0){
                batting.changeCrease();
            }
        }
    }

    public  void changeBatting(){
        batting = team2;
    }

    public String winner(){
        if(team1.teamScore.score>team2.teamScore.score){
            return "team1";
        }else if(team1.teamScore.score<team2.teamScore.score){
            return "team2";
        }else{
            return "tie";
        }
    }

    public static void main(String[] args){
        List<Player> p1s = Arrays.stream(new String[]{"p11", "p12", "p13", "p14"}).map(Player::new).collect(Collectors.toList());
        List<Player> p2s = Arrays.stream(new String[]{"p21", "p22", "p23","p24"}).map(Player::new).collect(Collectors.toList());


        Team team1 = new Team("team1", 4, p1s);
        Team team2 = new Team("team2", 4, p2s);
        CricketMatch match = new CricketMatch(team1,team2,3);
        match.bowls(Arrays.asList("4", "6", "W", "1", "1", "Wd","Wd","Wd","1"));
        match.bowls(Arrays.asList("3", "0", "0", "0", "W", "6"));
//        match.bowls(Arrays.asList("W", "2", "3", "4", "4", "6"));
        team1.printScore();

        match.changeBatting();

        match.bowls(Arrays.asList("4", "6", "1", "1", "1", "1"));
        match.bowls(Arrays.asList("3", "0", "0", "0", "W", "6"));
//        match.bowls(Arrays.asList("W", "2", "3", "4", "3", "6"));

        team2.printScore();

        System.out.println("Winner is "+ match.winner());



    }


}
