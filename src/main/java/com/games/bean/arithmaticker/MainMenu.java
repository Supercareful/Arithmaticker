package com.games.bean.arithmaticker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by haihoang on 2015-03-11.
 */
public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        Button startButton = (Button) findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent goToArithmaticker = new Intent(getBaseContext(), Arithmaticker.class);
                startActivity(goToArithmaticker);
            }
        });
    }
}
