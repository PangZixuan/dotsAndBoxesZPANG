package com.example.wow92.dotsandboxes.classes;

import android.widget.Toast;

import com.example.wow92.dotsandboxes.activities.MainActivity;

import java.util.ArrayList;

public class Board {
    private ArrayList<Box> boxes = new ArrayList<>();
    private Boolean gameOver = Boolean.FALSE;
    private String player = "B";
    private Integer blueScore=0;
    private Integer redScore=0;
    private Integer filledBoxes = 0;
    private Integer previousFilledBox = 0;


    public Board(ArrayList<Box> boxes){
        this.boxes = boxes;
    }
    public ArrayList<Box> getBoxes(){
        return this.boxes;
    }

    public Boolean getGameOver() { return gameOver; }

    @Override
    public String toString() {
        ArrayList<Integer> display = new ArrayList<>();
        for (int i=0;i<boxes.size();i++) {
            Box box = this.boxes.get(i);
            int x =box.getX();
            int y = box.getY();
            display.add(x);
            display.add(y);
        }
        return display.toString();
    }
    public void upDateBoard(){
        for (int i =0; i < boxes.size(); i ++){
            boxes.get(i).upDateBox();
        }
    }
    private void addPoint(){
        if (this.player == "R"){
            redScore+=1;
        }else{
            blueScore+=1;
        }
    }
    public String getPlayer(){return this.player;}

    public Integer getBlueScore() {
        return blueScore;
    }

    public Integer getRedScore() {
        return redScore;
    }

    public Boolean checkGameOver(){
        for (int i =0; i < boxes.size(); i ++){
            if (boxes.get(i).getIsCaptured()){
                this.filledBoxes += 1;
            }
        }
        if (filledBoxes > previousFilledBox){
            addPoint();
            previousFilledBox = filledBoxes;
        }else{
            if(this.player == "R"){
                this.player = "B";
            }else {
                this.player = "R";
            }
        }
        filledBoxes = 0;
        if (filledBoxes == boxes.size()){this.gameOver = Boolean.TRUE;}
        return gameOver;
    }
}
