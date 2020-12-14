package com.example.appcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView5);
        TarefaPais tarefa = new TarefaPais();
        tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil");

    }

    public void startBuscarPaisActivity(View view){
        Intent Acitivity = new Intent(this,BuscarPaisActivity.class);
        startActivity(Acitivity);
    }

    public void startBuscarEstadoActivity(View view){
        Intent Acitivity = new Intent(this,BuscarEstadoActivity.class);
        startActivity(Acitivity);
    }

    private class  TarefaPais extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... strings) {
            String retorno = Conexao.getDados(strings[0]);
            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {

            //textView.setText(s);
            /*super.onPostExecute(s);

            String casos = null;
            JSONObject jsonObject  = null;
            try {
                jsonObject = new JSONObject();
                casos = jsonObject.getString("cases");
            }catch (JSONException | ParseException e){
                e.printStackTrace();
            }
            textView.setText(casos + "chegou");*/

            String pais = null;
            String casos = null;
            String casosAtuais = null;
            String mortes = null;
            String recuperados = null;
            String atualizado = null;


            JSONObject jsonObject  = null;
            try {
                jsonObject = new JSONObject(s);

                JSONObject data = jsonObject.getJSONObject("data");
                pais = data.getString("country");
                casos = data.getString("confirmed");
                casosAtuais = data.getString("cases");
                mortes = data.getString("deaths");
                recuperados = data.getString("recovered");
                atualizado = data.getString("updated_at");

            } catch (JSONException | ParseException e) {
                e.printStackTrace();
            }
            textView.setText("Pais: " +pais+ "\n" +"Total de Casos: " +casos+ "\n"+ "Casos Atuais: " +casosAtuais+ "\n" + "Mortes: " +mortes+ "\n" + "Recuperados: " +recuperados+ "\n"+ "Dados Atualizados em: " +atualizado);

        }
    }


}

