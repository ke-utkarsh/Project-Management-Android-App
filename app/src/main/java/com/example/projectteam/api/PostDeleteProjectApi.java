package com.example.projectteam.api;

import com.example.projectteam.model.PostAddProjectApiResponse;
import com.example.projectteam.model.ProjectModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostDeleteProjectApi {
    @POST("deleteProject")
    Call<PostAddProjectApiResponse> deleteProject(@Body ProjectModel projectModel);
}
