package com.example.fitmasterversionf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PageExos extends AppCompatActivity {
    private Button quitter, suivant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_exos);

        quitter = (Button) findViewById(R.id.buttonQuitter);
        suivant = (Button) findViewById(R.id.buttonPrevListe);


        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainPage = new Intent(PageExos.this, Sec_Page.class);
                startActivity(mainPage);
            }
        });

        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent np = new Intent(PageExos.this, PageExos2.class);
                startActivity(np);
            }
        });
    }
}