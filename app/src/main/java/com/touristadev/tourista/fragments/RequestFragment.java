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
import com.touristadev.tourista.adapters.RequestAdapter;
import com.touristadev.tourista.api.CurrentTravelAgency_API;
import com.touristadev.tourista.api.TourRequest_API;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.utils.HttpUtils;
import com.touristadev.tourista.utils.Utils;

public class RequestFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private ShadowTransformer mCardShadowTransformer;
    private ViewPager mViewPagerTours;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mCardAdapter;



    // TODO: Rename and change types and number of parameters
    public static RequestFragment newInstance(String userNamez) {

        return new RequestFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_request, container, false);



        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("shan","1");

        Controllers.TourRequestList.clear();
        //  FetchTourRequestTask tad= new FetchTourRequestTask();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_recycler_view_request);
        if (Utils.isNetworkAvailable(RequestFragment.super.getActivity())) {

            FetchRequest rtask= new FetchRequest();
            rtask.execute();


        } else {
            showToast("No Network Connection!!!");
        }


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


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    public class FetchRequest extends AsyncTask<Void, Void, String> {


        @Override
        protected String doInBackground(Void... params) {
            String url=Controllers.GETallRequestUrl+ CurrentTravelAgency_API.travelAgencyId+"&status=Request";
            String json = HttpUtils.GET(url);
            return json;
        }

        @Override
        protected void onPostExecute(String rt) {
            super.onPostExecute(rt);

            Log.d("Shanyl","Request: "+rt);
            Controllers.TourRequestList.clear();
            Controllers.TourRequestList= TourRequest_API.getTourRequestList(rt);
            Log.d("Shanyl","Request Fragment TourRequestList: "+ Controllers.TourRequestList.toString());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setHasFixedSize(true);
            mCardAdapter = new RequestAdapter(Controllers.TourRequestList);
            mRecyclerView.setAdapter(mCardAdapter);
            mCardAdapter.notifyDataSetChanged();
        }
    }


    ////////// PRINTERS ///////////////////////////////////////////

    public void showToast(String msg) {
        Toast.makeText(RequestFragment.super.getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    //////////////////////////////////////////////////////////////





}
