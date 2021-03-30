package com.example.fitmasterversionf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class PageExoPlank extends AppCompatActivity {
    private Button buttNext;
    private Chronometer chronometer;
    private long pauseOffset; //Varaible qui va nous permettre de calculer le tps entre le start du chrono et le moment ou on a mis pause
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_exo_plank);

        buttNext = (Button)findViewById(R.id.buttonPrevListe);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
        @Override
        public void onChronometerTick(Chronometer chronometer) {
            if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 3000) { //Pour exo de 30s ca coupe
                chronometer.setBase(SystemClock.elapsedRealtime());//Remet a 0 le chrono
                pauseChronometer(chronometer);
                buttNext.setVisibility(View.VISIBLE);
                buttNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent pageExoPlanche = new Intent(PageExoPlank.this,PageExoPompes.class);
                        startActivity(pageExoPlanche);
                    }
                });

                Toast.makeText(PageExoPlank.this, "Bravo!", Toast.LENGTH_SHORT).show();

            }
        }
    });


    }
    public void startChronometer(View v) { //Quand on appuie sur start
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset ); //Met le chrono a 0s
            chronometer.start();
            running = true;
        }
    }
    public void pauseChronometer(View v) { //Quand on appuie sur stop
        if (running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase(); //Va nous permettre de garder le tps quand on a mis pause
            running = false;
        }
    }

    public void resetChronometer(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }
}