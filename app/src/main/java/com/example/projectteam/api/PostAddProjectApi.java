package com.example.projectteam.api;

import com.example.projectteam.model.FilterModel;
import com.example.projectteam.model.PostAddProjectApiResponse;
import com.example.projectteam.model.ProjectModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostAddProjectApi {
    @POST("addProject")
    Call<PostAddProjectApiResponse> addProject(@Body ProjectModel projectModel);
}
