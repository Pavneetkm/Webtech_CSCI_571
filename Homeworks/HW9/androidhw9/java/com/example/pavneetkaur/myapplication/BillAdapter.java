package com.example.pavneetkaur.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BillAdapter extends BaseAdapter {

    JSONArray json2;
    Context ctxt;
    LayoutInflater myInflator;
    String billid;
    String title;
    String billtype;
    String sponsor;
    String chamber;
    String introducedon;
    String url;
    String status;
    String bill;

    public BillAdapter(JSONArray json2, Context c){
        System.out.println("Welcome to adapter");
        this.json2=json2;
        this.ctxt=c;
        myInflator=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }




    @Override
    public int getCount() {
        //System.out.println(json2);
        return json2.length();
    }





    @Override
    public Object getItem(int arg0) {


        JSONObject jsonObject= null;
        try {
            jsonObject = json2.getJSONObject(arg0);
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


        arg1=myInflator.inflate(R.layout.layoutbill,arg2,false);
        TextView name=(TextView)arg1.findViewById(R.id.textView7);
        TextView name1=(TextView)arg1.findViewById(R.id.textView8);
         TextView name2=(TextView)arg1.findViewById(R.id.textView9);
        final JSONObject temp=(JSONObject)getItem(arg0);


        // View v=(View) arg1.findViewById(R.id.boxlayout);
        //ImageView img= (ImageView)arg1.findViewById(R.id.imageView3);
        //System.out.println(name);
        //System.out.println(img);
        //System.out.println(arg1);

//        try {
//            Picasso.with(ctxt.getApplicationContext()).load("http://theunitedstates.io/images/congress/original/" + temp.getString("bioguide_id") + ".jpg" ).into(img);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


        System.out.println("12345");
        System.out.println(temp);
        try {
            name.setText(temp.getString("bill_id"));
            name1.setText(temp.getString("official_title"));
            name2.setText(temp.getString("introduced_on"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


        ImageButton btn= (ImageButton)arg1.findViewById(R.id.button2);

        final View finalArg = arg1;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    billid=temp.getString("bill_id");
                    title=temp.getString("official_title");
                    billtype=temp.getString("bill_type");
                    //sponsor=(temp.getString("title") + " " +temp.getString("last_name")+" ," + temp.getString("first_name"));
                    chamber=temp.getString("chamber");
                    introducedon=temp.getString("introduced_on");
                    url=temp.getString("versions.urls.html");
                   // status=temp.getString("bill_id");
                    bill=temp.getString("urls.pdf");









                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Intent i= new Intent(ctxt, BillActivity.class);
                i.putExtra("billid", billid);
                i.putExtra("title", title);
                i.putExtra("billtype", billtype);
                i.putExtra("sponsor", sponsor);
                i.putExtra("chamber", chamber);
                i.putExtra("introduced", introducedon);
                i.putExtra("url", url);
                i.putExtra("status", status);
                //i.putExtra("bill", bill);


                ctxt.startActivity(i);
            }


        });

        return arg1;

    }



}
