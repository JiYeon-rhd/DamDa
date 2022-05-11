package com.example.wonderv2.Exp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.wonderv2.AR.AR_card_model;
import com.example.wonderv2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<productList>();

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("exp_wash");

        ArrayList<String> list = new ArrayList<>();

        Button camera_btn = (Button)view.findViewById(R.id.exp_camera_btn);

        camera_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity(),
                        Exp_camera_wash.class
                );

                startActivity(intent);
            }
        });


        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    productList productList = snapshot.getValue(productList.class);
                    Exp_productdetail exp_productdetail = snapshot.getValue(Exp_productdetail.class);


                    String dday = exp_productdetail.getDDay().toString();
                    String expday = exp_productdetail.getExpDay().toString();
                    String shopname = exp_productdetail.getShopName().toString();
                    String productname = exp_productdetail.getProductName().toString();



                    productList.setDDay(dday.toString());
                    productList.setExpDay(expday.toString());
                    productList.setShopName(shopname.toString());
                    productList.setProductName(productname.toString());

                    arrayList.add(productList);

               }
          //      productList productList = dataSnapshot.getValue(com.example.wonderv2.Exp.productList.class);
          //      arrayList.add(productList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Exp_wash",String.valueOf(databaseError.toException()));
            }
        });


       adapter = new CustomAdapter(arrayList,getActivity());
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }


}