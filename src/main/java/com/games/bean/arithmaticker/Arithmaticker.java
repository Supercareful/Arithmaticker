package com.games.bean.arithmaticker;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


public class Arithmaticker extends ActionBarActivity {

    private Chronometer chronometer;
    private long timeWhenStopped = 0;
    private Question questions;
    private int answer;
    private String bigNumber;
    private ArrayList<Integer> choices;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private TextView bigQuestion;
    private Tries tries;
    private TextView triesCount;
    private int round;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arithmaticker_activity);
        chronometer = (Chronometer) findViewById(R.id.arith_timer);
        generateQuestion();
        tries = new Tries();
        triesCount = (TextView)findViewById(R.id.triesCounter);
        triesCount.setText("0");
        round = 0;
        chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        chronometer.start();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.arithmaticker_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void generateQuestion(){
        questions = new Question();
        bigNumber = questions.getBigNumber();
        answer = questions.getCorrectAnswer();
        choices = new ArrayList<Integer>();
        choices = questions.getAnswers();
        Collections.shuffle(choices);
        bigQuestion = (TextView)findViewById(R.id.bigNum);
        bigQuestion.setText(bigNumber);
        button1 = (Button)findViewById(R.id.button4);
        button2 = (Button)findViewById(R.id.button5);
        button3 = (Button)findViewById(R.id.button6);
        button4 = (Button)findViewById(R.id.button7);
        button1.setText(choices.get(0).toString());
        button2.setText(choices.get(1).toString());
        button3.setText(choices.get(2).toString());
        button4.setText(choices.get(3).toString());
    }

    public void startArithTimer(View v){
        chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        chronometer.start();
    }

    public void resetArithTimer(View v){
        chronometer.stop();
        chronometer.setBase(SystemClock.elapsedRealtime());
        timeWhenStopped = 0;
    }

    public void pauseArithTimer(View v){
        chronometer.stop();
        timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
    }


    public void buttonOne(View v){
        button1 = (Button) v;
        isCorrect(button1);
    }

    public void buttonTwo(View v){
        button2 = (Button) v;
        isCorrect(button2);
    }
    public void buttonThree(View v){
        button3 = (Button) v;
        isCorrect(button3);
    }

    public void buttonFour(View v){
        button4 = (Button) v;
        isCorrect(button4);
    }


    public void isCorrect(Button v){
        if(answer == Integer.parseInt((((Button) v).getText().toString()))){
            round++;
            if (round == 10){
                chronometer.stop();
                timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
                //chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                Intent goToGameOver = new Intent(getBaseContext(), GameOver.class);
                goToGameOver.putExtra("TIME", "Broken");
                goToGameOver.putExtra("TRIES", Integer.toString(tries.getTries()));
                startActivity(goToGameOver);
            } else {
                generateQuestion();
            }
        } else {
            tries.update();
            triesCount.setText(Integer.toString(tries.getTries()));
        }
    }
}
