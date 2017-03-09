package com.touristadev.tourista.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.touristadev.tourista.R;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.TravelAgency;
import com.touristadev.tourista.utils.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mSignUpTG;
    private EditText agencyName;
    private EditText streetAddress;
    private EditText city;
    private EditText country;
    private EditText zipCode;
    private EditText contactNumber;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mSignUpTG = (Button)findViewById(R.id.createTravelAgency);
        agencyName = (EditText)findViewById(R.id.travelAgencyName);
        streetAddress = (EditText)findViewById(R.id.streetAddress);
        city = (EditText)findViewById(R.id.city);
        country = (EditText)findViewById(R.id.country);
        zipCode = (EditText)findViewById(R.id.zipCode);
        contactNumber = (EditText)findViewById(R.id.contactNumber);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        mSignUpTG.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.createTravelAgency:{
                JSONObject jsonObject = new JSONObject();
                TravelAgency travelAgency = new TravelAgency(agencyName.getText().toString(), streetAddress.getText().toString(),
                        city.getText().toString(), country.getText().toString(), zipCode.getText().toString(),
                        contactNumber.getText().toString(), email.getText().toString(), password.getText().toString());
                try {
                    jsonObject = new JSONObject(travelAgency.toString());
                    new CreateTavelAgencyTask().execute(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                break;
            }
            default:{

            }
        }
    }

    public class CreateTavelAgencyTask extends AsyncTask<JSONObject, Void, String>{

        @Override
        protected String doInBackground(JSONObject... jsonObjects) {
            return HttpUtils.POST(Controllers.CREATE_TRAVEL_AGENCY_URL, jsonObjects[0]);
        }


    }
}
