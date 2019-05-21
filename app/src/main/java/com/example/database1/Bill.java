package com.example.database1;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Bill extends AppCompatActivity {
    CheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19;
    CheckBox[] c = new CheckBox[18];
    Button b1;
    int sum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final StringBuilder s=new StringBuilder();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);


        b1 = findViewById(R.id.b1);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        c9 = findViewById(R.id.c9);
        c10 = findViewById(R.id.c10);
        c11 = findViewById(R.id.c11);
        c12 = findViewById(R.id.c12);
        c13 = findViewById(R.id.c13);
        c14 = findViewById(R.id.c14);
        c15 = findViewById(R.id.c15);
        c16 = findViewById(R.id.c16);
        c17 = findViewById(R.id.c17);
        c18 = findViewById(R.id.c18);
        c19 = findViewById(R.id.c19);

        if (c1.isChecked()) {
            sum += 300;


        }

        if (c2.isChecked()) {
            sum += 100;

        }
        if (c3.isChecked()) {
            sum += 100;
        }
        if (c4.isChecked()) {
            sum += 300;
        }
        if (c5.isChecked()) {
            sum += 100;
        }
        if (c6.isChecked()) {
            sum += 300;
        }
        if (c7.isChecked()) {
            sum += 400;
        }
        if (c8.isChecked()) {
            sum += 100;
        }
        if (c9.isChecked()) {
            sum += 100;
        }
        if (c10.isChecked()) {
            sum += 100;
        }
        if (c11.isChecked()) {
            sum += 100;
        }
        if (c12.isChecked()) {
            sum += 500;
        }
        if (c13.isChecked()) {
            sum += 100;
        }
        if (c14.isChecked()) {
            sum += 100;
        }
        if (c15.isChecked()) {
            sum += 100;
        }
        if (c16.isChecked()) {
            sum += 100;
        }
        if (c17.isChecked()) {
            sum += 300;
        }
        if (c18.isChecked()) {
            sum += 400;
        }
        if (c19.isChecked()) {
            sum += 100;
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c1.isChecked())
                {
                    s.append("Vehicle speed exceeding the maximum speed fixed = 300"+"\n");
                    sum += 300;

                }
                if (c2.isChecked())
                {

                    s.append("No Parking   = 100"+"\n");
                    sum += 100;

                }
                if (c3.isChecked())
                {
                    s.append("Defective Silencer   = 100"+"\n");
                    sum += 100;

                }

                if (c4.isChecked())
                {
                    s.append("Emitting Black Somke    = 300"+"\n");
                    sum += 300;


                }
                if (c5.isChecked())
                {
                    s.append("Shrill Horn    = 100"+"\n");
                    sum += 100;

                }
                if (c6.isChecked())
                {
                    s.append("Without Driving License Two Wheeler   = 300"+"\n");
                    sum += 300;


                }
                if (c7.isChecked())
                {
                    s.append("Without Driving License Non-Transport Vehicle   = 400"+"\n");
                    sum += 400;

                }
                if (c8.isChecked())
                {
                    s.append("Jumping Traffic Signal   = 100"+"\n");
                    sum += 100;

                }
                if (c9.isChecked())
                {
                    s.append("Wrong Parking    = 100"+"\n");
                    sum += 100;

                }
                if (c10.isChecked())
                {
                    s.append("Defective Number Plate    = 100"+"\n");
                    sum += 100;

                }
                if (c11.isChecked())
                {
                    s.append("No Entry    = 100"+"\n");
                    sum += 100;

                }
                if (c12.isChecked())
                {
                    s.append("Without Insurance Card   = 100"+"\n");
                    sum += 100;

                }
                if (c13.isChecked())
                {
                    s.append("Driving any Motor Vehicle without number plate    = 100"+"\n");
                    sum += 100;

                }
                if (c14.isChecked())
                {
                    s.append("Holding/using Mobile Phone while Driving / riding a Vehicle = 100"+"\n");
                    sum += 100;
                }
                if (c15.isChecked())
                {
                    s.append("Not wearing Helmet to head while riding the Vehicle    = 100"+"\n");
                    sum += 100;

                } if (c16.isChecked())
                {
                    s.append("Triple riding     = 100"+"\n");
                    sum += 100;

                } if (c17.isChecked())
                {
                    s.append("Wrong Parking + Towing charges(2Wheeler)     = 100"+"\n");
                    sum += 100;
                }
                if (c18.isChecked())
                {
                    s.append("Wrong Parking + Towing charges (Car)    = 100"+"\n");
                    sum += 100;

                }
                if (c19.isChecked())
                {
                    s.append("Driving without wearing Seat Belt    = 100"+"\n");
                    sum += 100;
                }
                else {

                }

                Intent i=new Intent(Bill.this,displaybill.class);
                String m=s.toString();
                i.putExtra("bill",m);
                String su=Integer.toString(sum);
                i.putExtra("total",su);
                startActivity(i);
            }
        });

    }

}
