package com.example.aad_chapter6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aad_chapter6.fragments.FirstFragment;
import com.example.aad_chapter6.fragments.SecondFragment;
import com.example.aad_chapter6.fragments.SumFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnFragment;

    //if status is true then load first fragment
    private Boolean ststus = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragment = findViewById(R.id.btnFragment);
        btnFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(ststus)
        {
            SumFragment firstFragment = new SumFragment();
            fragmentTransaction.replace(R.id.fragmentContainer,firstFragment);
            fragmentTransaction.commit();
            btnFragment.setText("Load second fragment");
            ststus = false;
        }
        else{

            SecondFragment secondFragment = new SecondFragment();
            fragmentTransaction.replace(R.id.fragmentContainer,secondFragment);
            fragmentTransaction.commit();
            btnFragment.setText("Load first Fragment");
            ststus = true;
        }
    }
}
