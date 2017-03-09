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
import com.touristadev.tourista.fragments.RequestFragment;

public class RequestActivity extends AppCompatActivity {

    BottomBar mBottomBar;
    public FragmentManager fragmentManager;
    public RequestFragment t= new RequestFragment();


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Intent intent= new Intent(RequestActivity.this,RequestActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarL);
        setSupportActionBar(toolbar);

        toolbar.setBackgroundColor(Color.parseColor("#fecd23"));
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));


        fragmentManager = getSupportFragmentManager();
        final Fragment fragment;
        fragment = new RequestFragment();
        if (fragment != null) {

            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.fragment_containerRequest, fragment).commit();



        }

        toolbar.setTitle("Request");
        mBottomBar= BottomBar.attach(this,savedInstanceState);
        mBottomBar.useFixedMode();
        mBottomBar.setActiveTabColor(Color.parseColor("#fecd23"));
        mBottomBar.setDefaultTabPosition(0);
        mBottomBar.setItemsFromMenu(R.menu.menu_travelagency, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if(menuItemId== R.id.bbpackage)
                {
                    Intent i = new Intent(RequestActivity.this, PackageActivity.class);
                    startActivity(i);

                }
                if(menuItemId== R.id.bbrequestbar)
                {
                    t = new RequestFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerRequest, t).commit();

                }
                if(menuItemId== R.id.bbtourbar)
                {
                    Intent i = new Intent(RequestActivity.this, TGTourActivity.class);
                    startActivity(i);

                }
                if(menuItemId== R.id.bbhistory)
                {
//                    getSupportFragmentManager().beginTransaction().
//                    remove(getSupportFragmentManager().findFragmentById(R.id.fragment_container)).commit();
                    Intent i = new Intent(RequestActivity.this, HistoryActivity.class);
                    startActivity(i);
                }
                if (menuItemId == R.id.bbprofile) {
                    Intent intent = new Intent(RequestActivity.this, PassportActivity.class);
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
