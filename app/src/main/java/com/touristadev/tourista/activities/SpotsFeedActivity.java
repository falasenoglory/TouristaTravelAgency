package com.touristadev.tourista.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.touristadev.tourista.R;
import com.touristadev.tourista.fragments.RequestFragment;
import com.touristadev.tourista.fragments.SpotsFragment;

public class SpotsFeedActivity extends AppCompatActivity {
    BottomBar mBottomBar;
    public FragmentManager fragmentManager;
    public RequestFragment t= new RequestFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots_feed);

        fragmentManager = getSupportFragmentManager();
        final Fragment fragment;
        fragment = new SpotsFragment();
        if (fragment != null) {

            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.fragment_containerRequest, fragment).commit();



        }

    }
}
