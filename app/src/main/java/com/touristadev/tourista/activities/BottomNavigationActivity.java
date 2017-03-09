package com.touristadev.tourista.activities;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.touristadev.tourista.R;


public class BottomNavigationActivity extends AppCompatActivity {

    BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation);

        mBottomBar= BottomBar.attach(this,savedInstanceState);
        mBottomBar.useFixedMode();
        mBottomBar.setItemsFromMenu(R.menu.menu_travelagency, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
//                if(menuItemId== R.id.bottombar1)
//                {
//                    Exp t= new FeedFragments();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,t).commit();
//                }
//                if(menuItemId== R.id.bottombar2)
//                {
//                    FeedFragments t= new FeedFragments();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,t).commit();
//                }
//                if(menuItemId== R.id.bottombar3)
//                {
//                    FeedFragments t= new FeedFragments();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,t).commit();
//                }
//                if(menuItemId== R.id.bottombar4)
//                {
//                    FeedFragments t= new FeedFragments();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,t).commit();
//                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){

        getMenuInflater().inflate(R.menu.menu_travelagency, menu);
        return true;
    }

}
