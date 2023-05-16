package com.example.pmisinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Project_Detail extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference noteRef=db.collection("PMIS");
    TextView id,name,upc,siteOffice,pmu,type,status,ro,state,dateOfAward,AE,AEContact,TL,TLContact,Contractor,ContractorContact,PM,PMContact,PMEmail,tEOT,EOTFrom,EOTTo,tCOS,COSFrom,COSTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
        id=findViewById(R.id.PMISID);
        name=findViewById(R.id.name);
        upc=findViewById(R.id.UniqueProjectCode);
        siteOffice=findViewById(R.id.ProjectSiteOffice);
        pmu=findViewById(R.id.ProjectMonitoringUnit);
        type=findViewById(R.id.ProjectType);
        status=findViewById(R.id.ProjectStatus);
        ro=findViewById(R.id.RegionalOffice);
        state=findViewById(R.id.State);
        dateOfAward=findViewById(R.id.DateofAward);
        AE=findViewById(R.id.AuthorityEngineer);
        AEContact=findViewById(R.id.AuthorityEngineerContact);
        TL=findViewById(R.id.TeamLeader);
        TLContact=findViewById(R.id.TeamLeaderContact);
        Contractor=findViewById(R.id.Contractor);
        ContractorContact=findViewById(R.id.ContractorContact);
        PM=findViewById(R.id.ProjectManager);
        PMContact=findViewById(R.id.ProjectManagerContact);
        PMEmail=findViewById(R.id.ProjectManagerEmailAddress);
        tEOT=findViewById(R.id.TotalEOT);
        EOTFrom=findViewById(R.id.RequiredEOTDateFrom);
        EOTTo=findViewById(R.id.RequiredEOTDateTo);
        tCOS=findViewById(R.id.TotalCOS);
        COSFrom=findViewById(R.id.RequiredCOSDateFrom);
        COSTo=findViewById(R.id.RequiredCOSDateTo);
        //public static final String
        Query query = noteRef.whereEqualTo("PMIS ID",PMIS_ID.pmisid);
        query.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (queryDocumentSnapshots.isEmpty()) {
                    Toast.makeText(Project_Detail.this, "Entered PMIS ID does not exist", Toast.LENGTH_SHORT).show();
                } else {
                    for (QueryDocumentSnapshot doc : queryDocumentSnapshots) {
                        id.setText(doc.get("PMIS ID").toString());
                        name.setText(doc.get("Project Name").toString());
                        upc.setText(doc.get("Unique Project Code").toString());
                        siteOffice.setText(doc.get("Project Site Office").toString());
                        pmu.setText(doc.get("Project Monitoring Unit").toString());
                        type.setText(doc.get("Project Type").toString());
                        status.setText(doc.get("Project Status").toString());
                        ro.setText(doc.get("Regional Office").toString());
                        state.setText(doc.get("State").toString());
                        dateOfAward.setText(doc.get("Date of Award").toString());
                        AE.setText(doc.get("Authority's Engineer Contact").toString());
                        AEContact.setText(doc.get("Authority's Engineer").toString());
                        TL.setText(doc.get("Team Leader").toString());
                        TLContact.setText(doc.get("Team Leader Contact").toString());
                        Contractor.setText(doc.get("Contractor").toString());
                        ContractorContact.setText(doc.get("Contractor Contact").toString());
                        PM.setText(doc.get("Project Manager").toString());
                        PMContact.setText(doc.get("Project Manager Contact").toString());
                        PMEmail.setText(doc.get("Project Manager Email Address").toString());
                        tEOT.setText(doc.get("Total EOT").toString());
                        EOTFrom.setText(doc.get("Required EOT Date From").toString());
                        EOTTo.setText(doc.get("Required EOT Date To").toString());
                        tCOS.setText(doc.get("Total COS").toString());
                        COSFrom.setText(doc.get("Required COS Date From").toString());
                        COSTo.setText(doc.get("Required COS Date To").toString());
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
}