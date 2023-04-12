package com.example.restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    Button daftarButton;
    EditText nameEditText, usernameEditText, addressEditText, passwordEditText, confirmPasswordEditText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        daftarButton = findViewById(R.id.daftar_button);
        nameEditText = findViewById(R.id.edit_text_1);
        usernameEditText = findViewById(R.id.edit_text_2);
        addressEditText = findViewById(R.id.edit_text_3);
        passwordEditText = findViewById(R.id.edit_text_4);
        confirmPasswordEditText = findViewById(R.id.edit_text_5);

        daftarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (passwordEditText.getText().toString().equals(confirmPasswordEditText.getText().toString())) {

                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("user");

                    Map<String, Object> data = new HashMap<>();
                    data.put("name", nameEditText.getText().toString());
                    data.put("username", usernameEditText.getText().toString());
                    data.put("alamat", addressEditText.getText().toString());
                    data.put("password", passwordEditText.getText().toString());

                    myRef.setValue(data);

                    Intent intent = new Intent(new Intent(getApplicationContext(), TransaksiActivity.class));
                    intent.putExtra("username", usernameEditText.getText().toString());
                    intent.putExtra("alamat", addressEditText.getText().toString());
                    startActivity(intent);
                    finish(); // agar tidak bisa kembali ke tampilan sebelumnya

                } else {
                    Toast.makeText(RegisterActivity.this, "Password tidak sama", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}