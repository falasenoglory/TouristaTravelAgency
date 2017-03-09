package com.touristadev.tourista.adapters;

/**
 * Created by Christian on 11/25/2016.
 */


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.touristadev.tourista.R;
import com.touristadev.tourista.activities.BookDetailsActivity;
import com.touristadev.tourista.activities.PolicyActivity;
import com.touristadev.tourista.activities.SpotActivity;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.ExploreCard;
import com.touristadev.tourista.dataModels.TouristaPackages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CardExplorerPagerAdapter extends RecyclerView.Adapter<CardExplorerPagerAdapter.MyViewHolder>{

    private List<CardView> mViews;
    private static List<ExploreCard> mDataAda;
    private static Controllers mControllerAda = new Controllers();
    private List<Bitmap> mImages;
    private Context context;
    public static int pos;
    public static String lulie;
    private static String wish = "wew";
    private String type = " ";
    private static View FinView;
    private TextView txtTitle,txtPrice,txtSpots,txtHours;
    public CardExplorerPagerAdapter(ArrayList<ExploreCard> Data) {

        mDataAda = new ArrayList<>();
        mViews = new ArrayList<>();
        mImages = new ArrayList();

        if(Data!=null ){
        for (int i = 0; i < Data.size(); i++) {
            mDataAda.add(Data.get(i));
            mViews.add(null);

             }
        }
    }
    public CardExplorerPagerAdapter(ArrayList<ExploreCard> Data, String wishle) {

        mDataAda = new ArrayList<>();
        mViews = new ArrayList<>();
        mImages = new ArrayList();

        if(Data!=null ){
            for (int i = 0; i < Data.size(); i++) {
                mDataAda.add(Data.get(i));
                mViews.add(null);
                wish = wishle;

            }
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       public TextView txtTitle;
        public TextView txtPrice;
        public TextView txtSpots;
        public TextView txtHours;
        public TextView txtCompName;
        public RatingBar rtBar;
        public ImageView imageV;
        public CardView cardView;
        public MyViewHolder(View v) {
            super(v);
            View view = v;
             cardView = (CardView) view.findViewById(R.id.cardView);
            txtTitle = (TextView) view.findViewById(R.id.txtTGTitle);
            txtPrice = (TextView) view.findViewById(R.id.txtPrice);
            txtSpots = (TextView) view.findViewById(R.id.txtNoSpots);
            txtHours = (TextView) view.findViewById(R.id.NoHours);
            rtBar = (RatingBar) view.findViewById(R.id.rtTGBar);
            imageV = (ImageView) view.findViewById(R.id.imgCard);
            txtCompName = (TextView) view.findViewById(R.id.txtCompanyName);

            cardView.setOnClickListener(this);
            pos = getAdapterPosition();
        }

        @Override
        public void onClick(View view) {

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

            Calendar c = Calendar.getInstance();
            String formattedDate = df.format(c.getTime());
            Log.d("CardExploreChannix",getAdapterPosition()+" position");
            pos = getAdapterPosition();
            Log.d("CardExploreChannix",pos+" position");

                    afterClick(view);


        }
    }

    @Override
    public int getItemCount() {
        int size = 0;
       size = mDataAda.size();
        return size;
    }

    @Override
    public CardExplorerPagerAdapter.MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_explore, parent, false);
        context = view.getContext();

        //FONTS
        Typeface FontPoppinsBold = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Bold.ttf");
        Typeface FontPoppinsLight = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Light.ttf");

        txtPrice = (TextView) view.findViewById(R.id.txtPrice);
        txtPrice.setTypeface(FontPoppinsBold);

        txtTitle = (TextView) view.findViewById(R.id.txtTGTitle);
        txtTitle.setTypeface(FontPoppinsLight);

        txtSpots = (TextView) view.findViewById(R.id.txtNoSpots);
        txtSpots.setTypeface(FontPoppinsLight);

        txtHours = (TextView) view.findViewById(R.id.NoHours);
        txtHours.setTypeface(FontPoppinsLight);

        view.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {





            }
        });
        return new CardExplorerPagerAdapter.MyViewHolder(view) {
        };
    }


    @Override
    public void onBindViewHolder(CardExplorerPagerAdapter.MyViewHolder holder, int position) {
        holder.cardView.setTag(position);
      Glide.with(context).load(mDataAda.get(position).getImgView()).into( holder.imageV);
        holder.txtTitle.setText(mDataAda.get(position).getTitle());
       holder.txtPrice.setText(mDataAda.get(position).getPrice());
       holder.txtSpots.setText(mDataAda.get(position).getNoSpots());
        holder.txtHours.setText(mDataAda.get(position).getNoHours());
        holder.txtCompName.setText(mDataAda.get(position).getCompanyName());
        holder.rtBar.setRating((Float.parseFloat(String.valueOf(mDataAda.get(position).getRating()))));
        holder.rtBar.setFocusable(false);

    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }
    public static void afterClick(final View v){
        FinView = v;
        ArrayList<TouristaPackages> helist = new ArrayList<>();

        String typee;



                    Intent i = new Intent(v.getContext(), SpotActivity.class);
                    i.putExtra("position", pos);
                    v.getContext().startActivity(i);



}



}