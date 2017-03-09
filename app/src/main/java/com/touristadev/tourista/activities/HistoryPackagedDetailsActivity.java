package com.touristadev.tourista.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.touristadev.tourista.R;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.TourRequest;
import com.touristadev.tourista.utils.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HistoryPackagedDetailsActivity extends AppCompatActivity {
    private int position;
    private ImageView imgPackage;
    private TextView txtPackageName,txtNumberSpots,txtNumberHours,txtPackPrice,txtPackDesc,txtCompanyName;
    private RatingBar ratBar;
    private ListView mListViewItinerary;
    private Button btnEndTour,btnViewItinerary,btnCancel;
    private TourRequest pack = new TourRequest();
    private ArrayList<String> packItinerary = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_package_details);
        Intent i = getIntent();
        position = i.getIntExtra("position", 0);

        Log.d("History na","History na details");

        imgPackage = (ImageView) findViewById(R.id.imgPackage);
        txtPackageName = (TextView) findViewById(R.id.txtRequestPackageName);
        txtNumberSpots = (TextView) findViewById(R.id.txtRequestNumberSpot);
        txtNumberHours = (TextView) findViewById(R.id.txtRequestNumberHours);
        txtPackPrice = (TextView) findViewById(R.id.txtRequestPaymentForTG);
        txtPackDesc = (TextView) findViewById(R.id.txtRequestPackageName);
        txtCompanyName = (TextView) findViewById(R.id.txtRequestAgencyName);
        mListViewItinerary = (ListView) findViewById(R.id.PackageItineraryListView);

        btnViewItinerary= (Button) findViewById(R.id.btnViewItinerary);
        btnEndTour = (Button) findViewById(R.id.btnEndTour);
        btnCancel = (Button) findViewById(R.id.btnCancelTour);

        btnCancel.setVisibility(View.GONE);
        btnEndTour.setVisibility(View.GONE);
        pack = Controllers.TourRequestList.get(Controllers.bookedposition);

        btnEndTour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EndTourTask task= new EndTourTask();
                    task.execute();
                    Intent intent= new Intent(HistoryPackagedDetailsActivity.this, HistoryActivity.class);
                    startActivity(intent);

                }
            });

        btnViewItinerary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     ControllerFinal.RequestList.remove(position);
                Intent intent= new Intent(HistoryPackagedDetailsActivity.this, BookDetailsActivity.class);
                intent.putExtra("position",position);
                startActivity(intent);

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CancelTourTask task= new CancelTourTask();
                task.execute();
                Intent intent= new Intent(HistoryPackagedDetailsActivity.this,TGTourActivity.class);
                startActivity(intent);
            }
        });

        Glide.with(HistoryPackagedDetailsActivity.this).load(Controllers.TourRequestList.get(position).getPhotoPath())
                .into(imgPackage);
            txtPackageName.setText(pack.getPackageName());
            txtNumberSpots.setText(pack.getNumOfSpots()+" Spots");
            txtNumberHours.setText(pack.getTourDate());
            txtPackPrice.setText("Php "+pack.getPrice() + "for tour guide.");
            txtPackDesc.setText(pack.getDescription());
            txtCompanyName.setText("by"+pack.getAgencyName());

            packItinerary.clear();

        for (int x = 0; x < pack.getItenerary_details().size(); x++) {
            packItinerary.add(pack.getItenerary_details().get(x).getStartTime()+"\t\t\t\t "+pack.getItenerary_details().get(x).getEndTime()+"\t\t\t\t "+pack.getItenerary_details().get(x).getSpotName()+"\t\t\t\t");

        }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, packItinerary);
            mListViewItinerary.setAdapter(adapter);


            ListAdapter listAdapter1 = mListViewItinerary.getAdapter();
            if (listAdapter1 != null) {

                int numberOfItems = listAdapter1.getCount();

                // Get total height of all items.
                int totalItemsHeight = 0;
                for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                    View item = listAdapter1.getView(itemPos, null, mListViewItinerary);
                    item.measure(0, 0);
                    totalItemsHeight += item.getMeasuredHeight();
                }

                // Get total height of all item dividers.
                int totalDividersHeight = mListViewItinerary.getDividerHeight() *
                        (numberOfItems - 1);

                // Set list height.
                ViewGroup.LayoutParams params = mListViewItinerary.getLayoutParams();
                params.height = totalItemsHeight + totalDividersHeight;
                mListViewItinerary.setLayoutParams(params);
                mListViewItinerary.requestLayout();

            }
    }

    public class EndTourTask extends AsyncTask<Void, Void, String> {

        @Override
        protected  String doInBackground(Void... params) {
            JSONObject obj = new JSONObject();
            String jsonTG = "";
            try {

                obj.put("tourTransactionId", pack.getTourTransactionId());
                obj.put("guideId", Controllers.CurrentGT.getTGGuideID());
                obj.put("type", Controllers.TourBookedList.get(Controllers.bookedposition).getType());

            } catch (JSONException e) {
                e.printStackTrace();
            }

          //  HttpUtils.POST(Controllers.TGEndToourUrl, obj);

            return "";
        }

        protected void onPostExecute(String st) {

//            {"creditCardPassword": "12345678", "province": "Cebu", "isknowledgeable": "4.0000", "citizenship": "Filipino", "photoUrl": null, "expirationDateMonth": "January", "userId": "fqjGxEdbTRO8ufQRumkbaBk3Xg02", "contactNumber": "on hold", "rightpersonality": "4.0000", "EMAIL": "shael2008@yahoo.com", "ratings": 0, "expirationDateYear": "2017", "acts_professionaly": "4.0000", "priority": 10, "numAccept": 0, "streetAddress": "Oldog", "facebookId": "10202564070139378", "city": "Talisay", "guideId": "TG-fqjGxEdbTRO8ufQRumkbaBk3Xg02", "accountNumber": "200-200-200-200", "zipCode": "6045", "numRequest": 0, "PROFILE_DESCRIPTION": "ohla", "creditCardEmail": "shael2008@yahoo.com", "language": [], "firstName": "Shanyl", "cvv": "200", "lastName": "Jimenez", "expirationDateDay": "01", "birthday": "2016-02-11", "country": "Philippines"}

            Intent intent = new Intent(HistoryPackagedDetailsActivity.this, TGTourActivity.class);
            startActivity(intent);
        }

    }


    public class CancelTourTask extends AsyncTask<Void, Void, String> {

        @Override
        protected  String doInBackground(Void... params) {
            JSONObject obj = new JSONObject();
            String jsonTG = "";
            try {

                obj.put("tourTransactionId", pack.getTourTransactionId());
                obj.put("guideId", Controllers.CurrentGT.getTGGuideID());
                obj.put("type", Controllers.TourBookedList.get(Controllers.bookedposition).getType());

            } catch (JSONException e) {
                e.printStackTrace();
            }

            HttpUtils.POST(Controllers.TGCancelRequestUrl, obj);

            return "";
        }

        protected void onPostExecute(String st) {

//            {"creditCardPassword": "12345678", "province": "Cebu", "isknowledgeable": "4.0000", "citizenship": "Filipino", "photoUrl": null, "expirationDateMonth": "January", "userId": "fqjGxEdbTRO8ufQRumkbaBk3Xg02", "contactNumber": "on hold", "rightpersonality": "4.0000", "EMAIL": "shael2008@yahoo.com", "ratings": 0, "expirationDateYear": "2017", "acts_professionaly": "4.0000", "priority": 10, "numAccept": 0, "streetAddress": "Oldog", "facebookId": "10202564070139378", "city": "Talisay", "guideId": "TG-fqjGxEdbTRO8ufQRumkbaBk3Xg02", "accountNumber": "200-200-200-200", "zipCode": "6045", "numRequest": 0, "PROFILE_DESCRIPTION": "ohla", "creditCardEmail": "shael2008@yahoo.com", "language": [], "firstName": "Shanyl", "cvv": "200", "lastName": "Jimenez", "expirationDateDay": "01", "birthday": "2016-02-11", "country": "Philippines"}

            Intent intent = new Intent(HistoryPackagedDetailsActivity.this, TGTourActivity.class);
            startActivity(intent);
        }

    }
}
