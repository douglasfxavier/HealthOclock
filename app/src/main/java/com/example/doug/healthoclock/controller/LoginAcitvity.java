package com.example.doug.healthoclock.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.doug.healthoclock.R;

import java.io.IOException;

public class LoginAcitvity extends AppCompatActivity {
    private EditText editEmail, editSenha;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);


        this.editEmail = (EditText) findViewById(R.id.editEmailLogin);
        this.editSenha = (EditText) findViewById(R.id.editSenhaLogin);
        this.btnEntrar = (Button) findViewById(R.id.btnEntrarLogin);

        this.btnEntrar.setOnClickListener(new OnClickBotao());
    }

    private class OnClickBotao implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            if (v.equals(LoginAcitvity.this.btnEntrar)){
                Intent welcomeview = new Intent(LoginAcitvity.this,WelcomeActivity.class);
                startActivity(welcomeview);
            }

        }
    }

}
