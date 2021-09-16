package com.company.pp;

public class PlayerScore {
    public int score;
    public int bowlFaced;
    public int fours;
    public int sixs;

    public PlayerScore(){

    }

    public void addScore(int run){
        score=score+run;
        bowlFaced++;
        if(run==4){
            fours++;
        }
        if(run==6){
            sixs++;
        }
    }

    public String toString(){
        double strikeRate = (double) score/(double) bowlFaced;
        return score + "    " + fours +"   "+ sixs +"   "+ bowlFaced+"   "+ String.format("%.2f",strikeRate*100);
    }
}
