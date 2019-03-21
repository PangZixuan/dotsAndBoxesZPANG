package com.example.wow92.dotsandboxes.classes;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Lines {
    private Integer lineID;
    private String lineType;
    private Boolean isfilled = Boolean.FALSE;
    private ArrayList<Box> neibors = new ArrayList<>();
    public void setLineID(Integer lineID) {
        this.lineID = lineID;
    }
/**
    public Lines(String lineType, int lineID){
        this.lineType = lineType;
        this.lineID = lineID;
    }
**/
    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public void fillLine(){
        this.isfilled = Boolean.TRUE;
    }
    public Boolean getIsfilled(){
        return isfilled;
    }

    public String getLineType() {
        return lineType;
    }

    public Integer getLineID(){
        return this.lineID;
    }

    @Override
    public String toString() {
        return this.lineID.toString();
    }

    public void setNeiborBox(Box box) {
        neibors.add(box);
    }

    public ArrayList<Box> getNeibors() {
        return neibors;
    }
}
