package com.example.pavneetkaur.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONException;

import static android.app.PendingIntent.getActivity;


/**
 * Created by pavneetkaur on 11/27/16.
 */

public class LegActivity extends Activity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.legview);

        ImageView image=(ImageView) findViewById(R.id.legimg);
        Picasso.with(getApplicationContext()).load("http://theunitedstates.io/images/congress/original/" + getIntent().getExtras().getString("bioguideid") + ".jpg" ).into(image);

        if(getIntent().getExtras().getString("facebook")==null){

            findViewById(R.id.imageButton1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Facebook profile not exists!",
                            Toast.LENGTH_LONG).show();
                }
            });

        }
        else {

            findViewById(R.id.imageButton1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "http://www.facebook.com/" + getIntent().getExtras().getString("facebook");

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
        }


        if(getIntent().getExtras().getString("twitter")==null){

            findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(getApplicationContext(), "Twitter profile not exists!",
                            Toast.LENGTH_LONG).show();
                }



                });
        }

        else {

            findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "http://www.twitter.com/" + getIntent().getExtras().getString("twitter");

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
        }



        if(getIntent().getExtras().getString("website")==null){


            findViewById(R.id.imageButton3).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(getApplicationContext(), "Website not exists!",
                            Toast.LENGTH_LONG).show();
                }



            });
        }
        else {
            findViewById(R.id.imageButton3).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = getIntent().getExtras().getString("website");

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
        }


        TextView text=(TextView) findViewById(R.id.party);
        if(getIntent().getExtras().getString("party")=="R"){

            text.setText("Republic");
        }
        else{

            text.setText("Democrat");
        }

        //text.setText(getIntent().getExtras().getString("party"));


        TextView textView=(TextView) findViewById(R.id.name);
        textView.setText(getIntent().getExtras().getString("name2"));

        TextView textView1=(TextView) findViewById(R.id.email);


        if((getIntent().getExtras().getString("email"))==null) {
            textView1.setText("N.A");

        }
        else {
            textView1.setText(getIntent().getExtras().getString("email"));
        }



        TextView textView2=(TextView) findViewById(R.id.chamber);
        textView2.setText(getIntent().getExtras().getString("chamber1"));

        TextView textView3=(TextView) findViewById(R.id.contact);
        textView3.setText(getIntent().getExtras().getString("contact1"));

        TextView textView4=(TextView) findViewById(R.id.startterm);
        textView4.setText(getIntent().getExtras().getString("termstart1"));

        TextView textView5=(TextView) findViewById(R.id.endterm);
        textView5.setText(getIntent().getExtras().getString("termend1"));

        TextView textView6=(TextView) findViewById(R.id.term);
        textView6.setText(getIntent().getExtras().getString("term1"));

        TextView textView7=(TextView) findViewById(R.id.office);
        if((getIntent().getExtras().getString("office1"))==null) {
            textView7.setText("N.A");

        }
        else {
            textView7.setText(getIntent().getExtras().getString("office1"));
        }



        TextView textView8=(TextView) findViewById(R.id.state);
        textView8.setText(getIntent().getExtras().getString("state1"));

        TextView textView9=(TextView) findViewById(R.id.fax);
        if((getIntent().getExtras().getString("fax"))==null) {
            textView9.setText("N.A");

        }
        else {
            textView9.setText(getIntent().getExtras().getString("fax"));
        }



        TextView textView0=(TextView) findViewById(R.id.bday);
        textView0.setText(getIntent().getExtras().getString("bday1"));









    }

}
