package com.example.projectteam.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.projectteam.model.LoginModel;
import com.example.projectteam.model.PostAddProjectApiResponse;
import com.example.projectteam.model.ProjectModel;
import com.example.projectteam.repository.ProjectRepository;

public class LoginViewModel extends AndroidViewModel {
    public MutableLiveData<String> validEid=new MutableLiveData<>();
    public MutableLiveData<String> validPass=new MutableLiveData<>();
    ProjectRepository pRepo;
    public LoginViewModel(@NonNull Application application) {
        super(application);
        pRepo=new ProjectRepository(application);
    }


    public LiveData<LoginModel> login(LoginModel loginModel) {
        return pRepo.login(loginModel);
    }
}
