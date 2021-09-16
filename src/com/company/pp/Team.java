package com.company.pp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Team {
    public String id;
    public int members;
    public List<TeamPlayer> players;
    public Map<String, TeamPlayer> playerById = new HashMap<>();
    public TeamPlayer p1;
    public TeamPlayer p2;
    public TeamScore teamScore;

    public Team(String id, int members, List<Player> playerList) {
        this.id = id;
        this.members = members;
        this.players = addPlayers(playerList);
        teamScore = new TeamScore();
    }

    private List<TeamPlayer> addPlayers(List<Player> playerList) {
        List<TeamPlayer> players = new ArrayList<>();
        int i = 0;
        for (Player p : playerList) {
            TeamPlayer teamPlayer = new TeamPlayer(p, i++, false);
            players.add(teamPlayer);
            playerById.put(p.id, teamPlayer);
        }
        p1 = players.get(0);
        p2 = players.get(1);
        p1.setOnCrease();
        p2.setOnCrease();
        return players;
    }

    public void wideScore(int score) {
        teamScore.addScore(score,0);
    }

    public void addScore(int score) {
        teamScore.addScore(score,1);
        p1.addRuns(score);
        if(score%2==1){
            changeCrease();
        }
    }


    public TeamPlayer outAndNextPlayer() {
        TeamPlayer p = p1;
        p.setOut();

        for (int i = p.position; i < members; i++) {
            TeamPlayer newPlayer = players.get(i);
            if (!newPlayer.isOut && !newPlayer.isOnCrease) {
                newPlayer.setOnCrease();
                p1 = newPlayer;
                return newPlayer;
            }
        }
        return null;
    }

    public void changeCrease() {
        TeamPlayer temp = p1;
        p1 = p2;
        p2 = temp;
    }
    public  void printScore(){
        System.out.println("player score 4s 6s balls strikeRate");
        for(TeamPlayer p : players){
            System.out.println(p);
        }
        System.out.println(teamScore);
    }
}
