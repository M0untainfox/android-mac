package com.example.mountainfox.applicationct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String EXTRA_VAL = "USER";
    final String MDP = "Admin";
    final String USER = "Admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button loginButton = (Button) findViewById(R.id.btnCo);
        final EditText editMDP = (EditText) findViewById(R.id.editPass);
        final EditText editUser = (EditText) findViewById(R.id.editUser);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(editMDP.getText().toString().equals("Admin")){
                Intent intent = new Intent(MainActivity.this, Menu.class);
                intent.putExtra(EXTRA_VAL, editUser.getText().toString());
                startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Erreur dans le mot de passe!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

