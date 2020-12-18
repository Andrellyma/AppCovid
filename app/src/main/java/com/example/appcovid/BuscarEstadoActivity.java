package com.example.appcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.PrivateKey;

public class BuscarEstadoActivity extends AppCompatActivity {
    Spinner estados;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_estado);

        //Adicionando as String dentro do spinner
        estados = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.estados,android.R.layout.simple_spinner_item);
        estados.setAdapter(adapter);

        button = (Button) findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textViewResult);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BuscarPorEstado tarefa = new BuscarPorEstado();
                String item = estados.getSelectedItem().toString();
                Integer pos = estados.getSelectedItemPosition();
                Toast.makeText(getApplicationContext(),item, Toast.LENGTH_SHORT).show();
                if(item != null && pos == 1){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/ac");
                }else if(item != null && pos == 2){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/al");
                }else if(item != null && pos == 3){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/ap");
                }else if(item != null && pos == 4){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/am");
                }else if(item != null && pos == 5){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/ba");
                }else if(item != null && pos == 6){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/ce");
                }else if(item != null && pos == 7){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/df");
                }else if(item != null && pos == 8){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/es");
                }else if(item != null && pos == 9){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/go");
                }else if(item != null && pos == 10){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/ma");
                }else if(item != null && pos == 11){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/mt");
                }else if(item != null && pos == 12){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/ms");
                }else if(item != null && pos == 13){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/mg");
                }else if(item != null && pos == 14){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/pa");
                }else if(item != null && pos == 15){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/pb");
                }else if(item != null && pos == 16){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/pr");
                }else if(item != null && pos == 17){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/pe");
                }else if(item != null && pos == 18){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/pi");
                }else if(item != null && pos == 19){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/rr");
                }else if(item != null && pos == 20){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/ro");
                }else if(item != null && pos == 21){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/rj");
                }else if(item != null && pos == 22){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/rn");
                }else if(item != null && pos == 23){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/rs");
                }else if(item != null && pos == 24){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/sc");
                }else if(item != null && pos == 25){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/sp");
                }else if(item != null && pos == 26){
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/se");
                } else{
                    tarefa.execute("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/to");
                }
            }
        });
    }

    private class  BuscarPorEstado extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... strings) {
            String retorno = Conexao.getDados(strings[0]);
            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {

            super.onPostExecute(s);

            String estado = null;
            String suspeitos = null;
            String confirmados = null;
            String mortos = null;
            String recuperados = null;
            String dadosAtualizado = null;
            JSONObject jsonObject  = null;
            try {
                jsonObject = new JSONObject(s);
                estado = jsonObject.getString("state");
                suspeitos = jsonObject.getString("suspects");
                confirmados = jsonObject.getString("cases");
                mortos = jsonObject.getString("deaths");
                recuperados = jsonObject.getString("refuses");
                dadosAtualizado = jsonObject.getString("datetime");

            } catch (JSONException | ParseException e) {
                e.printStackTrace();
            }
            textView.setText("Estado: " +estado+ "\n" +"Suspeitos: " +suspeitos+ "\n"+ "Casos Confimados: " +confirmados+ "\n" + "Mortos: " +mortos+ "\n" + "Recuperados: " +recuperados+ "\n"+ "Dados Atualizados em: " +dadosAtualizado);
        }

    }
}
