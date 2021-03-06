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
import com.touristadev.tourista.activities.PackagedDetailsActivity;
import com.touristadev.tourista.dataModels.TourPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shanyl Jimenez on 11/28/2016.
 */
public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.MyViewHolder>{

    private List<CardView> mViews;
    private List<TourPackage> mData;


    public PackageAdapter(ArrayList<TourPackage> Data) {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        Log.d("shan","2");
        for (int i = 0; i < Data.size(); i++) {
            mData.add(Data.get(i));
            mViews.add(null);
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cv_tgtouritem;
        public ImageView imgTourPackageImage;
        public TextView txtTourPackageName;
        public TextView txtTourDate;
        public TextView txtTourPaymentForTG;
        public TextView txtNoOfSpots;
        public View view;


        public MyViewHolder(View v) {
            super(v);
            view = v;
//            pack= Controllers.TourBookedList.get(getAdapterPosition());

            cv_tgtouritem = (CardView)itemView.findViewById(R.id.cv_package);
            txtTourPackageName = (TextView) itemView.findViewById(R.id.txtTourPackageName);
            txtTourDate = (TextView) itemView.findViewById(R.id.txtTourDate);
            txtTourPaymentForTG = (TextView) itemView.findViewById(R.id.txtTourPaymentForTG);
            imgTourPackageImage= (ImageView)itemView.findViewById(R.id.imgTourPackageImage);
            txtNoOfSpots=(TextView) itemView.findViewById(R.id.txtPackageNoOfSpot);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(view.getContext(),PackagedDetailsActivity.class);
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
    public PackageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cv_package, parent, false);

        Log.d("shan","4");
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });
        return new PackageAdapter.MyViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d("Boholst", mData.get(position).getRating()+ "Boholst");

        Glide.with(holder.view.getContext()).load(mData.get(position).getPhotoFileName())
                .into(holder.imgTourPackageImage);
        holder.txtTourPackageName.setText(mData.get(position).getPackageName());
        holder.txtNoOfSpots.setText(mData.get(position).getNumOfSpots()+" Spots");
        holder.txtTourDate.setText(mData.get(position).getMinPeople()+" People in Min");
        holder.txtTourPaymentForTG.setText("For Tour guide: Php"+mData.get(position).getPayment());
    }






}