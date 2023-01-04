package com.example.projectteam.api;

import com.example.projectteam.model.PostAddProjectApiResponse;
import com.example.projectteam.model.ProjectModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostUpdateProjectApi {
    @POST("updateProject")
    Call<PostAddProjectApiResponse> updateProject(@Body ProjectModel projectModel);
}
