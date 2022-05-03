package com.example.wonderv2.Exp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.wonderv2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Exp_wash#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Exp_wash extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<productList> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private View view;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Exp_wash() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Exp_wash.
     */
    // TODO: Rename and change types and number of parameters
    public static Exp_wash newInstance(String param1, String param2) {
        Exp_wash fragment = new Exp_wash();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.exp_wash, container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("exp_product");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    productList productList = snapshot.getValue(com.example.wonderv2.Exp.productList.class);
                    arrayList.add(productList);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Exp_wash",String.valueOf(databaseError.toException()));
            }
        });
        adapter = new CustomAdapter(arrayList,getContext());
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }
}