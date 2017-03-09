package com.touristadev.tourista.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.touristadev.tourista.R;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.BookedPackage;
import com.touristadev.tourista.dataModels.TourGuideModel;
import com.touristadev.tourista.dataModels.TouristaPackages;

import java.util.ArrayList;
import java.util.List;

public class TGItineraryAdapter extends RecyclerView.Adapter<TGItineraryAdapter.MyViewHolder>{

    private List<CardView> mViews;
    private List<BookedPackage> mData= new ArrayList<>();
    private ArrayList<TouristaPackages> packlist = new ArrayList<>();

    private ArrayList<String> spotList = new ArrayList<>();

    private String Packname;
    private Context context;
    public TGItineraryAdapter(ArrayList<TourGuideModel> Data, String PackName) {

        mData = Controllers.TourBookedList;
        mViews = new ArrayList<>();
        Packname = PackName;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgItineraryImage;
        private TextView txtItinerarySpotName,txtItineraryDescription,txtItineraryPackageName;
        private View view;
        public MyViewHolder(View v) {
            super(v);
            view = v;
            imgItineraryImage = (ImageView) view.findViewById(R.id.imgItineraryImage);
            txtItinerarySpotName = (TextView) view.findViewById(R.id.txtItinerarySpotName);
            txtItineraryDescription = (TextView) view.findViewById(R.id.txtItineraryDescription);
        }

    }

    @Override
    public int getItemCount() {
        int size = 0;
        size = mData.size();
        return size;
    }

    @Override
    public TGItineraryAdapter.MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_tourguide, parent, false);
        context = view.getContext();

      //  packlist = ControllerFinal.getControllerPackaaes();
        for(int x = 0 ; x<packlist.size();x++){
            if(packlist.get(x).getPackageName().equals(Packname)){
                for(int y= 0 ; y<packlist.get(x).getSpotItinerary().size();y++) {
                    spotList.add(packlist.get(x).getSpotItinerary().get(y).getSpotName());
                    Log.d("Chan12/28/16D", spotList.get(y) + "");
                }
            }
        }

        return new TGItineraryAdapter.MyViewHolder(view) {
        };
    }


    @Override
    public void onBindViewHolder(TGItineraryAdapter.MyViewHolder holder, int position) {

       // holder.txtItineraryPackageName.setText(mData.get(Controllers.bookedposition).getPackageName());
        Glide.with(holder.view.getContext()).load(mData.get(position).getItenerary_details().get(position).getSpotPhotoFileName())
                .into(holder.imgItineraryImage);
        holder.txtItineraryDescription.setText(mData.get(Controllers.bookedposition).getItenerary_details().get(position).getDescription());
        holder.txtItinerarySpotName.setText(mData.get(Controllers.bookedposition).getItenerary_details().get(position).getSpotName());


    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }




}