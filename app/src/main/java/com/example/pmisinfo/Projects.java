package com.example.pmisinfo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Projects extends AppCompatActivity {
    RecyclerView r;
    Query query;
    MAdapter adapt;
    progress p;
    List<progress> l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference noteRef=db.collection("PMIS");
        l=new ArrayList<>();
        r=findViewById(R.id.projects);
        adapt=new MAdapter(this, (ArrayList<progress>) l);
        query = noteRef.whereEqualTo("Project Monitoring Unit", PMIS_ID.pmu_selected).orderBy("Project Name");
        query.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.e("Firestore Error", error.getMessage());
                    return;
                }
                for (DocumentChange dc : value.getDocumentChanges()) {
                    if (dc.getType() == DocumentChange.Type.ADDED) {
                        p=new progress(dc.getDocument().get("Project Name").toString(),dc.getDocument().get("Unique Project Code").toString(), Integer.parseInt(dc.getDocument().get("PMIS ID").toString()),dc.getDocument().get("Regional Office").toString(),dc.getDocument().get("Project Monitoring Unit").toString());
                        l.add(p);
                    }
                    adapt.notifyDataSetChanged();
                }
            }
        });
        r.setHasFixedSize(true);
        r.setLayoutManager(new LinearLayoutManager(this));
        r.setAdapter(adapt);
    }
}
