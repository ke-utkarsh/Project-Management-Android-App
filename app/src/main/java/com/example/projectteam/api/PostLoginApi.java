package com.example.projectteam.api;

import com.example.projectteam.model.LoginModel;
import com.example.projectteam.model.PostAddProjectApiResponse;
import com.example.projectteam.model.ProjectModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostLoginApi {
    @POST("/login")
    Call<List<LoginModel>> login(@Body LoginModel loginModel);
}
