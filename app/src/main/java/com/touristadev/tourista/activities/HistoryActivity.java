package com.touristadev.tourista.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.touristadev.tourista.R;
import com.touristadev.tourista.fragments.HistoryFragment;
import com.touristadev.tourista.fragments.TGTourFragment;

public class HistoryActivity extends AppCompatActivity {

    BottomBar mBottomBar;
    public FragmentManager fragmentManager;
    public HistoryFragment t= new HistoryFragment();
    private int notifCount = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Intent intent= new Intent(HistoryActivity.this,RequestActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tgtour);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarT);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#fecd23"));
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));


        fragmentManager = getSupportFragmentManager();
        final Fragment fragment;
        fragment = new TGTourFragment();
        if (fragment != null) {

            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.fragment_containerTGTour, fragment).commit();
        }
        mBottomBar= BottomBar.attach(this,savedInstanceState);
        mBottomBar.useFixedMode();
        mBottomBar.setActiveTabColor(Color.parseColor("#fecd23"));
        mBottomBar.setDefaultTabPosition(2);
        mBottomBar.setItemsFromMenu(R.menu.menu_tourguide, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if(menuItemId== R.id.bbrequestbar)
                {

                    Intent i = new Intent(HistoryActivity.this, RequestActivity.class);
                    startActivity(i);
                }
                if(menuItemId== R.id.bbtourbar)
                {
                    Intent i = new Intent(HistoryActivity.this, TGTourActivity.class);
                    startActivity(i);

                }
                if(menuItemId== R.id.bbhistory)
                {
                    t = new HistoryFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerTGTour, t).commit();
                }
                if (menuItemId == R.id.bbprofile) {
                    Intent intent = new Intent(HistoryActivity.this, PassportActivity.class);
                    intent.putExtra("tourguidemode",true);
                    startActivity(intent);
                }


            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });

    }



}
