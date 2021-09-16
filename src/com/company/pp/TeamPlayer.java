package com.company.pp;

public class TeamPlayer {
    public Player p;
    public int position;
    PlayerScore score;
    public boolean isOut;
    public boolean isOnCrease = false;

    public TeamPlayer(Player p, int position, boolean isOut) {
        this.p = p;
        this.position = position;
        this.isOut = isOut;
        score = new PlayerScore();
    }

    public void addRuns(int run) {
        score.addScore(run);
    }

    public void setOnCrease() {
        isOnCrease = true;
    }

    public void setOut() {
        isOut = true;
        isOnCrease = false;
    }

    public String toString() {
        return p.id + "       " + score.toString();
    }
}
