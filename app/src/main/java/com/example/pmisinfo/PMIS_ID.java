package com.example.pmisinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class PMIS_ID extends AppCompatActivity {
    Button b;
    EditText e;
    public static Integer pmisid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pmis_id);
        b=findViewById(R.id.b);
        e=findViewById(R.id.edit);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference noteRef=db.collection("PMIS");
        pmisid=Integer.parseInt(e.getText().toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("pmis id","e.getText().toString()");
                Query query = noteRef.whereEqualTo("PMIS ID",Integer.parseInt(e.getText().toString()));
                query.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (queryDocumentSnapshots.isEmpty()) {
                            Toast.makeText(PMIS_ID.this, "Entered PMIS ID does not exist", Toast.LENGTH_SHORT).show();
                        } else {
                            for (QueryDocumentSnapshot doc : queryDocumentSnapshots) {
                                Intent intent = new Intent(PMIS_ID.this, Project_Detail.class);
                                startActivity(intent);
                            }
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("mainActivity ", "inquery");
                        Log.e("tage", e.toString());
                    }
                });
            }
        });
    }
}