package com.example.database1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PoliceActivity extends AppCompatActivity {
    Button scan,bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);

        scan=findViewById(R.id.qrscanner);
        bill=findViewById(R.id.billing);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PoliceActivity.this,QRScanner.class);
                startActivity(i);
            }
        });

        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PoliceActivity.this,Bill.class);
                startActivity(intent);
            }
        });
    }
}
