package com.example.pmisinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PMIS_ID extends AppCompatActivity {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pmis_id);
        b=findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PMIS_ID.this,Project_Detail.class);
                startActivity(intent);
            }
        });
    }
}