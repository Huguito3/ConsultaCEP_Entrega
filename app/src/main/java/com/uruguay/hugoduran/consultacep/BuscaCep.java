package com.uruguay.hugoduran.consultacep;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//Es correcto crear esta clase aqui? Comparar con intent asyncronico.
/**
 * Created by hugoduran on 8/6/16.
 */
public class BuscaCep extends AsyncTask<String,Void,String>{

    @Override
    protected String doInBackground(String... params) {
        try {
            URL endCEP= new URL("http://viacep.com.br/ws/"+params[0] +"/json/");
            HttpURLConnection urlConnection=(HttpURLConnection) endCEP.openConnection();
            urlConnection.setRequestMethod("GET");

            if (urlConnection.getResponseCode()==200){

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
