
package com.example.pavneetkaur.myapplication;

        import android.app.Activity;
        import android.content.Context;
        import android.os.Bundle;

        import android.widget.ImageView;
        import android.widget.TextView;

        import com.squareup.picasso.Picasso;

        import org.json.JSONException;


/**
 * Created by pavneetkaur on 11/27/16.
 */

public class BillActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billview);
        TextView textView=(TextView) findViewById(R.id.billid);
        textView.setText(getIntent().getExtras().getString("billid"));

        TextView textView1=(TextView) findViewById(R.id.title);
        textView1.setText(getIntent().getExtras().getString("title"));

        TextView textView2=(TextView) findViewById(R.id.billtype);
        textView2.setText(getIntent().getExtras().getString("billtype"));

        TextView textView3=(TextView) findViewById(R.id.sponsor);
        textView3.setText("Rep.Messer,Luke");

        TextView textView4=(TextView) findViewById(R.id.chamber);
        textView4.setText(getIntent().getExtras().getString("chamber"));

        TextView textView5=(TextView) findViewById(R.id.introducedon);
        textView5.setText(getIntent().getExtras().getString("introduced"));

        TextView textView6=(TextView) findViewById(R.id.url);
        textView6.setText("http://beta.congress.gov/bill/114th/house-concurrent-resolution/116");

        TextView textView7=(TextView) findViewById(R.id.status);
        textView7.setText("Enrolled Bill");

        TextView textView8=(TextView) findViewById(R.id.bill);
        textView8.setText("None");













    }

}
