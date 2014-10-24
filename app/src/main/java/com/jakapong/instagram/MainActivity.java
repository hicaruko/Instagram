package com.jakapong.instagram;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

     private static final String TAG = MainActivity.class.getSimpleName();

    public FragmentTabHost mTabHost;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTab();


    }
    public void addTab(){
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        View tabIndicator;
        Bundle b;

        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();  // deprecated

        String paths = "com.jakapong.instagram.";
        String pages[]= {"HomeFragment","HomeFragment","HomeFragment","HomeFragment"};
        String TabSpecNames[]= {"home","buy","market","transfer"};
        String TabSpecTitle[]= {"Home","Buy","Market","Transfer"};
        Drawable DrawableIcon[]= {
                getResources().getDrawable(R.drawable.tab_home),
                getResources().getDrawable(R.drawable.tab_buy),
                getResources().getDrawable(R.drawable.tab_market),
                getResources().getDrawable(R.drawable.tab_transfer),

        };

        Class<?> c;
        for(int i = 0 ; i<=3 ; i++){
            b = new Bundle();
            b.putString("key", TabSpecNames[i]+" params");
            tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicators, mTabHost.getTabWidget(), false);
            TextView title = (TextView) tabIndicator.findViewById(R.id.titles);
            ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icons);
            icon.setImageDrawable(DrawableIcon[i]);
            title.setText(TabSpecTitle[i]);
            if(pages[i] != null) {
                try {
                    c =  Class.forName(paths+""+pages[i]);
                    Log.d("class",""+c +"=="+paths+""+pages[i]);
                    mTabHost.addTab(mTabHost.newTabSpec(TabSpecNames[i]).setIndicator(tabIndicator), c, b);
                    mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab_background);
                    mTabHost.getTabWidget().getChildAt(i).getLayoutParams().width = width/4;
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    Log.d("error","error" );
                    e.printStackTrace();
                }
            }
        }
        mTabHost.getChildAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG,"1");

            }
        });
        mTabHost.getTabWidget().setDividerDrawable(null);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
     //   getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }


}
