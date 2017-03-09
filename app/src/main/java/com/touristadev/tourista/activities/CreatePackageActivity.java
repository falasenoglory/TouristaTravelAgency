package com.touristadev.tourista.activities;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.touristadev.tourista.R;
import com.touristadev.tourista.adapters.ListViewItineraryAdaper;
import com.touristadev.tourista.api.CurrentTravelAgency_API;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.CustomizedPackage;
import com.touristadev.tourista.dataModels.Itinerary;
import com.touristadev.tourista.dataModels.Spots;
import com.touristadev.tourista.dataModels.SpotsPackage;
import com.touristadev.tourista.dataModels.TourPackage;
import com.touristadev.tourista.dataModels.TouristaPackages;
import com.touristadev.tourista.dataModels.listViewPackItinerary;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import static com.touristadev.tourista.R.mipmap.ic_launcher;

public class CreatePackageActivity extends AppCompatActivity {

    private ImageView imgImage;
    private TextView  txtDesc;
    private MaterialSpinner spnTourGuides;
    private MaterialEditText edtPackname,edtDys,edtMinNumPax;
    private EditText  edtprice;
    private ListView listView;
    private Button btnCreate,btnAdd;
    private String spinValue;

    private static int RESULT_LOAD_IMAGE = 1;
    private String pos;
    private String status = "create";
    private ListView mListViewItinerary;
    private TourPackage customData = new TourPackage();
    private ArrayList<listViewPackItinerary> packItinerary = new ArrayList<>();
    private String encodedImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_package);

        Intent i = getIntent();
        status = i.getStringExtra("status");
        imgImage = (ImageView) findViewById(R.id.imgImage);
        txtDesc = (TextView) findViewById(R.id.txtDesc);
        spnTourGuides = (MaterialSpinner) findViewById(R.id.spnTourGuides);
        edtPackname = (MaterialEditText) findViewById(R.id.txtPackName);
        edtDys = (MaterialEditText) findViewById(R.id.txtDays);
        edtMinNumPax = (MaterialEditText) findViewById(R.id.txtMinNumPax);
        edtprice = (EditText) findViewById(R.id.txtPrice);
        listView = (ListView) findViewById(R.id.PackageItineraryListView);
        btnCreate = (Button) findViewById(R.id.btnBook);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        imgImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        pos = "0" ;
        if(status.equals("details")){
            pos = i.getStringExtra("pos");
            imgImage.setEnabled(false);
            txtDesc.setEnabled(false);
            txtDesc.setFocusable(false);
            spnTourGuides.setEnabled(false);
            edtPackname.setEnabled(false);

            edtPackname.setFocusable(false);
            edtPackname.setClickable(false);
            edtPackname.setFocusableInTouchMode(false);
            edtDys.setEnabled(false);
            edtDys.setFocusable(false);
            edtDys.setClickable(false);
            edtDys.setFocusableInTouchMode(false);
            edtMinNumPax.setEnabled(false);
            edtMinNumPax.setFocusable(false);
            edtMinNumPax.setClickable(false);
            edtMinNumPax.setFocusableInTouchMode(false);
            edtprice.setEnabled(false);
            edtprice.setFocusable(false);
            edtprice.setClickable(false);
            edtprice.setFocusableInTouchMode(false);
        }
        spnTourGuides.setItems("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

        spnTourGuides.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                spinValue = item;

            }
        });


        customData = Controllers.PackageList.get(Integer.parseInt(pos));
        for (int x = 0; x < customData.getSpots().size(); x++) {
            packItinerary.add(new listViewPackItinerary(customData.getSpots().get(x).startTime + "\t\t\t\t " + customData.getSpots().get(x).endTime + "\t\t\t\t " + customData.getSpots().get(x).SPOTNAME + "\t\t\t\t", 2, pos));

        }
        ListViewItineraryAdaper adapter = new ListViewItineraryAdaper(this, R.layout.listview_itinerary, packItinerary);
        mListViewItinerary = (ListView) findViewById(R.id.PackageItineraryListView);
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
//        }
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                Intent i = new Intent (CreatePackageActivity.this,SpotsFeedActivity.class);
                    startActivity(i);
                }
            });

        }}
    public class PostCreatePackage extends AsyncTask<JSONObject, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(JSONObject... params) {

            Log.d("CreatePackageChann", "Chhnnix2   ");
            Controllers.postToDb("api/create-package",params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject rt) {
            Log.d("CreatePackageChann", "Chhnnix3");
            super.onPostExecute(rt);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu); //your file name
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            Bitmap bm = BitmapFactory.decodeFile(picturePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
            byte[] b = baos.toByteArray();
            encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
            Bitmap bmp = null;
            try {
                bmp = getBitmapFromUri(selectedImage);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            imgImage.setImageBitmap(bmp);

        }


    }



    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:

                Log.d("CreatePackageChann", "Chhnnix");
                JSONObject obj = new JSONObject();
                if(status.equals("create")){
                try {
                    obj.put("packageName ",edtPackname.getText()+"");
                    obj.put("travelAgencyId ", CurrentTravelAgency_API.travelAgencyId);
                   obj.put("payment ",edtprice.getText()+"");
                    obj.put("numOfTGNeeded ",spinValue+"");
                    obj.put("description ",spinValue+"");
                    obj.put("minPeople ",edtMinNumPax.getText()+"");
                    obj.put("numOfDays ",edtDys.getText()+"");
                    obj.put("image",encodedImage);
                } catch (JSONException e) {

                    Log.d("CreatePackageChann", e+"");
                }
                PostCreatePackage pr= new PostCreatePackage();
                pr.execute(obj);}
                else{
                    Log.d("CustomPackageChan", "Sud!Create1 :");
                    ArrayList<SpotsPackage> temp2 = new ArrayList<>();
                    temp2 =  Controllers.PackageList.get(Integer.parseInt(pos)).getSpots();

                    ArrayList<SpotsPackage> temp = new ArrayList<>();



                    Spots curspot = new Spots();
                    Log.d("CustomPackageChan",Controllers.PackageList.get(Integer.parseInt(pos)).getSpots().size()+"");
                    TourPackage cust = new TourPackage(Controllers.PackageList.get(Integer.parseInt(pos)).getPackageId(), edtPackname.getText().toString(), CurrentTravelAgency_API.travelAgencyId, Float.parseFloat(edtprice.getText().toString()),Integer.parseInt(spinValue), Float.parseFloat(String.valueOf(0)), txtDesc.getText().toString(), edtDys.getText().toString(),Controllers.PackageList.get(Integer.parseInt(pos)).getSpots().size(),Integer.parseInt(edtMinNumPax.getText().toString()),encodedImage,"lol",temp,Controllers.PackageList.get(Integer.parseInt(pos)).getTgpayment());
//                    JSONArray jAr = new JSONArray();
//                    for(int l = 0; l <cust.getPackageItinerary().size();l++){
//                        JSONObject jes = new JSONObject();
//                        try {
//                            jes.put("chronology",l);
//                            jes.put("spotId",cust.getSpotItinerary().get(l).getSpotID());
//                            jes.put("startTime",cust.getSpotItinerary().get(l).getSpotOpeningTime());
//                            jes.put("packageId",cust.getPackageId());
//                            jes.put("spotName",cust.getSpotItinerary().get(l).getSpotName());
//                            jes.put("LATITUDE",cust.getSpotItinerary().get(l).getSpotLocationLat());
//                            jes.put("endTime",cust.getSpotItinerary().get(l).getSpotClosingTime());
//                            jes.put("LONGITUDE",cust.getSpotItinerary().get(l).getSpotLocationLong());
//                            jes.put("description",cust.getSpotItinerary().get(l).getSpotDescription());
//                        } catch (JSONException e) {
//                            Log.d("CustomPackageChan",e+" CustomSpotJSONException");
//                        }
//                        jAr.put(jes);
//                    }
                    JSONObject obj2 = new JSONObject();
                    try {
                        obj2.put("packageId", cust.getPackageId());
                        obj2.put("packageName", cust.getPackageName());
                        obj2.put("travelAgencyId", CurrentTravelAgency_API.travelAgencyId);
                        obj2.put("payment", cust.getPayment());
                        obj2.put("numOfTGNeeded", cust.getNumOfTGNeeded());
                        obj2.put("description",cust.getDescription());
                        obj2.put("minPeople",cust.getMinPeople()+"");
                        obj2.put("category","non");
                        obj2.put("tgpayment",cust.getTgpayment());

                    } catch (JSONException e) {

                        Log.d("CustomPackageChan",e+" CustomPackageJSONException");
                        e.printStackTrace();
                    }
                    CreatePackageActivity.EditCustom pr = new CreatePackageActivity.EditCustom();
                    pr.execute(obj2);
                }

                return true;
            case R.id.edit:

                imgImage.setEnabled(true);
                txtDesc.setEnabled(true);
                txtDesc.setFocusable(true);
                spnTourGuides.setEnabled(true);
                edtPackname.setEnabled(true);

                edtPackname.setFocusable(true);
                edtPackname.setClickable(true);
                edtPackname.setFocusableInTouchMode(true);
                edtDys.setEnabled(true);
                edtDys.setFocusable(true);
                edtDys.setClickable(true);
                edtDys.setFocusableInTouchMode(true);
                edtMinNumPax.setEnabled(true);
                edtMinNumPax.setFocusable(true);
                edtMinNumPax.setClickable(true);
                edtMinNumPax.setFocusableInTouchMode(true);
                edtprice.setEnabled(true);
                edtprice.setFocusable(true);
                edtprice.setClickable(true);
                edtprice.setFocusableInTouchMode(true);

                return true;
            case R.id.delete:
                JSONObject obj2 = new JSONObject();
                try {
                    obj2.put("packageId", Controllers.PackageList.get(Integer.parseInt(pos)).getPackageId());

                } catch (JSONException e) {

                    Log.d("CustomPackageChan",e+" CustomPackageJSONException");
                    e.printStackTrace();
                }
                CreatePackageActivity.DeletePckage pr = new CreatePackageActivity.DeletePckage();
                pr.execute(obj2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public class EditCustom extends AsyncTask<JSONObject, Void, String> {

        @Override
        protected String doInBackground(JSONObject... params) {

            Controllers.postToDb("api/update/package",params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(String rt) {
            Intent i = new Intent(CreatePackageActivity.this, PackageActivity.class);
            startActivity(i);
            super.onPostExecute(rt);
        }
    }  public class DeletePckage extends AsyncTask<JSONObject, Void, String> {

        @Override
        protected String doInBackground(JSONObject... params) {

            Controllers.postToDb("api/update/package",params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(String rt) {
            Intent i = new Intent(CreatePackageActivity.this, PackageActivity.class);
            startActivity(i);
            super.onPostExecute(rt);
        }
    }
}
