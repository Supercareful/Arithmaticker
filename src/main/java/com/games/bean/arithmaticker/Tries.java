package com.games.bean.arithmaticker;

public class Tries {

    public static int tries;

    //constructor to initiate number of tries to zero
    public Tries(){
        tries = 0;
    }

    //MODIFIES: this
    //EFFECTS: increments tries by one
    public void update(){
        tries++;
    }

    //REQUIRES: number of tries is greater than zero
    //MODIFIES: this
    //EFFECTS: sets tries back to zero
    public void reset(){
        tries = 0;
    }

    //EFFECTS: returns current number of tries
    public int getTries(){
        return tries;
    }
}