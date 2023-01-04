package com.example.projectteam.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.projectteam.api.PostDeleteProjectApi;
import com.example.projectteam.api.PostLoginApi;
import com.example.projectteam.api.PostSelectProjectApi;
import com.example.projectteam.api.PostUpdateProjectApi;
import com.example.projectteam.api.GetAllProjectsApi;
import com.example.projectteam.api.PostAddProjectApi;
import com.example.projectteam.api.RetrofitServer;
import com.example.projectteam.model.GetAllBooksApiRequest;
import com.example.projectteam.model.LoginModel;
import com.example.projectteam.model.PostAddProjectApiResponse;
import com.example.projectteam.model.ProjectModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectRepository {
    private Application application;
    private ArrayList<ProjectModel> projectArrayList = new ArrayList<>();
    private MutableLiveData<ArrayList<ProjectModel>> mutableLiveData = new MutableLiveData<>();
    private MutableLiveData<PostAddProjectApiResponse> postApiResponseMutable = new MutableLiveData<>();
    private MutableLiveData<ProjectModel> selectProjectResponse=new MutableLiveData<>();
    private MutableLiveData<LoginModel> loginModelMutableLiveData=new MutableLiveData<>();

    public ProjectRepository(Application application){this.application=application;}

    public MutableLiveData<ArrayList<ProjectModel>> getProjects(GetAllBooksApiRequest apiRequest) {
        GetAllProjectsApi apiService = RetrofitServer.getAllProjectsApi();
        Call<List<ProjectModel>> call = apiService.getProjects(apiRequest);
        call.enqueue(new Callback<List<ProjectModel>>() {
            @Override
            public void onResponse(Call<List<ProjectModel>> call, Response<List<ProjectModel>> response) {
                Log.d("response",response.body().toString());
                if (response.body() != null) {
                    projectArrayList = (ArrayList<ProjectModel>) response.body();
                    mutableLiveData.setValue(projectArrayList);
                }
            }
            @Override
            public void onFailure(Call<List<ProjectModel>> call, Throwable t) {
                Log.d("response","Get Api call failed");
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<PostAddProjectApiResponse> addProject(ProjectModel projectModel){
        PostAddProjectApi apiRequest=RetrofitServer.postAddProjectApi();
        Call<PostAddProjectApiResponse> call=apiRequest.addProject(projectModel);
        call.enqueue(new Callback<PostAddProjectApiResponse>() {
            @Override
            public void onResponse(Call<PostAddProjectApiResponse> call, Response<PostAddProjectApiResponse> response) {
                Log.d("response","Well done post");
                postApiResponseMutable.postValue(response.body());
                Toast.makeText(application.getApplicationContext(), response.body().getMsg(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<PostAddProjectApiResponse> call, Throwable t) {
                Log.d("response","Post Api call failed");
                Toast.makeText(application.getApplicationContext(), "Something went wrong! Please try again later", Toast.LENGTH_LONG).show();
            }
        });
        return postApiResponseMutable;
    }

    public MutableLiveData<PostAddProjectApiResponse> updateProject(ProjectModel projectModel) {
        PostUpdateProjectApi apiRequest=RetrofitServer.postUpdateProjectApi();
        Call<PostAddProjectApiResponse> call=apiRequest.updateProject(projectModel);
        call.enqueue(new Callback<PostAddProjectApiResponse>() {
            @Override
            public void onResponse(Call<PostAddProjectApiResponse> call, Response<PostAddProjectApiResponse> response) {
                Log.d("response","Well done post");
                postApiResponseMutable.postValue(response.body());
                Toast.makeText(application.getApplicationContext(), response.body().getMsg(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<PostAddProjectApiResponse> call, Throwable t) {
                Log.d("response","Post Api call failed");
                Toast.makeText(application.getApplicationContext(), "Something went wrong! Please try again later", Toast.LENGTH_LONG).show();
            }
        });
        return postApiResponseMutable;
    }

    public void deleteProject(ProjectModel projectModel) {
        PostDeleteProjectApi apiRequest=RetrofitServer.postDeleteProjectApi();
        Call<PostAddProjectApiResponse> call=apiRequest.deleteProject(projectModel);
        call.enqueue(new Callback<PostAddProjectApiResponse>() {
            @Override
            public void onResponse(Call<PostAddProjectApiResponse> call, Response<PostAddProjectApiResponse> response) {
                Log.d("response","Well done delete");
                Toast.makeText(application.getApplicationContext(), response.body().getMsg(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<PostAddProjectApiResponse> call, Throwable t) {
                Log.d("response","Post Api call failed");
                Toast.makeText(application.getApplicationContext(), "Something went wrong! Please try again later", Toast.LENGTH_LONG).show();
            }
        });
    }

    public MutableLiveData<ProjectModel> selectProject(ProjectModel projectModel) {
        PostSelectProjectApi apiRequest=RetrofitServer.postSelectProjectApi();
        Call<List<ProjectModel>> call=apiRequest.selectProject(projectModel);
        call.enqueue(new Callback<List<ProjectModel>>() {
            @Override
            public void onResponse(Call<List<ProjectModel>> call, Response<List<ProjectModel>> response) {

                if (response.body() != null) {
                    selectProjectResponse.postValue(response.body().get(0));
                }
            }
            @Override
            public void onFailure(Call<List<ProjectModel>> call, Throwable t) {
                Log.d("response","Get Api call failed");
            }
        });
        return selectProjectResponse;
    }

    public LiveData<LoginModel> login(LoginModel loginModel) {
        PostLoginApi apiRequest=RetrofitServer.postLoginApi();
        Call<List<LoginModel>> call=apiRequest.login(loginModel);
        call.enqueue(new Callback<List<LoginModel>>() {
            @Override
            public void onResponse(Call<List<LoginModel>> call, Response<List<LoginModel>> response) {
                loginModelMutableLiveData.postValue(response.body().get(0));
            }

            @Override
            public void onFailure(Call<List<LoginModel>> call, Throwable t) {
                Log.d("response","Get Api call failed");
                Toast.makeText(application.getApplicationContext(), "Something went wrong! Please try again later", Toast.LENGTH_LONG).show();

            }
        });
        return loginModelMutableLiveData;
    }
}
