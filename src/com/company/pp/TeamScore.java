package com.company.pp;

public class TeamScore {
    public int score;
    public int wickets;
    public int overs;
    public int bowls;
    public int extraRun;

    public TeamScore() {

    }

    public void addScore(int score, int bowlCount) {
        if(bowlCount==0){
            extraRun+=score;
        }
        this.score += score;
        this.bowls += bowlCount;
        this.overs = this.bowls / 6;
    }

    public void incrmentWickets() {
        this.wickets++;
    }

    public String toString() {
        String res = "Total: " + score + "\n";
        res += "Overs:" + overs+"\n";
        res+="TotalBowls:"+bowls+"\n";
        res+="ExtraRuns:"+extraRun+"\n";
        return res;
    }


}
