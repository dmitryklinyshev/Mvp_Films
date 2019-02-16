package com.example.mvp_films.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mvp_films.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


public class MapsMarkerActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    private List<LatLng> places = new ArrayList<>();
    private String mapsApiKey;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        places.add(new LatLng(54.30525693, 48.3516562));
        places.add(new LatLng(54.30663409, 48.35994959));
        places.add(new LatLng(54.31755583, 48.40005666));
        places.add(new LatLng(54.27850587, 48.28722417));

        mapsApiKey = this.getResources().getString(R.string.google_maps_key);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        //    public void mark(){
        MarkerOptions[] markers = new MarkerOptions[places.size()];
        for (int i = 0; i < places.size(); i++) {
            markers[i] = new MarkerOptions()
                    .position(places.get(i));
            googleMap.addMarker(markers[i]);



            }
        }


    }

