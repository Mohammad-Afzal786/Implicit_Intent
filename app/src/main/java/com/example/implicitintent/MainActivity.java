package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnDail,btnMsg,btnEmail,btnShare,btnUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDail=findViewById(R.id.btnDail);
        btnMsg=findViewById(R.id.btnMsg);
        btnEmail=findViewById(R.id.btnEmail);
        btnShare=findViewById(R.id.btnShare);
        btnShare=findViewById(R.id.btnUrl);
        btnDail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDail=new Intent(Intent.ACTION_DIAL);
                iDail.setData(Uri.parse("tel:+918171189604"));
                startActivity(iDail);
            }
        });
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMsg =new Intent();
               iMsg.setAction(Intent.ACTION_SENDTO);
               iMsg.setData(Uri.parse("smsto:" +Uri.decode("+918171189604")));
               iMsg.putExtra("sms_body","Hello world!");
               startActivity(iMsg);
            }
        });
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEmail =new Intent();
               iEmail.setAction(Intent.ACTION_SEND);
               iEmail.setType("message/rfc822");
               iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"abc123@gmail.com","abcd1234@gmail.com"});
               iEmail.putExtra(Intent.EXTRA_SUBJECT,"Queries !");
               iEmail.putExtra(Intent.EXTRA_TEXT,"Hello world ");
               startActivity(Intent.createChooser(iEmail,"Email Via"));


            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare=new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"We hope you’re having fun playing Candy Crush Saga! We update the game every week so don't forget to download the latest version to get all the sweet new features and levels!,https://play.google.com/store/apps/details?id=com.king.candycrushsaga");
                startActivity(Intent.createChooser(iShare,"Share Via"));

            }
        });
        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iUrl=new Intent(Intent.ACTION_VIEW);
                iUrl.setData(Uri.parse("https://www.ndtv.com/"));
                startActivity(iUrl);
            }
        });

    }
}