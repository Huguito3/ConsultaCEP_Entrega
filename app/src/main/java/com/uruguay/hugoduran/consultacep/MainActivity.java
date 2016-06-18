package com.uruguay.hugoduran.consultacep;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText cep;
    private String cepS;
    private int largoCep;
    private Cep cepRecuperado;
    private String cepRetorno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //llamamos el boton
    public void buscarCep(View v){

        cep=(EditText) findViewById(R.id.edtCEP);
        if (cep != null) {
            cepS=cep.getText().toString().trim();
        }
        largoCep=cepS.length();

        if(largoCep!=8){
            Toast.makeText(this,"CEP Invalido",Toast.LENGTH_SHORT).show();
        }else{
            cep.setText(cepS.substring(0,5)+"-"+cepS.substring(5));
            Toast.makeText(this,"boton",Toast.LENGTH_SHORT).show();
            llamadaWS obterCep=new llamadaWS();
            obterCep.execute(cepS);
            //cepRetorno= String.valueOf(obterCep.execute(cepS));
            //cepRecuperado= new Cep(cepRetorno);
        }

    }

    private class llamadaWS extends AsyncTask<String, Void, Cep> {

        @Override
        protected Cep doInBackground(String... params) {
            try {
                URL endCEP= new URL("http://viacep.com.br/ws/"+params[0] +"/json/");
                HttpURLConnection urlConnection=(HttpURLConnection) endCEP.openConnection();
                urlConnection.setRequestMethod("GET");

                if (urlConnection.getResponseCode()==200){
                   //Obtenemos la respuesta
                     BufferedReader leyendoArchivo= new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    String linha="";
                    StringBuilder resposta= new StringBuilder();
                    while ((linha=leyendoArchivo.readLine())!=null){
                            resposta.append(linha);
                    }
                    urlConnection.disconnect();
                    cepRecuperado= new Cep(resposta.toString());
                    return cepRecuperado;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(Cep cep){
            TextView resultado= (TextView) findViewById(R.id.txtResultado);
            resultado.setText("CEP: " + cep.getCep().toString()+"\nLogradouro: "+cep.getLogradouro().toString()
                    +"\nComplemento: "+cep.getComplemento().toString()+"\nBairro: "+cep.getBairro().toString()
                    +"\nLocalidade: "+cep.getLocalidade().toString()
                    +"\nUF: "+cep.getUf().toString()+"\nUnidade: "+cep.getUnidade().toString()
                    +"\nIBGE: "+cep.getIbge().toString()+"\nGia: "+cep.getGia().toString());

        }
        }
    }

