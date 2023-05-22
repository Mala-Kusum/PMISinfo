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
    Button b;
    EditText e;
    Spinner ro,pmu;
    public static int pmisid;
    ArrayAdapter<CharSequence> ad2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pmis_id);
        b=findViewById(R.id.b);
        e=findViewById(R.id.edit);
        ro=findViewById(R.id.RO);
        pmu=findViewById(R.id.PMU);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference noteRef=db.collection("PMIS");
        ArrayAdapter<CharSequence> ad=ArrayAdapter.createFromResource(this,R.array.RO, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        ad.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        ro.setAdapter(ad);
        ro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(adapterView.getSelectedItem().toString()){
                    case"RO-SRINAGAR":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.SRINAGAR, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case"RO-Shillong":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Shillong, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case"RO-LADAKH":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.LADAKH, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case"RO-Kohima":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Kohima, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case"RO-Jammu":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Jammu, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case"RO-Itanagar":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.SRINAGAR, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case"RO-Imphal":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Imphal, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case"RO-Guwahati":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Guwahati, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case"RO-Gangtok":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Gangtok, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case"RO-Dehradun":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Dehradun, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case"RO-Aizwal":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Aizwal, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case"RO-Agartala":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.Agartala, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case"RO-Port Blair":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.PortBlair, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case"Leh/Srinagar":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.LehSrinagar, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case"New Delhi":
                        ad2=ArrayAdapter.createFromResource(PMIS_ID.this,R.array.NewDelhi, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        break;
                }
                ad2.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                ro.setAdapter(ad2);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pmisid=Integer.parseInt(e.getText().toString());
                // Log.e("pmis id","e.getText().toString()");
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