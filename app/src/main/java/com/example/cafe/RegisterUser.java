package com.example.cafe;


import android.content.Intent;import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;import android.widget.Button;
import android.widget.EditText;import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
public class RegisterUser extends AppCompatActivity {
    Button btnRegister;
    TextView textBackLogin;
    EditText e2, e3;
    FirebaseAuth fAuth;

    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        fAuth = FirebaseAuth.getInstance();
        e2 = findViewById(R.id.TextregisterEmail);
        e3 = findViewById(R.id.TextregisterPassword);
        btnRegister = findViewById(R.id.btnRegister);
        textBackLogin = findViewById(R.id.textBackLogin);
        textBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginUser.class));
                finish();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email, Password;

                Email = String.valueOf(e2.getText());
                Password = String.valueOf(e3.getText());


                if (TextUtils.isEmpty(Email)){
                    Toast.makeText(RegisterUser.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Password)){
                    Toast.makeText(RegisterUser.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                fAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(
                                    RegisterUser.this,
                                    "Account Created",
                                    Toast.LENGTH_SHORT)
                                    .show();
                            Intent intent = new Intent(getApplicationContext(), LoginUser.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(
                                    RegisterUser.this,
                                    "Failed to create account",
                                    Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });

            }
        });
    }
}