package com.example.fitmasterversionf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainLogin extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup, signin;
    String userMan;
    DBHelper DB;

    public String getUserMan() {
        return userMan;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsignup);
        signin = (Button) findViewById(R.id.btnsignin);
        DB = new DBHelper(this);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                userMan = user;

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(MainLogin.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(MainLogin.this, "Inscription réussi", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Sec_Page.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(MainLogin.this, "Inscription échoué", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainLogin.this, "L'utlisateur existe déjà!  Veuillez vous connectez", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainLogin.this, "Ce mot de passe ne correspond pas", Toast.LENGTH_SHORT).show();
                    }
                } }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}