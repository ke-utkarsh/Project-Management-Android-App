package com.example.projectteam.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.projectteam.model.ProjectModel;
import com.example.projectteam.repository.ProjectRepository;

public class ProfileActivityViewModel extends AndroidViewModel {
    ProjectRepository pRepo;
    public ProfileActivityViewModel(@NonNull Application application) {
        super(application);
        pRepo=new ProjectRepository(application);
    }

    public LiveData<ProjectModel> getResponseLiveData(ProjectModel projectModel) {
        return pRepo.selectProject(projectModel);
    }
    public void deleteProject(String pname){
        ProjectModel projectModel=new ProjectModel(0,pname,"","","","");
        pRepo.deleteProject(projectModel);
    }
}
