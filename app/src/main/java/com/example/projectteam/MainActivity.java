package com.example.projectteam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.projectteam.ViewModel.MainViewModel;
import com.example.projectteam.adapter.FilterAdapter;
import com.example.projectteam.adapter.OnClickInterface;
import com.example.projectteam.adapter.OnClickInterface2;
import com.example.projectteam.adapter.OnClickInterface3;
import com.example.projectteam.adapter.ProjectAdapter;
import com.example.projectteam.databinding.ActivityMainBinding;
import com.example.projectteam.model.FilterModel;
import com.example.projectteam.model.GetAllBooksApiRequest;
import com.example.projectteam.model.ProjectModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    FilterAdapter filterAdapter;
    ProjectAdapter projectAdapter;
    OnClickInterface onClickInterface;
    OnClickInterface2 onClickInterface2;
    OnClickInterface3 onClickInterface3;
    private String tname;
    GetAllBooksApiRequest apiRequest;
    MainViewModel mainViewModel;
    RadioButton actRadioBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);


        Bundle b=getIntent().getExtras();
        if(b!=null){
            binding.tvEid.setText(b.getString("eid"));
            binding.tvName.setText(b.getString("username"));
        }


        actRadioBtn=binding.rbAll;

        onClickInterface2=new OnClickInterface2() {
            @Override
            public void setClick(int abc) {

                String pNameEdit=((TextView)binding.rvMain.findViewHolderForAdapterPosition(abc).itemView.findViewById(R.id.pname)).getText().toString();

                Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                intent.putExtra("pname", pNameEdit);
                intent.putExtra("username",binding.tvName.getText().toString());
                intent.putExtra("eid",binding.tvEid.getText().toString());
                startActivity(intent);
            }
        };

        projectAdapter=new ProjectAdapter(onClickInterface2);
        binding.rvMain.setAdapter(projectAdapter);
        binding.rvMain.setLayoutManager(new LinearLayoutManager(this));
        apiRequest=new GetAllBooksApiRequest("");
        mainViewModel.getResponseLiveData(apiRequest).observe(this, new Observer<ArrayList<ProjectModel>>() {
            @Override
            public void onChanged(ArrayList<ProjectModel> projectModels) {
                if(projectModels!=null){
                    projectAdapter.setProjects(projectModels);
                }
            }
        });

        binding.rbAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateRadioGroup(view);
                tname="";
                updateRecyclerView();
            }
        });
        binding.rbAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateRadioGroup(view);
                tname="ANDROID";
                updateRecyclerView();
            }
        });
        binding.rbCloud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateRadioGroup(view);
                tname="CLOUD";
                updateRecyclerView();
            }
        });
        binding.rbWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateRadioGroup(view);
                tname="WEB";
                updateRecyclerView();
            }
        });

        binding.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddProjectActivity.class);
                intent.putExtra("username",binding.tvName.getText().toString());
                intent.putExtra("eid",binding.tvEid.getText().toString());
                startActivity(intent);
            }
        });

        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateRecyclerView() {
        apiRequest=new GetAllBooksApiRequest(tname);
        mainViewModel.getResponseLiveData(apiRequest);
        projectAdapter.notifyDataSetChanged();
    }

    private void updateRadioGroup(View view){
        final RadioButton rb = (RadioButton) view;
        if ( actRadioBtn != null ) {
            actRadioBtn.setChecked(false);
        }
        rb.setChecked(true);
        actRadioBtn = rb;
    }

}