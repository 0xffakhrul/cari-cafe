package com.example.cafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserCafe extends AppCompatActivity {

    ImageView back_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cafe);

        back_icon = findViewById(R.id.back_icon);
        back_icon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserCafe.this,UserMain.class));
            }
        });

        Intent intent = getIntent();
        int cafeImage = intent.getIntExtra("cafe_image", 0);
        String cafeName = intent.getStringExtra("cafe_name");
        String cafeLocation = intent.getStringExtra("cafe_location");
        String cafePhone = intent.getStringExtra("cafe_phone");
        String cafeState = intent.getStringExtra("cafe_state");

        // Set the values to your views
        ImageView cafeImageView = findViewById(R.id.cafeImg);
        cafeImageView.setImageResource(cafeImage);

        TextView cafeNameTextView = findViewById(R.id.ListreadName);
        cafeNameTextView.setText(cafeName);

        TextView cafeLocationTextView = findViewById(R.id.ListreadLocation);
        cafeLocationTextView.setText(cafeLocation);

        TextView cafePhoneTextView = findViewById(R.id.ListreadPhoneNo);
        cafePhoneTextView.setText(cafePhone);

        TextView cafeStateTextView = findViewById(R.id.ListreadState);
        cafeStateTextView.setText(cafeState);
    }
}