package com.games.bean.arithmaticker;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Question {

    private int bigNumber;
    private Random rand;
    private final int MIN = 8;
    private final int MAX = 100;
    private final int SEVEN = 7;

    private int answer;
    private int incorrect1;
    private int incorrect2;
    private int incorrect3;

    private ArrayList<Integer> answers;
    private ArrayList<Integer> plusOrMinus;






    //Constructor to create a random question and random answers
    //Places all of the numbers into a list
    public Question(){
        //TODO
        rand = new Random();
        bigNumber = MIN + (rand.nextInt(1000) % (MAX - MIN + 1)); // Gives n such that 8 <= n < 100
                                                                 // by using formula " min + (rand() % (int)(max - min + 1)) "

        answer = bigNumber - SEVEN;

        plusOrMinus = new ArrayList<Integer>();
        plusOrMinus.add(-1);
        plusOrMinus.add(+1);

        incorrect1 = answer + 1 * getRand();
        incorrect2 = answer + 2 * getRand();
        incorrect3 = answer + 3 * getRand();

        answers = new ArrayList<Integer>();
        answers.add((Integer)answer);
        answers.add((Integer)incorrect1);
        answers.add((Integer)incorrect2);
        answers.add((Integer)incorrect3);
    }

    //EFFECTS: returns either +1 or -1
    private int getRand() {

        int localRand = rand.nextInt(2); // Gives n such that 0 <= n <= 1
                                         // by using formula " min + (rand() % (int)(max - min + 1)) "
        return plusOrMinus.get(localRand);
    }

    //EFFECTS: returns list of answers generated in the constructor
    public ArrayList<Integer> getAnswers(){
        return answers;
    }

    public int getCorrectAnswer() {
        return answer;
    }

    public String getBigNumber() {
        return Integer.toString(bigNumber);
    }
    }