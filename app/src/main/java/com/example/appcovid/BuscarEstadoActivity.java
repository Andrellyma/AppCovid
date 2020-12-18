package com.example.appcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class BuscarEstadoActivity extends AppCompatActivity {
    Spinner estados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_estado);

        //Adicionando as String dentro do spinner
        estados = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.estados,android.R.layout.simple_spinner_item);
        estados.setAdapter(adapter);

    }


}
