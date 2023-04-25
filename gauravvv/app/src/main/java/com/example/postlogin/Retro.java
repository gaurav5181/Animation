package com.example.postlogin;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retro {

    String baseurl = "https://gauswebsite.000webhostapp.com/";
    public static Retro retro;
    RetroApi retroApi;

    public Retro() {


        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build();
        retroApi = retrofit.create(RetroApi.class);
    }

    public static Retro getInstance() {

        if (retro == null) {

            retro = new Retro();
        }
        return retro;


    }
}

