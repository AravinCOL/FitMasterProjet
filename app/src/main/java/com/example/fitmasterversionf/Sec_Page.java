package com.example.fitmasterversionf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sec_Page extends AppCompatActivity {
    private Button quitter, entrain, liste, sante;
    TextView textUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec__page);

        quitter = (Button) findViewById(R.id.buttonQuitter);
        entrain = (Button) findViewById(R.id.buttonEntrain);
        sante = (Button) findViewById(R.id.buttonAliments);
        liste = (Button) findViewById(R.id.buttonListe);

        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent np = new Intent(Sec_Page.this, MainActivity.class);
                startActivity(np);
            }
        });



        entrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent np = new Intent(Sec_Page.this, PageExo.class);
                startActivity(np);
            }
        });


        sante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent np = new Intent(Sec_Page.this, PageAlimentation.class);
                startActivity(np);

            }
        });

        liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent np = new Intent(Sec_Page.this, PageExos.class);
                startActivity(np);
            }
        });


    }
}




