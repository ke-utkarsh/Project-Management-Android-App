package com.example.projectteam.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServer {
    private static final String BASE_URL = "http://10.0.2.2:3000/";
    private static Retrofit retrofit = null;

    private static void MakeRetrofitServer(){

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    public static GetAllProjectsApi getAllProjectsApi(){
        MakeRetrofitServer();
        return retrofit.create(GetAllProjectsApi.class);
    }
    public static PostAddProjectApi postAddProjectApi(){
        MakeRetrofitServer();
        return retrofit.create(PostAddProjectApi.class);
    }

    public static PostUpdateProjectApi postUpdateProjectApi() {
        MakeRetrofitServer();
        return retrofit.create(PostUpdateProjectApi.class);
    }
    public static PostDeleteProjectApi postDeleteProjectApi(){
        MakeRetrofitServer();
        return retrofit.create(PostDeleteProjectApi.class);
    }
    public static PostSelectProjectApi postSelectProjectApi(){
        MakeRetrofitServer();
        return retrofit.create(PostSelectProjectApi.class);
    }
    public static PostLoginApi postLoginApi(){
        MakeRetrofitServer();
        return retrofit.create(PostLoginApi.class);
    }
}
