package com.example.pmisinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    Button b;
    RadioGroup rg;
    boolean clicked;
    public static int PMIS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.login_button);
        rg=findViewById(R.id.radiogroup);
        clicked=false;
        b.setEnabled(false);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PMIS_ID.class);
                startActivity(intent);
            }
        });
    }
    public void onRadioClick(View v){
        switch (v.getId()){
            case R.id.official:
                clicked=true;
                break;
            case R.id.ro:
                clicked=true;
                break;
            case R.id.pmu:
                clicked=true;
                break;
        }
        if(clicked)
            b.setEnabled(true);
    }

}