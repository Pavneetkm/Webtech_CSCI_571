package com.example.pavneetkaur.myapplication;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;


//import com.squareup.picasso.Picasso;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Comparator;

/**
 * Created by pavneetkaur on 11/17/16.
 */

public class CustomAdapter extends BaseAdapter{

    JSONArray json1;
    Context ctxt;
    LayoutInflater myInflator;
    String name2;
    String email;
    String  chamber;
    String contact;
    String  termstart;
    String  termend;
    String term;
    String  office;
    String  state;
    String  fax;
    String  bday;
    String  image;
    String party;
    String facebook;
    String twitter;
    String website;
    String bioguideid;


    public CustomAdapter(JSONArray json1, Context c){
        System.out.println("Welcome to adapter");
        this.json1=json1;
        this.ctxt=c;
        myInflator=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        //System.out.println(json1);
        return json1.length();
    }





    @Override
    public Object getItem(int arg0) {


        JSONObject jsonObject= null;
        try {
            jsonObject = json1.getJSONObject(arg0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {

        System.out.println("1234567890122334");





        arg1=myInflator.inflate(R.layout.boxlayout,arg2,false);
        TextView name=(TextView)arg1.findViewById(R.id.textView5);
        TextView name1=(TextView)arg1.findViewById(R.id.textView6);
        final JSONObject temp=(JSONObject)getItem(arg0);


        // View v=(View) arg1.findViewById(R.id.boxlayout);
        ImageView img= (ImageView)arg1.findViewById(R.id.imageView3);
        //System.out.println(name);
        //System.out.println(img);
        //System.out.println(arg1);

        try {
            Picasso.with(ctxt.getApplicationContext()).load("http://theunitedstates.io/images/congress/original/" + temp.getString("bioguide_id") + ".jpg" ).into(img);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        System.out.println("12345");
        System.out.println(temp);
        try {
            name.setText(temp.getString("last_name")+" ," + temp.getString("first_name"));


            if(temp.getString("district")!=null){
                name1.setText(temp.getString("party") + " " + temp.getString("state_name")+ " - District : " + temp.getString("district") );
            }
            else{

                name1.setText(temp.getString("party") + " " + temp.getString("state_name")+ " - District : 0" );

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }





        ImageButton btn= (ImageButton)arg1.findViewById(R.id.button);

        final View finalArg = arg1;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {


                    party=(temp.getString("party"));
                    name2=(temp.getString("title") + " " +temp.getString("last_name")+" ," + temp.getString("first_name"));
                    email=temp.getString("oc_email");
                    chamber=temp.getString("chamber");
                    contact=temp.getString("phone");
                    termstart=temp.getString("term_start");
                    termend=temp.getString("term_end");
                    term=temp.getString("term_end");
                    office=temp.getString("office");
                    state=temp.getString("state_name");
                    fax=temp.getString("fax");
                    bday=temp.getString("birthday");
                    facebook=temp.getString("facebook_id");
                    twitter=temp.getString("twitter_id");
                    website=temp.getString("website");
                    bioguideid=temp.getString("bioguide_id");







                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Intent i= new Intent(ctxt, LegActivity.class);
                i.putExtra("party",party);
                i.putExtra("name2", name2);
                i.putExtra("facebook",facebook);
                i.putExtra("twitter",twitter);
                i.putExtra("email1", email);
                i.putExtra("chamber1", chamber);
                i.putExtra("contact1", contact);
                i.putExtra("termstart1", termstart);
                i.putExtra("termend1", termend);
                i.putExtra("term1", term);
                i.putExtra("office1", office);
                i.putExtra("state1", state);
                i.putExtra("fax", fax);
                i.putExtra("bday1", bday);
                i.putExtra("image",image);
                i.putExtra("website", website);
                i.putExtra("bioguideid",bioguideid);

                ctxt.startActivity(i);
            }


        });


        return arg1;

    }




}
