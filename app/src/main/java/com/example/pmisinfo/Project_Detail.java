package com.example.pmisinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Project_Detail extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference noteRef=db.collection("contacts");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

    }
}