package com.example.projectteam;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.projectteam.ViewModel.LoginViewModel;
import com.example.projectteam.databinding.ActivityLoginBinding;
import com.example.projectteam.model.LoginModel;
import com.example.projectteam.model.PostAddProjectApiResponse;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    LoginViewModel viewModel;
    private Boolean toggle=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        viewModel=new ViewModelProvider(this).get(LoginViewModel.class);

        binding.ivEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggle){
                    toggle=false;
                    binding.password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    binding.ivEye.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/icon_visible",null,getPackageName())));
                }else{
                    toggle=true;
                    binding.password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    binding.ivEye.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/icon_visible_off",null,getPackageName())));
                }
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewModel.validEid.getValue().length()==0 && viewModel.validPass.getValue().length()==0){
                    LoginModel loginModel=new LoginModel(binding.eid.getText().toString(),binding.password.getText().toString());
                    viewModel.login(loginModel).observe(LoginActivity.this, new Observer<LoginModel>() {
                        @Override
                        public void onChanged(LoginModel loginModel1) {
                            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                            intent.putExtra("username",loginModel1.getUser());
                            intent.putExtra("eid",loginModel1.getEid());
                            Toast.makeText(LoginActivity.this, "Welcome "+loginModel1.getUser(), Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                    });
                }
            }
        });

        binding.password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0)viewModel.validPass.postValue("Please provide password");
                else if(charSequence.toString().length()!=4)viewModel.validPass.postValue("Password length must be 4");
                else viewModel.validPass.postValue("");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.eid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==0)viewModel.validEid.postValue("Please provide employee id");
                else if(!charSequence.toString().contains("YM"))viewModel.validEid.postValue("Wrong Employee Id entered");
                else viewModel.validEid.postValue("");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        viewModel.validPass.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.passwordValidations.setText(s);
            }
        });

        viewModel.validEid.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.eidValidations.setText(s);
            }
        });

    }
}
