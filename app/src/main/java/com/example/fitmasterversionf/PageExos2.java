package com.example.fitmasterversionf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PageExos2 extends AppCompatActivity {
    private Button quitter, prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_exos2);
        quitter = (Button) findViewById(R.id.buttonQuitter);
        prev = (Button) findViewById(R.id.buttonPrevListe);


        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainPage = new Intent(PageExos2.this, Sec_Page.class);
                startActivity(mainPage);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent np = new Intent(PageExos2.this, PageExos.class);
                startActivity(np);
            }
        });
    }
}