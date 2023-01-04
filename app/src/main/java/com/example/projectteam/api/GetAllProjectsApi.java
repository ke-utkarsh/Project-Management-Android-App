package com.example.projectteam.api;

import com.example.projectteam.model.GetAllBooksApiRequest;
import com.example.projectteam.model.ProjectModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GetAllProjectsApi {
    @POST("showProjects")
    Call<List<ProjectModel>> getProjects(@Body GetAllBooksApiRequest requestBody);
}
