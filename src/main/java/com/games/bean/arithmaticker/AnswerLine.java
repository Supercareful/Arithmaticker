package com.games.bean.arithmaticker;

public class AnswerLine {

    public static boolean correct;
    public static boolean incorrect;

    //constructor to initialize correct to false
    public AnswerLine(){
        correct = false;
        incorrect = false;
    }

    //EFFECTS: returns the current value of correct
    public boolean isCorrect(){
        return correct;
    }

    //EFFECTS: returns the current value of incorrect
    public boolean isIncorrect(){
        return incorrect;
    }

    //MODIFIES: this
    //EFFECTS: change correct to b
    public void setCorrect(boolean b){
        correct = b;
    }

    //MODIFIES: this
    //EFFECTS: change incorrect to b
    public void setIncorrect(boolean b){
        incorrect = b;
    }
}