package com.example.pmisinfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class MAdapter extends RecyclerView.Adapter<MAdapter.MyViewHolder> {
    Context context;
    ArrayList<progress> list;
    String DocID;
    DocumentSnapshot doc;
    String Type;
    String email;
    DocumentReference docRef;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference noteRef=db.collection("contacts");
    public MAdapter(Context context, ArrayList<progress> list) {
        this.context = context;
        this.list = list;
    }
    public void filterList(ArrayList<progress> filterlist) {
        list = filterlist;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MAdapter.MyViewHolder holder, int position) {
        progress user = list.get(position);
        holder.name.setText(user.getProjectName());
        holder.UPC.setText(user.getUPC());
        holder.date.setText(user.getDate());
        holder.Ro.setText(user.getRO());
        holder.PMU.setText(user.getPMU());
        holder.km.setText(""+user.getKm());
        holder.PMIS.setText(""+user.getPmis_id());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.PMIS = Integer.parseInt(holder.PMIS.getText().toString());
                Intent intent=new Intent(context,Project_Detail.class);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,UPC,km,date,Ro,PMU,PMIS;
        LinearLayout card;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            PMIS=itemView.findViewById(R.id.pmisid);
            name=itemView.findViewById(R.id.ProjectName);
            km=itemView.findViewById(R.id.km);
            date=itemView.findViewById(R.id.date);
            Ro=itemView.findViewById(R.id.RO);
            PMU=itemView.findViewById(R.id.PMU);
            UPC=itemView.findViewById(R.id.UPC);
        }
    }
}
