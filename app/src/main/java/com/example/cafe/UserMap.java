package com.example.cafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class UserMap extends AppCompatActivity implements OnMapReadyCallback {

    ImageView Mapback_icon;
    private GoogleMap gMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_map);

        Mapback_icon = findViewById(R.id.Mapback_icon);
        Mapback_icon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMap.this,UserMain.class));
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng location1 = new LatLng(3.1155374680009205, 101.8163508730184);
        googleMap.addMarker(new MarkerOptions().position(location1).title("Pavlova Cheesecake By Dapur Bulat Bulat"));

        LatLng location2 = new LatLng(4.67331123728199, 101.0773339134908);
        googleMap.addMarker(new MarkerOptions().position(location2).title("EspressOoi Cafe"));

        LatLng location3 = new LatLng(3.1527447924375194, 101.7128540048461);
        googleMap.addMarker(new MarkerOptions().position(location3).title("Blitz and Co"));

        LatLng location4 = new LatLng(2.7371563897958517, 102.23117784912424);
        googleMap.addMarker(new MarkerOptions().position(location4).title("Ban~Coh"));

        LatLng location5 = new LatLng(3.0722209116414847, 101.67177390678998);
        googleMap.addMarker(new MarkerOptions().position(location5).title("Absorb Sunlight"));

        LatLng location6 = new LatLng(3.1641531933713165, 101.42047654914386);
        googleMap.addMarker(new MarkerOptions().position(location6).title("Waronk Malam"));

        LatLng location7 = new LatLng(3.147378922062238, 101.61794110679543);
        googleMap.addMarker(new MarkerOptions().position(location7).title("Bean Here!"));

        LatLng location8 = new LatLng(6.54370492092325, 100.29372243562138);
        googleMap.addMarker(new MarkerOptions().position(location8).title("Daddy’s Kitchen"));

        LatLng location9 = new LatLng(2.7036985625328125, 101.99541370863936);
        googleMap.addMarker(new MarkerOptions().position(location9).title("Kem Hitem"));

        LatLng location10 = new LatLng(2.784431897660219, 101.4851059644463);
        googleMap.addMarker(new MarkerOptions().position(location10).title("Sulaiman's by Bake & Brew"));

        LatLng location11 = new LatLng(2.712431344291117, 102.00225686632605);
        googleMap.addMarker(new MarkerOptions().position(location11).title("Manshor Coffee"));

        LatLng location12 = new LatLng(4.420053302381107, 103.45206305098304);
        googleMap.addMarker(new MarkerOptions().position(location12).title("Rumah Kopi Kemasek"));

        LatLng location13 = new LatLng(5.412904960409555, 100.33756557982039);
        googleMap.addMarker(new MarkerOptions().position(location13).title("The Warung"));

        LatLng location14 = new LatLng(3.1273714907718846, 101.67693054727309);
        googleMap.addMarker(new MarkerOptions().position(location14).title("Medium Coffee"));

        LatLng location15 = new LatLng(4.751858417347719, 103.40698280863046);
        googleMap.addMarker(new MarkerOptions().position(location15).title("Waw Coffee"));

        LatLng location16 = new LatLng(3.225491599313965, 101.72258575095452);
        googleMap.addMarker(new MarkerOptions().position(location16).title("Bambamkopi"));

        LatLng location17 = new LatLng(2.994461998284538, 101.78552266631448);
        googleMap.addMarker(new MarkerOptions().position(location17).title("Pinggir Kota KL"));

        LatLng location18 = new LatLng(4.975121412535299, 100.7996322816592);
        googleMap.addMarker(new MarkerOptions().position(location18).title("Layani Cafe"));

        LatLng location19 = new LatLng(3.162099931298292, 101.7120076393381);
        googleMap.addMarker(new MarkerOptions().position(location19).title("Black Ink"));

        LatLng location20 = new LatLng(4.5999680441605335, 101.09501825097243);
        googleMap.addMarker(new MarkerOptions().position(location20).title("Taré Cafe"));

        LatLng location21 = new LatLng(3.0335967191441733, 101.61456587979991);
        googleMap.addMarker(new MarkerOptions().position(location21).title("Bound coffee"));

        // Move the camera to a default location (you can adjust this)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location1, 12));
    }
}