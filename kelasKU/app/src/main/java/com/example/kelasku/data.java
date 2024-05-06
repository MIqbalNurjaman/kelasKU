package com.example.kelasku;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class data extends AppCompatActivity {
    TextView txt1, txt2, txt3, txt4, txt5, txt6;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setContentView(R.layout.activity_data);

        txt1 = findViewById(R.id.heml);
        txt2 = findViewById(R.id.hpw);
        txt3 = findViewById(R.id.hnm);
        txt4 = findViewById(R.id.hjkl);
        txt5 = findViewById(R.id.httl);
        txt6 = findViewById(R.id.halm);

        String email = getIntent().getExtras().getString("email");
        String pw = getIntent().getExtras().getString("pw");
        String nama = getIntent().getExtras().getString("nama");
        String jenisKelamin = getIntent().getExtras().getString("jenisKelamin");
        String ttl = getIntent().getExtras().getString("ttl");
        String alamat = getIntent().getExtras().getString("alamat");
        String telepon = getIntent().getExtras().getString("telepon");

        txt1.setText("Email         : " + email);
        txt2.setText("pw            : " + pw);
        txt3.setText("Nama          : " + nama);
        txt4.setText("Jenis Kelamin : " + jenisKelamin);
        txt5.setText("Tanggal Lahir : " + ttl);
        txt6.setText("Alamat        : " + alamat);


    }
}