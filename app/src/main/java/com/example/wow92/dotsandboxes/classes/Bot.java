package com.example.wow92.dotsandboxes.classes;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Bot {
    private Board board;
    private ArrayList<Box> boxes= new ArrayList<>();
    private Integer themove;
    private Lines playerMove;
    //private Lines

    public Bot(Board board){
        this.board = board;
        boxes =board.getBoxes();
    }
    private Boolean dontAffectAnotherBox(Lines line){
        ArrayList<Box> neibors = line.getNeibors();
        if (neibors != null) {
            for (Box box : neibors) {
                if (box.twoLineFilled()) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }else{return Boolean.FALSE;}
    }
    private void fillLessThanThree(){
        for(Box box : boxes){
            if(!box.twoLineFilled()){
                ArrayList<Lines> lines =box.getLines();
                for (Lines line : lines){
                    if((!line.getIsfilled() )& dontAffectAnotherBox(line)){
                        line.fillLine();
                        board.upDateBoard();
                    }
                }
            }
        }
    }
    public void makeAMove() {
        fillLessThanThree();
    }











}
