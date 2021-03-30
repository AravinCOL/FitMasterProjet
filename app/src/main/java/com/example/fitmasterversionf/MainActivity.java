package com.example.fitmasterversionf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button connexionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connexionButton = (Button) findViewById(R.id.buttonIntro);
        connexionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pageExoAct = new Intent(getApplicationContext(), MainLogin.class);
                startActivity(pageExoAct);
            }
        });
    }
}