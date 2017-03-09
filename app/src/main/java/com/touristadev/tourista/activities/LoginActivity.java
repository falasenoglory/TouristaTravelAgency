package com.touristadev.tourista.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.messaging.FirebaseMessaging;
import com.touristadev.tourista.R;
import com.touristadev.tourista.api.CurrentTravelAgency_API;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.utils.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSignIn, mSignUp;
    private EditText email, password;
    private String currentUser;
    public String sEmail, sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login);

        FirebaseMessaging.getInstance().subscribeToTopic("news");

        //FONTS
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/Poppins-Bold.ttf");
        mSignIn = (Button) findViewById(R.id.btnLogin);
        mSignIn.setTypeface(myCustomFont);
        mSignUp= (Button) findViewById(R.id.btnCreateAccount) ;

        email = (EditText) findViewById(R.id.agencyEmail);
        password  = (EditText) findViewById(R.id.agencyPassword);


        mSignIn.setOnClickListener(this);
        mSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnLogin:
                login();
                break;
            case R.id.btnCreateAccount:
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
        }

    }

    public void login() {
        sEmail = email.getText().toString();
        sPassword = password.getText().toString();
        new FetchCurrentUser().execute("");


    }

    public class FetchCurrentUser extends AsyncTask<String, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(String... params) {
            JSONObject obj = new JSONObject();
            JSONObject obj1 = new JSONObject();
            String json = "";
            try {
                obj.put("email", sEmail);
                obj.put("password", sPassword);
                obj.put("type", "TA");
                json = HttpUtils.POST(Controllers.CurrentUserAuthenticationUrl, obj);
                Log.d("Boholst", json);
                obj1 = new JSONObject(json);
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("Boholst", e+"");
            }
            catch (NullPointerException e)
            {

            }
            return obj1;

        }

        @Override
        protected void onPostExecute(JSONObject coa) {
            super.onPostExecute(coa);
            CurrentTravelAgency_API.setTravelAgency(coa);
            Log.d("Boholst", "coa=" +coa.toString());
            Intent intent = new Intent(LoginActivity.this, PackageActivity.class);
            startActivity(intent);
//            {"creditCardPassword": "12345678", "province": "Cebu", "isknowledgeable": "4.0000", "citizenship": "Filipino", "photoUrl": null, "expirationDateMonth": "January", "userId": "fqjGxEdbTRO8ufQRumkbaBk3Xg02", "contactNumber": "on hold", "rightpersonality": "4.0000", "EMAIL": "shael2008@yahoo.com", "ratings": 0, "expirationDateYear": "2017", "acts_professionaly": "4.0000", "priority": 10, "numAccept": 0, "streetAddress": "Oldog", "facebookId": "10202564070139378", "city": "Talisay", "guideId": "TG-fqjGxEdbTRO8ufQRumkbaBk3Xg02", "accountNumber": "200-200-200-200", "zipCode": "6045", "numRequest": 0, "PROFILE_DESCRIPTION": "ohla", "creditCardEmail": "shael2008@yahoo.com", "language": [], "firstName": "Shanyl", "cvv": "200", "lastName": "Jimenez", "expirationDateDay": "01", "birthday": "2016-02-11", "country": "Philippines"}
        }
    }


}