package com.example.wow92.dotsandboxes.classes;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class Box {
   // private static Box instance;
    private ArrayList<Lines> lines = new ArrayList<Lines>(4);
    private int x;
    private int y;
    private Boolean isCaptured = Boolean.FALSE;
    private Integer lineCaptured = 0;
    public Box(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void addLine(Lines line){
        this.lines.add(line);
        line.setNeiborBox(this);
    }
    public void captureBox(){
        this.isCaptured = Boolean.TRUE;
    }
    public ArrayList<Lines> getLines() {
        return lines;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Boolean getIsCaptured(){ return this.isCaptured; }

    public void upDateBox(){
        for (int i = 0; i< lines.size(); i++){
            if (lines.get(i).getIsfilled()){
                lineCaptured += 1;
            }
        }
        if(lineCaptured == 4){
            this.isCaptured = Boolean.TRUE;
        }
        lineCaptured = 0;
    }
    public Boolean twoLineFilled(){
        Integer filledLines = 0;
        for (Lines line : lines){
            if (line.getIsfilled()){
                filledLines +=1;
            }
        }
        if (filledLines ==2){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }
    public Box getInstance(){
        return this;
    }
}
