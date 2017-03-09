package com.touristadev.tourista.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.iid.FirebaseInstanceId;
import com.touristadev.tourista.R;
import com.touristadev.tourista.api.CurrentUser_API;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.utils.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RegisterFinalStepActivity extends AppCompatActivity {

    private String fname,lname,email,contactno,birthday,citizenship,country,city,province,steetaddress, profiedescription,facebookid,photoUrl,zipCode;
    private ArrayList<String> languages=new ArrayList<>();

    private EditText txtProfileDescription,txtZipCode;
    private CheckBox chcEnglish,chcFilipino,chcBicolano,chcChinese,chcJapanese,chcKorean,chcMandarin,chcNihonggo,chcTagalog,chcWaray;

    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_final_step);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarL);
        setSupportActionBar(toolbar);

        toolbar.setBackgroundColor(Color.parseColor("#fecd23"));
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

        txtProfileDescription=(EditText)findViewById(R.id.txtProfileDescript);
        txtZipCode=(EditText)findViewById(R.id.txtZipCode);

        chcEnglish=(CheckBox)findViewById(R.id.chcEnglish);
        chcFilipino=(CheckBox)findViewById(R.id.chcFilipino);
        chcBicolano=(CheckBox)findViewById(R.id.chcBicolano);
        chcChinese=(CheckBox)findViewById(R.id.chcChinese);
        chcJapanese=(CheckBox)findViewById(R.id.chcJapanese);
        chcKorean=(CheckBox)findViewById(R.id.chcKorean);
        chcMandarin=(CheckBox)findViewById(R.id.chcMandarin);
        chcNihonggo=(CheckBox)findViewById(R.id.chcNihonggo);
        chcTagalog=(CheckBox)findViewById(R.id.chcTagalog);
        chcWaray=(CheckBox)findViewById(R.id.chcWaray);

        btnSignUp=(Button) findViewById(R.id.btnRegister) ;

        Intent intent= getIntent();
        fname=intent.getStringExtra("firstname");
        lname=intent.getStringExtra("lastname");
        email=intent.getStringExtra("email");
        contactno=intent.getStringExtra("contactno");
        birthday=intent.getStringExtra("birthday");
        citizenship=intent.getStringExtra("citizenship");
        country=intent.getStringExtra("country");
        city=intent.getStringExtra("city");
        province=intent.getStringExtra("province");
        facebookid=intent.getStringExtra("facebookid");
        photoUrl=intent.getStringExtra("photoUrl");
        steetaddress=intent.getStringExtra("streetaddress");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("Shangwaps","RestinerFinalStepctivity, Signup");
                profiedescription=txtProfileDescription.getText().toString();
                zipCode=txtZipCode.getText().toString();

                if (chcEnglish.isChecked())
                {
                    languages.add("English");
                }
                if (chcFilipino.isChecked())
                {
                    languages.add("Filipino");
                }
                if (chcBicolano.isChecked())
                {
                    languages.add("Bicolano");
                }
                if (chcChinese.isChecked())
                {
                    languages.add("Chinese");
                }
                if (chcJapanese.isChecked())
                {
                    languages.add("Japanese");
                }
                if (chcKorean.isChecked())
                {
                    languages.add("Korean");
                }
                if (chcMandarin.isChecked())
                {
                    languages.add("Mandarin");
                }
                if (chcNihonggo.isChecked())
                {
                    languages.add("Nihonggo");
                }
                if (chcTagalog.isChecked())
                {
                    languages.add("Tagalog");
                }
                if (chcWaray.isChecked())
                {
                    languages.add("Waray");
                }

                CreateUserTask task= new CreateUserTask();
                task.execute();


            }
        });




    }



    public class CreateUserTask extends AsyncTask<String, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(String... params) {
            JSONObject obj = new JSONObject();
            JSONObject obj1 = new JSONObject();
            JSONArray arr=new JSONArray(languages);
            String jsonTG = "";
            try {
                obj.put("firstName", fname);
                obj.put("lastName", lname);
                obj.put("birthday", birthday);
                obj.put("email", email);
                obj.put("contactNumber", contactno);
                obj.put("facebookId",facebookid );
                obj.put("citizenship", citizenship);
                obj.put("photoUrl", photoUrl);
                obj.put("tourGuide", "True");
                obj.put("languages", arr);
                obj.put("streetAddress", steetaddress);
                obj.put("city", city);
                obj.put("firebaseInstanceIdToken", FirebaseInstanceId.getInstance().getToken());
                obj.put("country", country);
                obj.put("zipCode", zipCode);
                obj.put("province", province);
                obj.put("PROFILE_DESCRIPTION", profiedescription);

                Log.d("Shangwaps","RestinerFinalStepctivity, Asyc" +obj.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            jsonTG= HttpUtils.PLACE(Controllers.CreateTGUrl,"POST", obj,"login");
            //     Log.d("Shanyl","obj="+jsonTG.toString());
            try {
                obj1 = new JSONObject(jsonTG);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return obj1;
        }

        @Override
        protected void onPostExecute(JSONObject coa) {
            super.onPostExecute(coa);
            Controllers.CurrentGT= CurrentUser_API.getCurrentTourGuideList(coa);
            Log.d("Shanyl","GuideID sa Login: "+ Controllers.CurrentGT);

            Intent intent = new Intent(RegisterFinalStepActivity.this, RequestActivity.class);
            startActivity(intent);
//            {"creditCardPassword": "12345678", "province": "Cebu", "isknowledgeable": "4.0000", "citizenship": "Filipino", "photoUrl": null, "expirationDateMonth": "January", "userId": "fqjGxEdbTRO8ufQRumkbaBk3Xg02", "contactNumber": "on hold", "rightpersonality": "4.0000", "EMAIL": "shael2008@yahoo.com", "ratings": 0, "expirationDateYear": "2017", "acts_professionaly": "4.0000", "priority": 10, "numAccept": 0, "streetAddress": "Oldog", "facebookId": "10202564070139378", "city": "Talisay", "guideId": "TG-fqjGxEdbTRO8ufQRumkbaBk3Xg02", "accountNumber": "200-200-200-200", "zipCode": "6045", "numRequest": 0, "PROFILE_DESCRIPTION": "ohla", "creditCardEmail": "shael2008@yahoo.com", "language": [], "firstName": "Shanyl", "cvv": "200", "lastName": "Jimenez", "expirationDateDay": "01", "birthday": "2016-02-11", "country": "Philippines"}
        }
    }
}
