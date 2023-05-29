package com.mirea.kt.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mirea.kt.myapplication.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        StdApp.getServerApi().getStudentInfoAll("Student9431", "L6sG3D3", "RIBO-02-21").enqueue(new Callback<StudentInfoResponse>() {
            @Override
            public void onResponse(Call<StudentInfoResponse> call, Response<StudentInfoResponse> response) {
                StudentInfoResponse sir = response.body();
                sir.getData().size();
                String s1 = sir.getData().get(0).getValue();
                
            }

            @Override
            public void onFailure(Call<StudentInfoResponse> call, Throwable t) {
                Log.i("simple_app_tag", "error");
            }
        });
    }
}