package com.touristadev.tourista.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.touristadev.tourista.R;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.CustomizedPackage;
import com.touristadev.tourista.dataModels.Spots;
import com.touristadev.tourista.dataModels.Spots2;
import com.touristadev.tourista.dataModels.TourPackage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.touristadev.tourista.R.mipmap.ic_launcher;

public class SpotActivity extends AppCompatActivity {
    private int position;
    private Spots2 spotDetails;
    private ArrayList<Spots2> pack = new ArrayList<>();
    private ImageView imgSpot;
    private Button btnBook;
    private RatingBar ratBar;
    private TextView mSpotName, mSpotAddress, mSpotBudget, mSpotOpen, mSpotClose, mSpotDesc;
    private String openTime, closeTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot);
        imgSpot = (ImageView) findViewById(R.id.TGimgSpot);
        ratBar = (RatingBar) findViewById(R.id.rtTGBar);
        mSpotName = (TextView) findViewById(R.id.txtTGTitle);
        mSpotAddress = (TextView) findViewById(R.id.txtTGSpotAddress);
        mSpotOpen = (TextView) findViewById(R.id.txtTGOpenTime);
        mSpotClose = (TextView) findViewById(R.id.txtTGCloseTime);
        mSpotDesc = (TextView) findViewById(R.id.txtTGSpotDesc);
        btnBook = (Button) findViewById(R.id.btnBook);
        Intent i = getIntent();
        position = i.getIntExtra("position", 0);
        pack.clear();
        pack = Controllers.getControllerSpots();
        spotDetails = pack.get(position);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> mList = new ArrayList<String>();
                ArrayList<TourPackage> mCustomList = new ArrayList<TourPackage>();

                mCustomList = Controllers.PackageList;



                    AlertDialog.Builder builderSingle = new AlertDialog.Builder(SpotActivity.this);
                    builderSingle.setIcon(R.drawable.ic_add);
                    builderSingle.setTitle("Add Spot to: ");

                    final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SpotActivity.this, android.R.layout.select_dialog_singlechoice);
                    for (int z = 0; z < mCustomList.size(); z++) {
                        arrayAdapter.add(mCustomList.get(z).getPackageName());
                    }
                    builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    });

                    builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            final int[] wew = {which};
                            final String strName = arrayAdapter.getItem(which);
                            LayoutInflater factory = LayoutInflater.from(SpotActivity.this);

                            final View textEntryView = factory.inflate(R.layout.text_entry, null);

                            final EditText edtStart = (EditText) textEntryView.findViewById(R.id.edtStart);
                            final EditText edtEnd = (EditText) textEntryView.findViewById(R.id.edtEnd);


                            edtStart.setText("DefaultValue", TextView.BufferType.EDITABLE);
                            edtEnd.setText("DefaultValue", TextView.BufferType.EDITABLE);

                            final AlertDialog.Builder alert = new AlertDialog.Builder(SpotActivity.this);
                            alert.setIcon(ic_launcher).setTitle("Add time").setView(textEntryView)
                                    .setPositiveButton("Save",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,
                                                            int whichButton) {


                                            AlertDialog.Builder builderInner = new AlertDialog.Builder(SpotActivity.this);
                                            builderInner.setMessage(strName);
                                            builderInner.setTitle("Added to " + strName);
                                            builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    Log.d("SpotActivitychan", wew[0] + "");
                                                    JSONObject obj = new JSONObject();

                                                    try {
                                                        obj.put("packageId", Controllers.PackageList.get(wew[0]).getPackageId());
                                                        obj.put("spotId", spotDetails.getSpotID());
//                                                        obj.put("package", "NON-CUSTOM");
                                                        obj.put("startTime", edtStart.getText().toString());
                                                        obj.put("description", spotDetails.getSpotDescription());
                                                        obj.put("chronology",Controllers.PackageList.size());
                                                        obj.put("endTime",edtEnd.getText().toString() );
//                                                        obj.put("type", "NON-CUSTOM");
                                                    } catch (JSONException e) {
                                                        Log.d("SpotActivitychan", e + " Add Spot error");

                                                    }
                                                    SpotActivity.AddSpotToCustomized pr = new SpotActivity.AddSpotToCustomized();
                                                    pr.execute(obj);


                                                }
                                            });
                                            builderInner.show();
                                        }
                                    }).setNegativeButton("Cancel",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,
                                                            int whichButton) {

                                        }
                                    });
                            alert.show();



                            }


                    });
                    builderSingle.show();

            }
        });

        Log.d("SpotActivitychan", spotDetails.getSpotImage() +" SpotAct");

        Glide.with(getApplicationContext()).load(spotDetails.getSpotImage()).into(imgSpot);
        ratBar.setRating(spotDetails.getSpotRating());
        mSpotName.setText(spotDetails.getSpotName());
        mSpotAddress.setText("Address: " + spotDetails.getSpotAddress());
         openTime = spotDetails.getSpotOpeningTime();
            closeTime = spotDetails.getSpotClosingTime();

        mSpotOpen.setText("Open Time: " + openTime + " ");
        mSpotClose.setText("Close Time: " + closeTime + " ");
        mSpotDesc.setText("Description: " + "\n" + spotDetails.getSpotDescription());






        // ListView Item Click Listener

    }
    public class AddSpotToCustomized extends AsyncTask<JSONObject, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(JSONObject... params) {

            Controllers.postToDb("api/add-to-itinerary-details",params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject rt) {
            Intent i = new Intent(SpotActivity.this,PackageActivity.class);
            startActivity(i);
            super.onPostExecute(rt);
        }
    }
}
