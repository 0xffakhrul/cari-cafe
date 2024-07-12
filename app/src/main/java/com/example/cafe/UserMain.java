package com.example.cafe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class UserMain extends AppCompatActivity {

    RecyclerView drv;
    List<DynamicRvModel> items = new ArrayList<>();
    List<DynamicRvModel> originalItems = new ArrayList<>();
    DynamicRvAdapter dynamicRvAdapter;
    ImageView map_icon, clearSearchIcon, logout_icon;
    EditText searchEditText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        logout_icon = findViewById(R.id.logout_icon);
        logout_icon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(UserMain.this,
                                "Logout Successful",
                                Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        map_icon = findViewById(R.id.map_icon);
        map_icon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMain.this, UserMap.class));
            }
        });

        drv = findViewById(R.id.rv_2);
        drv.setLayoutManager(new LinearLayoutManager(this));

        items.add(new DynamicRvModel(R.drawable.manshor, "Manshor Coffee","105-G, Persiaran Lavender Heights 1, Taman Lavender Heights, 70450 Seremban, Negeri Sembilan", "+60128063866", "Seremban, Negeri Sembilan"));
        items.add(new DynamicRvModel(R.drawable.espress, "EspressOoi Cafe","27, Jln Meru Bestari A3, Medan Meru Bestari, 30020 Ipoh, Perak", "+60123456789", "Ipoh, Perak"));
        items.add(new DynamicRvModel(R.drawable.blitz, "Blitz and Co","6, Jalan Kia Peng, Kuala Lumpur, 50450 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur", "+60168426778", "Kuala Lumpur"));
        items.add(new DynamicRvModel(R.drawable.bancoh, "Ban~Coh","No 29, Pusat Komersial Melang, 72000 Kuala Pilah, Negeri Sembilan", "+60193169689", "Kuala Pilah, Negeri Sembilan"));
        items.add(new DynamicRvModel(R.drawable.absorb, "Absorb Sunlight","51, Jln Hujan, Taman Overseas Union, 58200 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur", "+60179799376", "Kuala Lumpur"));
        items.add(new DynamicRvModel(R.drawable.waronk, "Waronk Malam","5306, Jalan Umno, Kampung Bukit Kapar, 40150 Kapar, Selangor", "+60123456789", "Kapar, Selangor"));
        items.add(new DynamicRvModel(R.drawable.daddys, "Daddy’s Kitchen","1, Jalan Kampung Baru Sungai Serai - Kampung, Chuping, 02500 Kangar, Perlis", "+60174200053", "Kangar, Perlis"));
        items.add(new DynamicRvModel(R.drawable.kem, "Kem Hitem","senawang, 70450 Seremban, Negeri Sembilan", "+60103113453", "Seremban, Negeri Sembilan"));
        items.add(new DynamicRvModel(R.drawable.kemasik, "Rumah Kopi Kemasek","2208 Kg Tanah Lot Kemasik, 24200 Kemaman, Terengganu", "+60104545032", "Kemaman, Terengganu"));
        items.add(new DynamicRvModel(R.drawable.warung, "The Warung","145, Victoria St, Georgetown, 10300 George Town, Penang", "+6042260123", "George Town, Pulau Pinang"));
        items.add(new DynamicRvModel(R.drawable.medium, "Medium Coffee","Gaya Bangsar, Jalan Bangsar Utama 1, Bangsar, 59000 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur", "+60123456789", "Kuala Lumpur"));
        items.add(new DynamicRvModel(R.drawable.waw, "Waw Coffee","174, Jln Gong Pasir, Kampung Pak Sabah, 23000 Kuala Dungun, Terengganu", "+60123456789", "Kuala Dungun, Terengganu"));
        items.add(new DynamicRvModel(R.drawable.bambam, "Bambamkopi","8, Jalan Taman Melati, Taman Melati, 53100 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur", "+60137791047", "Kuala Lumpur"));
        items.add(new DynamicRvModel(R.drawable.pinggir, "Pinggir Kota KL","Medan Kajang, 43000 Kajang, Selangor", "+60123456789", "Kajang, Selangor"));
        items.add(new DynamicRvModel(R.drawable.layani, "Layani Cafe","Jalan Besar Pekan Batu Kurau Batu Kurau, 34500 Taiping, Perak", "+60199571965", "Taiping, Perak"));
        items.add(new DynamicRvModel(R.drawable.black, "Black Ink","A-0-1C, Ground Floor, Wisma HB Megan Avenue II, 50450 Kuala Lumpur", "+60123770463", "Kuala Lumpur"));
        items.add(new DynamicRvModel(R.drawable.tare, "Taré Cafe","3, Persiaran Greentown 6, Greentown business centre, 30450 Ipoh, Perak", "+60138226983", "Ipoh, Perak"));
        items.add(new DynamicRvModel(R.drawable.bound, "Bound coffee","21-G, Jalan Bandar Sepuluh, Pusat Bandar Puchong, 47160 Puchong, Selangor", "+60197718099", "Puchong, Selangor"));

        originalItems.addAll(items);

        dynamicRvAdapter = new DynamicRvAdapter(drv, this, items);
        drv.setAdapter(dynamicRvAdapter);

        dynamicRvAdapter.setOnItemClickListener(new DynamicRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DynamicRvModel item) {
                Intent intent = new Intent(UserMain.this, UserCafe.class);
                intent.putExtra("cafe_image", item.getCafeImage());
                intent.putExtra("cafe_name", item.getCafeName());
                intent.putExtra("cafe_location", item.getCafeLocation());
                intent.putExtra("cafe_phone", item.getCafePhone());
                intent.putExtra("cafe_state", item.getCafeState());
                startActivity(intent);
            }
        });

        clearSearchIcon = findViewById(R.id.clear_search_icon);
        searchEditText = findViewById(R.id.search);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    clearSearchIcon.setVisibility(View.GONE);
                    resetList();
                } else {
                    clearSearchIcon.setVisibility(View.VISIBLE);
                }
            }
        });

        clearSearchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchEditText.setText("");
            }
        });
    }

    private void filter(String text) {
        List<DynamicRvModel> filteredList = new ArrayList<>();

        for (DynamicRvModel item : items) {
            if (item.getCafeName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        dynamicRvAdapter.updateList(filteredList);
    }

    private void resetList() {
        dynamicRvAdapter.updateList(originalItems);
    }
}
