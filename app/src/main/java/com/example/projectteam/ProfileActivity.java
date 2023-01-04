package com.example.projectteam;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.projectteam.ViewModel.AddProjectViewModel;
import com.example.projectteam.ViewModel.ProfileActivityViewModel;
import com.example.projectteam.databinding.ActivityAddProjectBinding;
import com.example.projectteam.databinding.ActivityProfileBinding;
import com.example.projectteam.model.FilterModel;
import com.example.projectteam.model.ProjectModel;

public class ProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding binding;
    ProfileActivityViewModel viewModel;
    String getPname,getName,getEid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        viewModel= new ViewModelProvider(this).get(ProfileActivityViewModel.class);
        Bundle b=getIntent().getExtras();
        getPname=b.getString("pname");
        binding.pname.setText(getPname);
        getEid=b.getString("eid");
        getName=b.getString("username");
        ProjectModel projectModel=new ProjectModel(0,getPname,"","","","");

        viewModel.getResponseLiveData(projectModel).observe(this, new Observer<ProjectModel>() {
            @Override
            public void onChanged(ProjectModel projectModel) {
                binding.projid.setText(projectModel.getPid());
                binding.sdate.setText(projectModel.getSdate().substring(0,10));
                binding.edate.setText(projectModel.getEdate().substring(0,10));
                binding.pdes.setText(projectModel.getPdes());
                binding.tname.setText(projectModel.getTname());
            }
        });

        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buildDailog();
            }
        });

        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pDesEdit=binding.pdes.getText().toString();
                String sDateEdit=binding.sdate.getText().toString();
                String eDateEdit=binding.edate.getText().toString();
                String pNameEdit=binding.pname.getText().toString();
                String tNameEdit=binding.tname.getText().toString();
                Intent intent=new Intent(ProfileActivity.this,AddProjectActivity.class);
                intent.putExtra("username",getName);
                intent.putExtra("eid",getEid);
                intent.putExtra("Edit", new String[]{pNameEdit, sDateEdit, eDateEdit, pDesEdit, tNameEdit});
                startActivity(intent);
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProfileActivity.this,MainActivity.class);
                intent.putExtra("username",getName);
                intent.putExtra("eid",getEid);
                startActivity(intent);
            }
        });

    }

    private void buildDailog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
        builder.setMessage("Do you want to delete?");
        builder.setTitle("Alert !");
        builder.setIcon(R.drawable.icon_delete);
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
            viewModel.deleteProject(getPname);
            Intent intent=new Intent(ProfileActivity.this,MainActivity.class);
            intent.putExtra("username",getName);
            intent.putExtra("eid",getEid);
            startActivity(intent);
        });
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            // If user click no then dialog box is canceled.
            dialog.cancel();
        });
        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        // Show the Alert Dialog box
        alertDialog.show();
    }
}
