package com.example.pavneetkaur.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;


public class ComActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comview);




        TextView textView=(TextView) findViewById(R.id.comid);
        textView.setText(getIntent().getExtras().getString("committeeid"));

        TextView textView1=(TextView) findViewById(R.id.name);
        textView1.setText(getIntent().getExtras().getString("name3"));

        TextView textView2=(TextView) findViewById(R.id.chamber);
        textView2.setText(getIntent().getExtras().getString("chamber"));

        TextView textView3=(TextView) findViewById(R.id.parent);

           if((getIntent().getExtras().getString("parent"))==null) {
               textView3.setText("N.A");

           }
        else {
               textView3.setText(getIntent().getExtras().getString("parent"));
           }

        TextView textView4=(TextView) findViewById(R.id.contact);

        if((getIntent().getExtras().getString("contact"))==null){
            textView4.setText("N.A");
        }

        else {
            textView4.setText(getIntent().getExtras().getString("contact"));
        }


        TextView textView5=(TextView) findViewById(R.id.office);
        if((getIntent().getExtras().getString("office"))==null){
            textView5.setText("N.A");
        }

        else {
            textView5.setText(getIntent().getExtras().getString("office"));
        }











    }

}


