package com.example.database1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText uname,passwd;
    Button login,cancel;
    TextView register;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        uname = findViewById(R.id.edittext_username);
        passwd = findViewById(R.id.edittext_password);
        login = findViewById(R.id.button_login);
        cancel = findViewById(R.id.cancel);
        register = findViewById(R.id.textview_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerintent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(registerintent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = uname.getText().toString().trim();
                String pwd = passwd.getText().toString().trim();
                Boolean res = db.checkUser(user,pwd);
                if(res==true) {
                    if (user.isEmpty() && pwd.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Login credentials should not be empty", Toast.LENGTH_SHORT).show();
                    }
                    if (user.isEmpty()) {
                        uname.setError("Please enter username");

                    }
                    if (pwd.isEmpty()) {
                        passwd.setError("Please enter password");
                    }
                     else if (ADMIN.matcher(user).matches()) {
                        Toast.makeText(MainActivity.this, "Welcome to admin Login", Toast.LENGTH_SHORT).show();
                        Intent adminpage = new Intent(MainActivity.this, adminactivity.class);
                        startActivity(adminpage);
                    } else if (POLICE.matcher(user).matches()) {
                        Toast.makeText(MainActivity.this, "Welcome to police Login", Toast.LENGTH_SHORT).show();
                        Intent popage = new Intent(MainActivity.this, PoliceActivity.class);
                        startActivity(popage);
                    } else
                        {
                        Toast.makeText(MainActivity.this, "Welcome to rider Login", Toast.LENGTH_SHORT).show();
                        Intent ripage = new Intent(MainActivity.this, RiderActivity.class);
                        startActivity(ripage);
                    }
                  //  else
                   // {
                     //   Toast.makeText(MainActivity.this,"Login failure",Toast.LENGTH_SHORT).show();
                    //}
                }
                else
                {
                    if (user.isEmpty() && pwd.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Login credentials should not be empty", Toast.LENGTH_SHORT).show();
                    }
                    if (user.isEmpty()) {
                        uname.setError("Please enter username");

                    }
                    if (pwd.isEmpty()) {
                        passwd.setError("Please enter password");
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Login failure",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    public static final Pattern ADMIN
            // = Pattern.compile("[ad\\+\\a-z0-9\\+]");
            = Pattern.compile("[a][d][m][A-Za-z0-9\\-]{0,15}");
    public static final Pattern POLICE
            // = Pattern.compile("[ad\\+\\a-z0-9\\+]");
            = Pattern.compile("[p][o][l][A-Za-z0-9\\-]{0,15}");
    public static final Pattern RIDER
            // = Pattern.compile("[ad\\+\\a-z0-9\\+]");
            = Pattern.compile("[r][i][d][A-Za-z0-9\\-]{0,15}");
}
