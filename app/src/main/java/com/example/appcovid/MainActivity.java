package com.example.appcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startBuscarPaisActivity(View view){
        Intent Acitivity = new Intent(this,BuscarPaisActivity.class);
        startActivity(Acitivity);
    }
    public void startBuscarEstadoActivity(View view){
        Intent Acitivity = new Intent(this,BuscarEstadoActivity.class);
        startActivity(Acitivity);
    }
}

