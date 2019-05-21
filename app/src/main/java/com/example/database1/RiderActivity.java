package com.example.database1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RiderActivity extends AppCompatActivity {
    Button btn_share,btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider);

        btn_share=findViewById(R.id.shareit);
        btn=findViewById(R.id.button);

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i=new Intent(RiderActivity.this,Checkqr.class);
                //startActivity(i);
                shareIt();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {


                    Intent launchphonepeApplication = getPackageManager().getLaunchIntentForPackage("com.phonepe.app");
                    startActivity(launchphonepeApplication);
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),"application is not installed on your device",Toast.LENGTH_SHORT).show();
                }

                //     Uri uri = Uri.parse("https://www.Paytm.com");


                //   Intent i= new Intent(Intent.ACTION_VIEW,uri);

                // i.setPackage("com.Paytm.android");

                //   try {
                //      startActivity(i);
                //  } catch (ActivityNotFoundException e) {

                //   startActivity(new Intent(Intent.ACTION_VIEW,
                //          Uri.parse("http://www.Paytm.com")));

                //Toast.makeText(getApplicationContext(),"Application is not installed on your device",Toast.LENGTH_SHORT).show();
                // }
            }
        });
    }
    private void shareIt() {
//sharing implementation here
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "QR code");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "QR code");
        startActivity(Intent.createChooser(sharingIntent, "Get QR code via"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.shareit) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
