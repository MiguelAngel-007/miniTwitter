package com.androidavanzado.cl05_minitwitter.retrofit;

import com.androidavanzado.cl05_minitwitter.common.Constantes;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MiniTwitterClient {
    private static MiniTwitterClient instance = null;
    private MiniTwitterService miniTwitterService;
    private Retrofit retrofit;
    //variable temporal porque el certificado no sirve
    OkHttpClient okHttpClient = AuthTwitterClient.UnsafeOkHttpClient.getUnsafeOkHttpClient();


    public MiniTwitterClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_MINITWITTER_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        miniTwitterService = retrofit.create(MiniTwitterService.class);
    }

    // Patrón Singleton
    public static MiniTwitterClient getInstance() {
        if(instance == null) {
            instance = new MiniTwitterClient();
        }
        return instance;
    }

    public MiniTwitterService getMiniTwitterService() {
        return miniTwitterService;
    }


}
