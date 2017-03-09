package com.touristadev.tourista.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.listViewPackItinerary;

import com.touristadev.tourista.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian on 2/20/2017.
 */

public class ListViewItineraryAdaper extends ArrayAdapter<listViewPackItinerary> {

    private int layoutResource;
    private List<listViewPackItinerary> loli = new ArrayList<>();
    Context con;
    public ListViewItineraryAdaper(Context context, int layoutResource, List<listViewPackItinerary> threeStringsList) {
        super(context, layoutResource, threeStringsList);
        loli = threeStringsList;
        con = context;
        this.layoutResource = layoutResource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(layoutResource, null);
        }

        listViewPackItinerary threeStrings = getItem(position);

        if (threeStrings != null) {
            TextView txtName = (TextView) view.findViewById(R.id.txtName);
            ImageView imgCancel = (ImageView) view.findViewById(R.id.imgCancel);

            if (txtName != null) {
                txtName.setText(threeStrings.getName());
            }

                imgCancel.setImageResource(R.drawable.ic_delete);
                imgCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String packId = Controllers.PackageList.get(Integer.parseInt(loli.get(pos).getPackagePos())).getPackageId();
                        String spotId = Controllers.PackageList.get(Integer.parseInt(loli.get(pos).getPackagePos())).getSpots().get(pos).SPOTID;

                        Log.d("ListViewChannix", "Clicked!");
                        Log.d("ListViewChannix", loli.get(pos).getPackagePos()+" 1");
                        Log.d("ListViewChannix", pos+" 2");
                        Log.d("ListViewChannix", packId+" PackId");
                        Log.d("ListViewChannix", spotId+" SpotId");
                        Controllers.removeSpot(packId,spotId);
                        Log.d("ListViewChannix", "Clicked!");
                        Log.d("ListViewChannix", loli.get(pos).getPackagePos()+" 1");
                        Log.d("ListViewChannix", pos+" 2");
//                        Intent e = new Intent(con.getApplicationContext(),CustomPackageActivity.class);
//                        e.putExtra("type","details");
//                        e.putExtra("pos",loli.get(pos).getPackagePos());
//                        con.startActivity(e);
                        notifyDataSetChanged();
                    }
                });


        }

        return view;
    }
}