package com.example.pmisinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class PMIS_ID extends AppCompatActivity {
    Button b,b1;
    EditText e;
    public static  String pmu_selected;
    Spinner ro,pmu;

    ArrayAdapter<CharSequence> ad,ad2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pmis_id);
        b=findViewById(R.id.b);
        b1=findViewById(R.id.b1);
        e=findViewById(R.id.edit);
        ro=findViewById(R.id.RO);
        pmu=findViewById(R.id.PMU);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference noteRef=db.collection("PMIS");
        ad=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.RO, android.R.layout.simple_spinner_item);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ro.setAdapter(ad);
        ro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("TAG",adapterView.getSelectedItem().toString());
                switch(adapterView.getSelectedItem().toString()){
                    case"Ro-Leh/Srinagar":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.LehSrinagar, android.R.layout.simple_spinner_item);
                        break;
                    case"RO-Shillong":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Shillong, android.R.layout.simple_spinner_item);
                        break;
                    case"RO-LADAKH":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.LADAKH, android.R.layout.simple_spinner_item);
                        break;
                    case"RO-Kohima":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Kohima, android.R.layout.simple_spinner_item);
                        break;
                    case"RO-Jammu":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Jammu, android.R.layout.simple_spinner_item);
                        break;
                    case"RO-Itanagar":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Itanagar, android.R.layout.simple_spinner_item);
                        break;
                    case"RO-Imphal":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Imphal, android.R.layout.simple_spinner_item);
                        break;
                    case"RO-Guwahati":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Guwahati, android.R.layout.simple_spinner_item);
                        break;
                    case"RO-Gangtok":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Gangtok, android.R.layout.simple_spinner_item);
                        break;
                    case"RO-Dehradun":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Dehradun, android.R.layout.simple_spinner_item);
                        break;
                    case"RO-Aizwal":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Aizwal, android.R.layout.simple_spinner_item);
                        break;
                    case"RO-Agartala":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Agartala, android.R.layout.simple_spinner_item);
                        break;
                    case"RO-Port Blair":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.PortBlair, android.R.layout.simple_spinner_item);
                        break;
                    case"RO-SRINAGAR":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.SRINAGAR, android.R.layout.simple_spinner_item);
                        break;
                    case"New Delhi":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.NewDelhi, android.R.layout.simple_spinner_item);
                        break;
                }
                ad2.setDropDownViewResource(android.R.layout.simple_spinner_item);
                pmu.setAdapter(ad2);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pmu_selected=pmu.getSelectedItem().toString();
                Intent i=new Intent(PMIS_ID.this,Projects.class);
                startActivity(i);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.PMIS=Integer.parseInt(String.valueOf(e.getText()));
                // Log.e("pmis id","e.getText().toString()");
                Query query = noteRef.whereEqualTo("PMIS ID",MainActivity.PMIS);
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