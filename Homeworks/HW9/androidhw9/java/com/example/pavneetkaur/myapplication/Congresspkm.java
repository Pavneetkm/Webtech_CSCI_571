package com.example.pavneetkaur.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.http.HttpResponseCache;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TabHost;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import static com.example.pavneetkaur.myapplication.R.id.bill;
import static com.example.pavneetkaur.myapplication.R.id.cancel_action;

public class Congresspkm extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {







    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congresspkm);

        final TabHost tabhost= (TabHost) findViewById(R.id.tabhostleg);
        tabhost.setup();

       ListView lv =(ListView)findViewById(R.id.viewlist1);



        TabHost.TabSpec spec1=tabhost.newTabSpec("tab1");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("By State");
        tabhost.addTab(spec1);

        final ListView finalLv = lv;
        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {

                switch (tabhost.getCurrentTab()) {


                    case 0:
                        LegAsynTask leg = new LegAsynTask(finalLv, null, getApplicationContext());
                        leg.execute("http://pavneetcongress.jbhj873h2n.us-west-2.elasticbeanstalk.com/pkmcongressphp.php?argument=legislator");
                        break;

                    case 1:
                        leg = new LegAsynTask(finalLv, null, getApplicationContext());
                        leg.execute("http://pavneetcongress.jbhj873h2n.us-west-2.elasticbeanstalk.com/pkmcongressphp.php?argument=legislator&chamber=house");
                        break;
                    case 2:
                        leg = new LegAsynTask(finalLv, null, getApplicationContext());
                        leg.execute("http://pavneetcongress.jbhj873h2n.us-west-2.elasticbeanstalk.com/pkmcongressphp.php?argument=legislator&chamber=senate");
                        break;

                    default:  leg = new LegAsynTask(finalLv, null, getApplicationContext());
                        leg.execute("http://pavneetcongress.jbhj873h2n.us-west-2.elasticbeanstalk.com/pkmcongressphp.php?argument=legislator");
break;

                }

//                if(s.equals(R.id.tab1)){
//
//
//                    LegAsynTask leg = new LegAsynTask(finalLv,null,getApplicationContext());
//                    leg.execute("http://pavneetcongress.jbhj873h2n.us-west-2.elasticbeanstalk.com/pkmcongressphp.php?argument=legislator");
//
//                }
//
//                if(s.equals(R.id.tab2)){
//                    LegAsynTask leg = new LegAsynTask(finalLv,null,getApplicationContext());
//                    leg.execute("http://pavneetcongress.jbhj873h2n.us-west-2.elasticbeanstalk.com/pkmcongressphp.php?argument=legislator&chamber=house");
//                }
//
//                if(s.equals(R.id.tab3)){
//                    LegAsynTask leg = new LegAsynTask(finalLv,null,getApplicationContext());
//                    leg.execute("http://pavneetcongress.jbhj873h2n.us-west-2.elasticbeanstalk.com/pkmcongressphp.php?argument=legislator&chamber=senate");
//                }
//
            }
                     });


        TabHost.TabSpec spec2=tabhost.newTabSpec("tab2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("House");
        tabhost.addTab(spec2);

        TabHost.TabSpec spec3=tabhost.newTabSpec("tab3");
        spec3.setContent(R.id.tab3);
        spec3.setIndicator("Senate");
        tabhost.addTab(spec3);
        tabhost.setCurrentTab(1);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//        lv = (ListView) findViewById(R.id.viewlist1);
//        LegAsynTask leg = new LegAsynTask(lv,null,this);
//        leg.execute();



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.congresspkm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();



        if (id == R.id.nav_camera) {
            ListView lv =(ListView)findViewById(R.id.viewlist1);
             LegAsynTask leg = new LegAsynTask(lv,null,this);
            leg.execute();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {






             ListView bl = (ListView) findViewById(R.id.viewlist1);


                        BillAsynTask bill = new BillAsynTask(bl, null, this);
                        bill.execute("http://pavneetcongress.jbhj873h2n.us-west-2.elasticbeanstalk.com/pkmcongressphp.php?argument=activebill");






//            tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
//                @Override
//                public void onTabChanged(String s) {
//
//
//                    if (s.equals(R.id.tab1)) {
//                        setDefaultKeyMode(R.id.tab1);
//
//
//                        bill.execute("http://pavneetcongress.jbhj873h2n.us-west-2.elasticbeanstalk.com/pkmcongressphp.php?argument=activebill");
//
//                    }
//
//                    if (s.equals(R.id.tab2)) {
//
//
//
//                        bill.execute("http://pavneetcongress.jbhj873h2n.us-west-2.elasticbeanstalk.com/pkmcongressphp.php?argument=newbill");
//                    }
//
//
//                }
//            });


//            spec1.setIndicator("Active Bills");


        } else if (id == R.id.nav_slideshow) {


//            TabHost tabhost= (TabHost) findViewById(R.id.tabhost);
//            tabhost.setup();
//
//            TabHost.TabSpec spec1=tabhost.newTabSpec("tab1");
//            spec1.setContent(R.id.tab1);
//            spec1.setIndicator("House");
//            tabhost.addTab(spec1);
//
//            TabHost.TabSpec spec2=tabhost.newTabSpec("tab2");
//            spec2.setContent(R.id.tab2);
//            spec2.setIndicator("Senate");
//            tabhost.addTab(spec2);
//
//            TabHost.TabSpec spec3=tabhost.newTabSpec("tab3");
//            spec3.setContent(R.id.tab3);
//            spec3.setIndicator("Joint");
//            tabhost.addTab(spec3);


            ListView com = (ListView) findViewById(R.id.viewlist1);
            ComAyncTask com1 = new ComAyncTask(com, null, this);
            com1.execute();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {


            Intent i= new Intent(this, Aboutme.class);
            this.startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public class LegAsynTask extends AsyncTask<String, Void, Boolean> {

        ListView legislatorlist;
        JSONArray json1;
        Context cont;
        CustomAdapter cd=null;

        public LegAsynTask(ListView legislatorlist,JSONArray json1,Context cont)
        {
            this.legislatorlist=legislatorlist;
            this.json1=json1;
            this.cont=cont;

        }

        @Override
        protected Boolean doInBackground(String... params) {



            json1=null;
            URL url = null;

            try {
                url = new URL("http://pavneetcongress.jbhj873h2n.us-west-2.elasticbeanstalk.com/pkmcongressphp.php?argument=legislator");

                URLConnection abc = url.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        abc.getInputStream()));
                    in.readLine();
                    JSONObject json= new JSONObject(in.readLine());
                     json1=json.getJSONArray("results");
                   // System.out.println(json1);


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            System.out.println(json1);
            cd=new CustomAdapter(json1,cont);
            return null;

        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
//            RelativeLayout rl=(RelativeLayout)findViewById(R.id.boxlayout);
//            System.out.println(rl);

            legislatorlist.setAdapter(cd);



        }
    }


    public class BillAsynTask extends AsyncTask<String, Void, Boolean> {

        ListView bill;
        JSONArray json3;
        Context ctxt;
        BillAdapter bd;


        public BillAsynTask(ListView bill,JSONArray json3,Context ctxt)
        {
            this.bill=bill;
            this.json3=json3;
            this.ctxt=ctxt;

        }


        @Override
        protected Boolean doInBackground(String... strings) {

            json3=null;
            URL url=null;

            try{

                url= new URL(strings[0]);

                URLConnection xyd= url.openConnection();
                BufferedReader ab=new BufferedReader(new InputStreamReader(xyd.getInputStream()));
                ab.readLine();

                JSONObject json= new JSONObject(ab.readLine());
                json3=json.getJSONArray("results");


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            System.out.println(json3);
            bd=new BillAdapter(json3,ctxt);



            return null;
        }



        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
//            RelativeLayout rl=(RelativeLayout)findViewById(R.id.boxlayout);
//            System.out.println(rl);
            bill.setAdapter(bd);


        }


    }




    public class ComAyncTask extends AsyncTask<String, Void, Boolean> {

        ListView com;
        JSONArray json4;
        Context ctxt;
        ComAdapter cd;





        public ComAyncTask(ListView com,JSONArray json4,Context ctxt)
        {
            this.com=com;
            this.json4=json4;
            this.ctxt=ctxt;


        }


        @Override
        protected Boolean doInBackground(String... strings) {


            json4=null;
            URL url=null;

            try{

                url= new URL("http://pavneetcongress.jbhj873h2n.us-west-2.elasticbeanstalk.com/pkmcongressphp.php?argument=committee");


                URLConnection xyd= url.openConnection();
                BufferedReader ab=new BufferedReader(new InputStreamReader(xyd.getInputStream()));
                ab.readLine();

                JSONObject json= new JSONObject(ab.readLine());
                json4=json.getJSONArray("results");


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            System.out.println(json4);
            cd=new ComAdapter(json4,ctxt);



            return null;
        }



        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
//            RelativeLayout rl=(RelativeLayout)findViewById(R.id.boxlayout);
//            System.out.println(rl);
            com.setAdapter(cd);


        }


    }








}
