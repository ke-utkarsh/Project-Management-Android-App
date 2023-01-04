package com.example.projectteam;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.projectteam.ViewModel.AddProjectViewModel;
import com.example.projectteam.databinding.ActivityAddProjectBinding;
import com.example.projectteam.model.FilterModel;
import com.example.projectteam.model.PostAddProjectApiResponse;
import com.example.projectteam.model.ProjectModel;

import java.util.Calendar;


public class AddProjectActivity extends AppCompatActivity {
    private ActivityAddProjectBinding binding;
    private String[] teams;
    private String[] project;
    AddProjectViewModel addViewModel;
    private boolean sdateClick=true,edateClick=true;
    private String sdateText="2022-11-04",edateText="2022-11-04",getEid,getName;
    private boolean isUpdate=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityAddProjectBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        addViewModel = new ViewModelProvider(this).get(AddProjectViewModel.class);

        Bundle b=getIntent().getExtras();
        getEid=b.getString("eid");
        getName=b.getString("username");
        if(b.getStringArray("Edit")!=null){
            project=b.getStringArray("Edit");
            isUpdate=true;
            binding.pname.setText(project[0]);
            binding.sdate.setText(project[1]);
            binding.edate.setText(project[2]);
            binding.pdes.setText(project[3]);
            binding.tname.setText(project[4]);
            binding.btnAdd.setText("   Update Project   ");
            binding.tvHeading.setText("Update Project");
            binding.pname.setEnabled(false);

        }

        teams=getResources().getStringArray(R.array.team_name);
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,R.layout.dropdown_item,teams);

        binding.tname.setAdapter(arrayAdapter);

        binding.sdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isUpdate) {
                    final Calendar c = Calendar.getInstance();
                    int year = c.get(Calendar.YEAR);
                    int month = c.get(Calendar.MONTH);
                    int day = c.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(AddProjectActivity.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {
                                    // on below line we are setting date to our text view.
                                    String day = "" + dayOfMonth, month = "" + (monthOfYear + 1);
                                    if (dayOfMonth < 10) day = "0" + dayOfMonth;
                                    if ((monthOfYear + 1) < 10) month = "0" + monthOfYear;
                                    binding.sdate.setText(year + "-" + month + "-" + day);
                                    sdateClick = false;
                                    sdateText = year + "-" + month + "-" + day;

                                }
                            }, year, month, day);
                    datePickerDialog.show();
                }else{
                    Toast.makeText(AddProjectActivity.this, "Only team name and description can be updated", Toast.LENGTH_LONG).show();
                }
            }
        });
        binding.edate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isUpdate) {
                    final Calendar c = Calendar.getInstance();
                    int year = c.get(Calendar.YEAR);
                    int month = c.get(Calendar.MONTH);
                    int day = c.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(AddProjectActivity.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {
                                    // on below line we are setting date to our text view.
                                    String day = "" + dayOfMonth, month = "" + (monthOfYear + 1);
                                    if (dayOfMonth < 10) day = "0" + dayOfMonth;
                                    if ((monthOfYear + 1) < 10) month = "0" + monthOfYear;
                                    binding.edate.setText(year + "-" + month + "-" + day);
                                    edateClick = false;
                                    edateText = year + "-" + month + "-" + day;
                                }
                            }, year, month, day);
                    datePickerDialog.show();
                }else{
                    Toast.makeText(AddProjectActivity.this, "Only team name and description can be updated", Toast.LENGTH_LONG).show();
                }
            }
        });
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.pname.getText().length()==0)addViewModel.pNameValidations.postValue("Project name cannot be empty");
                else if(addViewModel.validatePName(binding.pname.getText().toString()))addViewModel.pNameValidations.postValue("Project Name must have word Project");
                else if(binding.pdes.getText().length()<10)addViewModel.pDesValidations.postValue("Description must be of atlest 10 characters");
                else if(binding.tname.getText().toString().equals("Choose Team"))addViewModel.tNameValidations.postValue("Please select team");
                else{
                    if(!isUpdate) sendPostData();
                    else sendUpdateData();
                }
            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isUpdate){
                    Intent intent=new Intent(AddProjectActivity.this,ProfileActivity.class);
                    intent.putExtra("pname",binding.pname.getText().toString());
                    intent.putExtra("username",getName);
                    intent.putExtra("eid",getEid);
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(AddProjectActivity.this,MainActivity.class);
                    intent.putExtra("username",getName);
                    intent.putExtra("eid",getEid);
                    startActivity(intent);
                }

            }
        });


        addViewModel.pNameValidations.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.pnameValidations.setText(s);
            }
        });
        addViewModel.pDesValidations.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.pdesValidation.setText(s);
            }
        });
        addViewModel.dateValidations.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.dateValidation.setText(s);
            }
        });
        addViewModel.tNameValidations.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tnameValidations.setText(s);
            }
        });
    }

    private void sendUpdateData() {
        ProjectModel projectModel=new ProjectModel(0,binding.pname.getText().toString(),
                "","",binding.pdes.getText().toString(),binding.tname.getText().toString());
        addViewModel.updateProject(projectModel).observe(AddProjectActivity.this, new Observer<PostAddProjectApiResponse>() {
            @Override
            public void onChanged(PostAddProjectApiResponse postAddProjectApiResponse) {
                if(postAddProjectApiResponse.isRecord_created()){
                    Intent intent=new Intent(AddProjectActivity.this,ProfileActivity.class);
                    intent.putExtra("pname",binding.pname.getText().toString());
                    intent.putExtra("username",getName);
                    intent.putExtra("eid",getEid);
                    startActivity(intent);
                }
            }
        });
    }

    public void sendPostData(){
        ProjectModel projectModel=new ProjectModel(0,binding.pname.getText().toString(),
                binding.sdate.getText().toString(), binding.edate.getText().toString(),
                binding.pdes.getText().toString(),binding.tname.getText().toString());
        addViewModel.addBook(projectModel).observe(AddProjectActivity.this, new Observer<PostAddProjectApiResponse>() {
            @Override
            public void onChanged(PostAddProjectApiResponse postAddProjectApiResponse) {
                if(postAddProjectApiResponse.isRecord_created()){
                    Intent intent=new Intent(AddProjectActivity.this,MainActivity.class);
                    intent.putExtra("username",getName);
                    intent.putExtra("eid",getEid);
                    startActivity(intent);
                }

            }
        });
    }
//    public boolean checkDates(String sdate, String edate){
//        if (Integer.getInteger(sdate.substring(0,3))>Integer.getInteger(edate.substring(0,3)))return true;
//        else if(Integer.getInteger(sdate.substring(0,3))==Integer.getInteger(edate.substring(0,3))){
//            if(Integer.getInteger(sdate.substring(5,6))>Integer.getInteger(edate.substring(5,6)))return true;
//            else if(Integer.getInteger(sdate.substring(5,6))==Integer.getInteger(edate.substring(5,6))){
//                if(Integer.getInteger(sdate.substring(8))>Integer.getInteger(edate.substring(8)))return true;
//            }
//        }
//        return false;
//    }
}
