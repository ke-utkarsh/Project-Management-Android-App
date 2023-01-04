package com.example.projectteam.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectteam.R;
import com.example.projectteam.model.ProjectModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectHolder>{
    private List<ProjectModel> projects=new ArrayList<>();
    OnClickInterface2 onClickInterface2;


    public ProjectAdapter(OnClickInterface2 onClickInterface2){
        this.onClickInterface2=onClickInterface2;
    }
    @NonNull
    @Override
    public ProjectAdapter.ProjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_item, parent, false);

        return new ProjectHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectAdapter.ProjectHolder holder, @SuppressLint("RecyclerView") int position) {
        ProjectModel project=projects.get(position);
        //holder.pid.setText(project.getPid());
        holder.pname.setText(project.getPname());
        holder.tname.setText(project.getTname());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickInterface2.setClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public void setProjects(List<ProjectModel> projects){
        this.projects=projects;
        notifyDataSetChanged();
    }

    class ProjectHolder extends RecyclerView.ViewHolder{
        private TextView pname;
        private TextView tname;
        private TextView pid;
        private ConstraintLayout card;
        public ProjectHolder(@NonNull View itemView) {
            super(itemView);
            pname=itemView.findViewById(R.id.pname);
            tname=itemView.findViewById(R.id.tname);
            card=itemView.findViewById(R.id.card);
        }
    }
}
