package com.example.wonderv2.AR;

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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.wonderv2.MainActivity;
import com.example.wonderv2.R;
import com.example.wonderv2.Setting.Setting_alarm;
import com.example.wonderv2.Setting.Setting_main;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AR_main#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AR_main extends Fragment{
    MainActivity activity;

    private RecyclerView ar_recyclerveiw;
    private RecyclerView.Adapter arAdapter;
    private RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
    private ArrayList<AR_card_model> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AR_main() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AR_main.
     */
    // TODO: Rename and change types and number of parameters
    public static AR_main newInstance(String param1, String param2) {
        AR_main fragment = new AR_main();
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
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.ar_main, container, false);

        Button arBtn = (Button) v.findViewById(R.id.ar_btn);

        arBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity(),
                        AR_camera.class
                );

                startActivity(intent);
            }


        });

        ImageButton alarm_btn=v.findViewById(R.id.alarm_btn);
        alarm_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Setting_alarm.class
                );

                startActivity(intent);
            }
        });
        ImageButton setting_btn=v.findViewById(R.id.setting_btn);
        setting_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(
                        getActivity(),
                        Setting_main.class
                );

                startActivity(intent);
            }
        });


        //리사이클러뷰
        //ar_recyclerveiw.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //ar_recyclerveiw.setAdapter(new AR_card_adapter(ar_recyclerveiw.getContext(), ));


        ar_recyclerveiw = v.findViewById(R.id.ar_recyclerveiw);
        ar_recyclerveiw.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        ar_recyclerveiw.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();



        database = FirebaseDatabase.getInstance();

        databaseReference = database.getReference("ARCard");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    AR_card_model ar_card_model = snapshot1.getValue(AR_card_model.class);
                    arrayList.add(ar_card_model);
                }
                arAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        arAdapter = new AR_card_adapter(arrayList, getActivity());
        ar_recyclerveiw.setAdapter(arAdapter);





        return v;
    }
}