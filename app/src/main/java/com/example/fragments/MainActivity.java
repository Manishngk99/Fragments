package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragments.fragments.FirstFragment;
import com.example.fragments.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnLoadFragment;
    private Boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding

        btnLoadFragment = findViewById(R.id.btnLoadFragment);
        btnLoadFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (status){
            FirstFragment firstFragment = new FirstFragment();
            fragmentTransaction.replace(R.id.linearLayout,firstFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            btnLoadFragment.setText("Load Second fragment");
            status = false;
        } else {

            SecondFragment secondFragment = new SecondFragment();
            fragmentTransaction.replace(R.id.linearLayout,secondFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            btnLoadFragment.setText("Load First fragment");
            status = true;
        }

    }
}
