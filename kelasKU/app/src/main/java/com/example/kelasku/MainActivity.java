package com.example.kelasku;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.text.TextUtils;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText eml;
    EditText pw;
    EditText nm;
    RadioGroup rb;
    RadioButton rb1;
    RadioButton rb2;
    EditText ttl;
    EditText alm;

    DatePickerDialog datePickerDialog;
    SimpleDateFormat simpleDateFormat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi inputan
        eml = findViewById(R.id.eml);
        pw = findViewById(R.id.pw);
        nm = findViewById(R.id.nm);
        ttl = findViewById(R.id.ttl);
        alm = findViewById(R.id.alm);
        ttl = findViewById(R.id.ttl);
        // tambahkan inisialisasi ini

        // Inisialisasi radio button dan date picker
        rb = findViewById(R.id.rb);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        ttl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDate();
            }

            private void showDate() {
                Calendar calendar = Calendar.getInstance();

                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, month, dayOfMonth);

                        ttl.setText(simpleDateFormat.format(newDate.getTime()));
                    }
                },calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
    }


    public void Simpandata(View view) {
        int idradio = rb.getCheckedRadioButtonId();
        rb2 = findViewById(idradio);

        if (!eml.getText().toString().equals("") &&
                !pw.getText().toString().equals("") &&
                !nm.getText().toString().equals("") &&
                !rb2.getText().toString().equals("") &&
                !ttl.getText().toString().equals("") &&
                !alm.getText().toString().equals("")

        ) {

            Intent i1 = new Intent(this, data.class);
            i1.putExtra("email", eml.getText().toString());
            i1.putExtra("pw", pw.getText().toString());
            i1.putExtra("nama", nm.getText().toString());
            i1.putExtra("jenisKelamin", rb2.getText().toString());
            i1.putExtra("ttl", ttl.getText().toString());
            i1.putExtra("alamat", alm.getText().toString());
            startActivity(i1);


        } else {
            Toast.makeText(MainActivity.this, "Data yang anda isi tidak lengkap", Toast.LENGTH_LONG).show();
        }

    }



}