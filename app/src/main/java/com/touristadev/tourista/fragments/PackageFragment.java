package com.touristadev.tourista.fragments;

/**
 * Created by Shanyl Jimenez on 12/1/2016.
 */

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.touristadev.tourista.R;
import com.touristadev.tourista.activities.ShadowTransformer;
import com.touristadev.tourista.adapters.CardFragmentPagerAdapter;
import com.touristadev.tourista.adapters.PackageAdapter;
import com.touristadev.tourista.api.CurrentTravelAgency_API;
import com.touristadev.tourista.api.DecodeJSONTourPackage;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.utils.HttpUtils;

public class PackageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private OnFragmentInteractionListener mListener;

    private ShadowTransformer mCardShadowTransformer;
    private ViewPager mViewPagerTours;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mCardAdapter;
    private Controllers mControllers;


    // TODO: Rename and change types and number of parameters
    public static PackageFragment newInstance(String userNamez) {

        return new PackageFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_package, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("shan","1");

        Controllers.PackageList.clear();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_recycler_view_package);

            FetchPackages tad= new FetchPackages();
            tad.execute();



        //permet un affichage sous forme liste verticale
//
//        mCardShadowTransformer = new ShadowTransformer(mViewPagerTours, mCardAdapter);
//        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPagerTours, mFragmentCardAdapter);


//        mViewPagerTours.setPageTransformer(false, mCardShadowTransformer);
//        mViewPagerTours.setOffscreenPageLimit(3);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    public class FetchPackages extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String url=Controllers.GET_TG_PACKAGES+ CurrentTravelAgency_API.travelAgencyId;
            Log.d("Shanyl","Ondoing: "+url);
            String json = HttpUtils.GET(url);
            return json;
        }

        @Override
        protected void onPostExecute(String rt) {
            super.onPostExecute(rt);

            Log.d("Shanyl","Booked: "+rt);
            Controllers.PackageList.clear();
            Controllers.PackageList= DecodeJSONTourPackage.DecodeJSONTourPackage(rt);
            Log.d("Shanyl","Booked Fragment TourRequestList: "+ Controllers.PackageList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setHasFixedSize(true);
            mCardAdapter = new PackageAdapter(Controllers.PackageList);
            mRecyclerView.setAdapter(mCardAdapter);
            mCardAdapter.notifyDataSetChanged();
            showToast("Getit na!");
        }
    }



    ////////// PRINTERS ///////////////////////////////////////////

    public void showToast(String msg) {
        Toast.makeText(PackageFragment.super.getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    //////////////////////////////////////////////////////////////




}
