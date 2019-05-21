package com.example.database1;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class displaybill extends AppCompatActivity {
    Button btn_share,cancel,pdf;
    TextView t,l,heading,line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaybill);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("bill");

        pdf = findViewById(R.id.pdf);
        heading=findViewById(R.id.textView);
        line = findViewById(R.id.linee);

        btn_share = findViewById(R.id.shareit);
        cancel = findViewById(R.id.cancel);

        t=(TextView)findViewById(R.id.disp);
        l=findViewById(R.id.textView2);
        t.setText("");
        t.setText(message);
        String su=bundle.getString("total");
        l.setText("TOTAL AMOUNT TO BE PAID: "+su);

        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPDF();
            }
        });


        btn_share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                shareIt();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(displaybill.this, Bill.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    public void createPDF()
    {
        TextView txt = t;
        TextView tot = l;
        TextView head = heading;
        TextView lin = line;

        //EditText txt = (EditText)findViewById(R.id.txt_input);
        Document doc = new Document();
        String outPath = Environment.getExternalStorageDirectory()+"/penalty.pdf";
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(outPath));
            doc.open();
// Finally Adding that Chunk
            doc.add(new Paragraph(head.getText().toString()));
            doc.add(new Paragraph(lin.getText().toString()));
            doc.add(new Paragraph(txt.getText().toString()));
            doc.add(new Paragraph(lin.getText().toString()));
            doc.add(new Paragraph(tot.getText().toString()));
            doc.add(new Paragraph(lin.getText().toString()));
            doc.close();
            Toast.makeText(getApplicationContext(), "pdf saved successfully",Toast.LENGTH_SHORT).show();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        t.setText("");
        super.onDestroy();
    }

    private void shareIt() {
//sharing implementation here
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Penalty to the rider");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Your Penalty bill ");
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
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
