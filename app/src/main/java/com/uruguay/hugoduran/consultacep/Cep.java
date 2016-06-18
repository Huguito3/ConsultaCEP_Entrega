package com.uruguay.hugoduran.consultacep;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hugoduran on 14/6/16.
 */
public class Cep {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String unidade;
    private String ibge;

    public Cep(String json) {
        try {
            JSONObject jsonO=new JSONObject(json);
            this.setCep((String) jsonO.get("cep"));
            this.setLogradouro((String) jsonO.get("logradouro"));
            this.setComplemento((String) jsonO.get("complemento"));
            this.setBairro((String) jsonO.get("bairro"));
            this.setLocalidade((String) jsonO.get("localidade"));
            this.setUf((String) jsonO.get("uf"));
            this.setUnidade((String) jsonO.get("unidade"));
            this.setIbge((String) jsonO.get("ibge"));
            this.setGia((String) jsonO.get("gia"));



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getCep() {
        return cep;

    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    private String gia;


}

