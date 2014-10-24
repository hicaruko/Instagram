package com.jakapong.instagram;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;



public class HomeFragment extends Fragment {

    private SupportMapFragment fragment;
    private static GoogleMap map;
    private Location mCurrentLocation;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fm = getChildFragmentManager();

        fragment = (SupportMapFragment) fm.findFragmentById(R.id.map);
        if (fragment == null) {
            fragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.map, fragment).commit();


        }

    }

    @Override
    public void onResume() {
        super.onResume();
        setUpMap();
    }
    private static final LatLng MELBOURNE = new LatLng(-37.813, 144.962);


    private void setUpMap() {
        //mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));

        if (map == null) {
            map = fragment.getMap();
            map.getUiSettings().setMyLocationButtonEnabled(true);
            map.setMyLocationEnabled(true);
            map.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
                @Override
                public void onMapLoaded() {
                    Log.e("my location ","++ ="+map.getMyLocation());
                    Location location = map.getMyLocation();
                    LatLng target = new LatLng(location.getLatitude(), location.getLongitude());
                    CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(target, 10);
                    map.moveCamera(CameraUpdateFactory.newLatLng(target));
                    map.animateCamera(cameraUpdate);
                }
            });


//            Location location = map.getMyLocation();
//
//            if (location != null) {
//
//                LatLng target = new LatLng(location.getLatitude(), location.getLongitude());
//
//                map.moveCamera(CameraUpdateFactory.newLatLng(target));
//            }


            map.addMarker(new MarkerOptions()
                    .position(MELBOURNE)
                    .title("Melbourne")
                    .snippet("Population: 4,137,400")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.wp)));

        }


    }

}