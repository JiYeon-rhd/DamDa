package com.example.wonderv2.Home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.wonderv2.MainActivity;
import com.example.wonderv2.R;
import com.example.wonderv2.Setting.Setting_alarm;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.CameraUpdate;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home_loca_map#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_loca_map extends Fragment implements OnMapReadyCallback{
    MainActivity activity;
    private MapView mapView;
    private MarkerOptions markerOptions;
    GoogleMap googleMap;


    Button almaeng_btn;
    Button chaeum_btn;
    Button earth_btn;
    Button aromatica_btn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home_loca_map() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_loca_map.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_loca_map newInstance(String param1, String param2) {
        Home_loca_map fragment = new Home_loca_map();
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
    public void onAttach(Context context){
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }
    public void onDetach(){
        super.onDetach();
        activity = null;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.home_loca_map, container, false);

        almaeng_btn = v.findViewById(R.id.almaeng_btn);
        chaeum_btn = v.findViewById(R.id.chaeum_btn);
        earth_btn = v.findViewById(R.id.earth_btn);
        aromatica_btn = v.findViewById(R.id.aromatica_btn);



        almaeng_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        chaeum_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        earth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng seoul =new LatLng(37.56523392685565, 126.9239828356946);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoul,14));

                MarkerOptions marker = new MarkerOptions();
                googleMap.addMarker(marker).showInfoWindow();
                marker.title("지구샵");
                marker.snippet("서울특별시 마포구 월드컵로 25길 47 3층");
            }
        });
        aromatica_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        //홈으로 돌아가기 버튼
        ImageButton back_btn = v.findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                activity.setFrag(0);
            }
        });

        //위치(리스트)로 가는 버튼
        Button to_list_btn = v.findViewById(R.id.to_list_btn);
        to_list_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                activity.setFrag(5);
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

        //지도 구현
        mapView = (MapView)v.findViewById(R.id.map);
        mapView.getMapAsync((OnMapReadyCallback) this);
        mapView.onCreate(savedInstanceState);



        return v;
    }



    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }
    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    public void onMapReady(GoogleMap googleMap){
        final LatLng seoul =new LatLng(37.55785465716031, 126.90515485604969);

          MarkerOptions marker = new MarkerOptions();
          marker.position(seoul);
          marker.title("알맹상점");
          marker.snippet("서울특별시 마포구 월드컵로 25길 47 3층");

          googleMap.addMarker(marker).showInfoWindow();


          googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoul,14));


          //CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(37.55785465716031, 126.90515485604969),14);
          //googleMap.animateCamera(cameraUpdate);
          //googleMap.addMarker(new MarkerOptions().position(new LatLng(37.55785465716031, 126.90515485604969)).title("알맹상점"));

        final LatLng ch =new LatLng(37.49497303281656, 126.5652006444408);
        MarkerOptions marker1 = new MarkerOptions();
        marker1.position(ch);
        marker1.title("채움소");
        marker1.snippet("서울특별시 마포구 월드컵로 25길 47 3층");
        googleMap.addMarker(marker1).showInfoWindow();

        final LatLng ea =new LatLng(37.56523392685565, 126.9239828356946);
        MarkerOptions marker2 = new MarkerOptions();
        marker2.position(ea);
        marker2.title("지구샵");
        marker2.snippet("서울특별시 마포구 월드컵로 25길 47 3층");
        googleMap.addMarker(marker2).showInfoWindow();


        final LatLng aro =new LatLng(37.537867843461, 127.00703773003102);
        MarkerOptions marker3 = new MarkerOptions();
        marker3.position(aro);
        marker3.title("지구샵");
        marker3.snippet("서울특별시 마포구 월드컵로 25길 47 3층");
        googleMap.addMarker(marker3).showInfoWindow();



    }

    public void setMarker(double la, double lo){
        LatLng latLng  = new LatLng(la, lo);

        // 구글 맵에 표시할 마커에 대한 옵션 설정  (알파는 좌표의 투명도이다.)
        MarkerOptions makerOptions = new MarkerOptions();
        makerOptions
                .position(latLng)
                .title("원하는 위치(위도, 경도)에 마커를 표시했습니다.")
                .snippet("여기는 여의도인거같네여!!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .alpha(0.5f);

        // 마커를 생성한다. showInfoWindow를 쓰면 처음부터 마커에 상세정보가 뜨게한다. (안쓰면 마커눌러야뜸)
        googleMap.addMarker(makerOptions); //.showInfoWindow();

        //정보창 클릭 리스너
       // googleMap.setOnInfoWindowClickListener(infoWindowClickListener);

        //마커 클릭 리스너
        //googleMap.setOnMarkerClickListener(markerClickListener);

        //카메라를 여의도 위치로 옮긴다.
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(seoul));
        //처음 줌 레벨 설정 (해당좌표=>서울, 줌레벨(16)을 매개변수로 넣으면 된다.) (위에 코드대신 사용가능)(중첩되면 이걸 우선시하는듯)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));



    }


}