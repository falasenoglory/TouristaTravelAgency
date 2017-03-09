package com.touristadev.tourista.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touristadev.tourista.R;
import com.touristadev.tourista.adapters.CardExplorerPagerAdapter;
import com.touristadev.tourista.adapters.CardFragmentPagerAdapter;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.ExploreCard;
import com.touristadev.tourista.dataModels.Spots;
import com.touristadev.tourista.dataModels.Spots2;

import java.util.ArrayList;

/**
 * Created by Christian on 3/9/2017.
 */
public class SpotsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<ExploreCard> SpotList = new ArrayList<>();
    private OnFragmentInteractionListener mListener;
    private ArrayList<Spots2> SpotListTemp = new ArrayList<>();
    private ArrayList<Bitmap> mListImages = new ArrayList<>();
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mCardAdapter;

    public SpotsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotToursFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SpotsFragment newInstance(String param1, String param2) {
        SpotsFragment fragment = new SpotsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hot_spots, container, false);
        SpotListTemp.clear();
        SpotListTemp = Controllers.getControllerSpots();
        SpotList.clear();

//        -----------------------------------------------------------------------------------------------
        if(SpotListTemp!=null){
            for(int x = 0 ; x < SpotListTemp.size() ; x++) {
                SpotList.add(new ExploreCard(SpotListTemp.get(x).getSpotName(), SpotListTemp.get(x).getSpotRating(), " ", " ", " ", "spot",SpotListTemp.get(x).getSpotImage(),""));

            }
        }

        mRecyclerView = (RecyclerView) v.findViewById(R.id.rv_recycler_view_spots);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);


        mCardAdapter = new CardExplorerPagerAdapter(SpotList);
        mRecyclerView.setAdapter(mCardAdapter);
        mCardAdapter.notifyDataSetChanged();




        return v;
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
}
