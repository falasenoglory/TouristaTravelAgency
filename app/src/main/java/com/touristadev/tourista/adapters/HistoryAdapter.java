package com.touristadev.tourista.adapters;

import android.content.Intent;
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
import com.touristadev.tourista.activities.HistoryPackagedDetailsActivity;
import com.touristadev.tourista.dataModels.BookedPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shanyl Jimenez on 3/6/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<TGTourAdapter.MyViewHolder>{

    private List<CardView> mViews;
    private List<BookedPackage> mData;


    public HistoryAdapter(ArrayList<BookedPackage> Data) {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        Log.d("shan","2");
        for (int i = 0; i < Data.size(); i++) {
            mData.add(Data.get(i));
            mViews.add(null);
            Log.d("History na","History na adapter ni");
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cv_tgtouritem;
        public ImageView imgTourPackageImage;
        public TextView txtTourPackageName;
        public TextView txtTourTravelAgency;
        public TextView txtTourDate;
        public TextView txtTourPaymentForTG;
        public View view;


        public MyViewHolder(View v) {
            super(v);
            view = v;

//            pack= Controllers.TourBookedList.get(getAdapterPosition());

            cv_tgtouritem = (CardView)itemView.findViewById(R.id.cv_tgtouritem);
            txtTourPackageName = (TextView) itemView.findViewById(R.id.txtTourPackageName);
            txtTourTravelAgency = (TextView) itemView.findViewById(R.id.txtTourTravelAgency);
            txtTourDate = (TextView) itemView.findViewById(R.id.txtTourDate);
            txtTourPaymentForTG = (TextView) itemView.findViewById(R.id.txtTourPaymentForTG);
            imgTourPackageImage= (ImageView)itemView.findViewById(R.id.imgTourPackageImage);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos= getAdapterPosition();
                    Log.d("History na","History na adapter in press");
                    Intent intent= new Intent(view.getContext(),HistoryPackagedDetailsActivity.class);
                    intent.putExtra("position",getAdapterPosition());
                    view.getContext().startActivity(intent);


                }
            });
        }
    }

    @Override
    public int getItemCount() {
        int size = 0;
        size = mData.size();
//        size = ControllerFinal.getBookedList().size();
        return size;
    }

    @Override
    public TGTourAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cv_tgtours, parent, false);

        Log.d("shan","4");
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });
        return new TGTourAdapter.MyViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(TGTourAdapter.MyViewHolder holder, int position) {
        Log.d("Boholst", "Boholst");

        Glide.with(holder.view.getContext()).load(mData.get(position).getPhotoPath())
                .into(holder.imgTourPackageImage);
        holder.txtTourPackageName.setText(mData.get(position).getPackageName());
        holder.txtTourTravelAgency.setText("by "+mData.get(position).getAgencyName());
        holder.txtTourDate.setText(mData.get(position).getTourDate());
        holder.txtTourPaymentForTG.setText(mData.get(position).getTGPayment());
    }




}
