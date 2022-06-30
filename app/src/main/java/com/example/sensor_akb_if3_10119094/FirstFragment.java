package com.example.sensor_akb_if3_10119094;
// Saeful Anwar Oktariansah 10119094
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

    public class FirstFragment extends Fragment {

    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_first, container, false);
        // Inflate the layout for this fragment
        client = LocationServices.getFusedLocationProviderClient(getActivity());
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        getCurrentLocation();

        return fragment;
    }
    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(mapFragment.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mapFragment.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {
                            LatLng TM1 = new LatLng(-6.886477227814804, 107.6150332736941);
                            LatLng TM2 = new LatLng(-6.891750874295389, 107.61737383571906);
                            LatLng TM3 = new LatLng(-6.884901153005958, 107.61351150385627);
                            LatLng TM4 = new LatLng(-6.88701234695359, 107.61720050251529);
                            LatLng TM5 = new LatLng(-6.8895774863951385, 107.61582647792899);
                            LatLng lokasi = new LatLng(location.getLatitude(),location.getLongitude());
                            MarkerOptions options = new MarkerOptions().position(lokasi).title("Lokasi Saat Ini");
                            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi,17));
                            googleMap.addMarker(options);
                            googleMap.addMarker(new MarkerOptions().position(TM1).title("Warung Nasi SPG"));
                            googleMap.addMarker(new MarkerOptions().position(TM2).title("Bebek Ali Borme"));
                            googleMap.addMarker(new MarkerOptions().position(TM3).title("McDonald's Simpang Dago Bandung"));
                            googleMap.addMarker(new MarkerOptions().position(TM4).title("Mie Ayam Bakso WONGE DEWE"));
                            googleMap.addMarker(new MarkerOptions().position(TM5).title("Bakmi Jowo DU 67"));
                        }
                    });
                }
            }
        });
    }
}