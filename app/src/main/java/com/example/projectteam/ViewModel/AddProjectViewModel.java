package com.example.projectteam.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.projectteam.model.PostAddProjectApiResponse;
import com.example.projectteam.model.ProjectModel;
import com.example.projectteam.repository.ProjectRepository;

public class AddProjectViewModel extends AndroidViewModel {

    public MutableLiveData<String> pNameValidations=new MutableLiveData<String>();

    public MutableLiveData<String> pDes=new MutableLiveData<>();
    public MutableLiveData<String> pDesValidations=new MutableLiveData<>();

    public MutableLiveData<String> dateValidations=new MutableLiveData<>();
    public MutableLiveData<String> tNameValidations=new MutableLiveData<>();
    ProjectRepository pRepo;
    public AddProjectViewModel(@NonNull Application application) {
        super(application);
        pRepo=new ProjectRepository(application);
    }
    public LiveData<PostAddProjectApiResponse> addBook(ProjectModel projectModel) {
        return pRepo.addProject(projectModel);
    }


    public boolean validatePName(String pName) {
        if(!pName.contains("Project")){

            return true;
        }
        else {
            pNameValidations.postValue("");
            return false;
        }
    }


    public LiveData<PostAddProjectApiResponse> updateProject(ProjectModel projectModel) {
        return pRepo.updateProject(projectModel);
    }
}
