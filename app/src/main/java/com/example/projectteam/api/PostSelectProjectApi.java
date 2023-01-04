package com.example.projectteam.api;

import com.example.projectteam.model.PostAddProjectApiResponse;
import com.example.projectteam.model.ProjectModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostSelectProjectApi {
    @POST("selectProject")
    Call<List<ProjectModel>> selectProject(@Body ProjectModel projectModel);
}
