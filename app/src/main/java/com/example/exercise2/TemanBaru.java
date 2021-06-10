package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.exercise2.database.DBController;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class TemanBaru extends AppCompatActivity {

    private TextInputEditText tNama, tTelpon;
    private Button simpanBtn;
    String nm, tlp;
    DBController controller = new DBController(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_baru);

        tNama = findViewById(R.id.tietNama);
        tTelpon = findViewById(R.id.tietTelpon);
        simpanBtn = findViewById(R.id.buttonSave);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((tNama.getText().toString()).equals("") || (tTelpon.getText().toString()).equals("")){
                    Toast.makeText(getApplicationContext(), "Data belum lengkap", Toast.LENGTH_SHORT).show();
                }
                else {
                    nm = tNama.getText().toString();
                    tlp = tTelpon.getText().toString();

                    HashMap<String, String> qvalues = new HashMap<>();

                    //kunci sama persis dengan nama table DB
                    qvalues.put("nama", nm);
                    qvalues.put("telpon", tlp);

                    controller.insertData(qvalues);
                    callHome();
                }
            }
        });
    }
    public void callHome(){
        Intent intent = new Intent(TemanBaru.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}