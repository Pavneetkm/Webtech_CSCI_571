package com.example.pavneetkaur.myapplication;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ComAdapter  extends BaseAdapter {

    JSONArray json2;
    Context ctxt;
    LayoutInflater myInflator;
    String committeeid;
    String name3;
    String chamber;
    String parent;
    String contact;
    String office;

    public ComAdapter(JSONArray json2, Context c) {
        System.out.println("Welcome to adapter");
        this.json2 = json2;
        this.ctxt = c;
        myInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }




    @Override
    public int getCount() {
        //System.out.println(json2);
        return json2.length();
    }


    @Override
    public Object getItem(int arg0) {


        JSONObject jsonObject = null;
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




//        TabHost tabhost= (TabHost)arg1.findViewById(R.id.tabhost);
//        tabhost.setup();
//
//        TabHost.TabSpec spec1=tabhost.newTabSpec("tab1");
//        spec1.setContent(R.id.tab1);
//        spec1.setIndicator("House");
//        tabhost.addTab(spec1);
//
//        TabHost.TabSpec spec2=tabhost.newTabSpec("tab2");
//        spec2.setContent(R.id.tab2);
//        spec2.setIndicator("Senate");
//        tabhost.addTab(spec2);
//
//        TabHost.TabSpec spec3=tabhost.newTabSpec("tab3");
//        spec3.setContent(R.id.tab3);
//        spec3.setIndicator("Joint");
//        tabhost.addTab(spec3);

       // System.out.println("1234567890122334");



        arg1 = myInflator.inflate(R.layout.layoutbill, arg2, false);





        TextView name = (TextView) arg1.findViewById(R.id.textView7);
        TextView name1 = (TextView) arg1.findViewById(R.id.textView8);
        final TextView name2 = (TextView) arg1.findViewById(R.id.textView9);
        final JSONObject temp = (JSONObject) getItem(arg0);


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
            name.setText(temp.getString("committee_id"));
            name1.setText(temp.getString("name"));
            name2.setText(temp.getString("chamber"));

        } catch (JSONException e) {
            e.printStackTrace();
        }



        ImageButton btn= (ImageButton)arg1.findViewById(R.id.button2);

        final View finalArg = arg1;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    committeeid=(temp.getString("committee_id"));
                    name3=temp.getString("name");
                    chamber=temp.getString("chamber");
                    parent=temp.getString("parent_committee_id");
                    contact=temp.getString("phone");
                    office=temp.getString("office");



                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Intent i= new Intent(ctxt, ComActivity.class);
                i.putExtra("committeeid", committeeid);
                i.putExtra("name3", name3);
                i.putExtra("chamber", chamber);
                i.putExtra("parent", parent);
                i.putExtra("contact", contact);
                i.putExtra("office", office);


                ctxt.startActivity(i);
            }


        });




        return arg1;


    }
}
