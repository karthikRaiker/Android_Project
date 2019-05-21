package com.example.database1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText uname,passwd,confpasswd;
    Button btnregistr;
    TextView txtviewlogin;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        uname = findViewById(R.id.edittext_username);
        passwd = findViewById(R.id.edittext_password);
        confpasswd = findViewById(R.id.edittext_conf_password);
        btnregistr = findViewById(R.id.button_register);
        txtviewlogin=findViewById(R.id.textview_login);

        txtviewlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Loginintent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(Loginintent);
            }
        });

        btnregistr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = uname.getText().toString().trim();
                String pwd = passwd.getText().toString().trim();
                String cnf_pwd = confpasswd.getText().toString().trim();


                if(user.isEmpty()){
                    uname.setError("Please enter username");

                }
                if(pwd.isEmpty()){
                    passwd.setError("Please enter Password");

                }
                if(cnf_pwd.isEmpty()){
                    confpasswd.setError("Please enter confirm Password field");

                }

                if(user.isEmpty() && pwd.isEmpty() && cnf_pwd.isEmpty())
                {
                    uname.setError("Please enter username");
                    passwd.setError("Please enter Password");
                    confpasswd.setError("Please enter confirm Password field");
                  //  Toast.makeText(RegisterActivity.this,"Please enter registration credentials",Toast.LENGTH_SHORT).show();
                }

                if(!pwd.isEmpty()) {
                    if (pwd.equals(cnf_pwd)) {
                        long val = db.addUser(user, pwd);
                        if (val > 0) {

                            Toast.makeText(RegisterActivity.this, "You have registered", Toast.LENGTH_SHORT).show();
                            Intent movetologin = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(movetologin);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Registration error", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
