package com.example.projectteam.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.projectteam.model.FilterModel;
import com.example.projectteam.model.GetAllBooksApiRequest;
import com.example.projectteam.model.ProjectModel;
import com.example.projectteam.repository.ProjectRepository;

import java.util.ArrayList;

public class MainViewModel extends AndroidViewModel {
    MutableLiveData<ArrayList<ProjectModel>> allProjects=new MutableLiveData<ArrayList<ProjectModel>>();
    ProjectRepository pRepo;
    public MainViewModel(@NonNull Application application) {
        super(application);
        pRepo=new ProjectRepository(application);
    }
    public LiveData<ArrayList<ProjectModel>> getResponseLiveData(GetAllBooksApiRequest apiRequest) {
        return pRepo.getProjects(apiRequest);
    }

}
