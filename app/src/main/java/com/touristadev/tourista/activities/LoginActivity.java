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
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.touristadev.tourista.R;
import com.touristadev.tourista.api.CurrentUser_API;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.utils.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSignIn, mSignUp;
    private CallbackManager mCallbackManager;
    private String currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_login);

        FirebaseMessaging.getInstance().subscribeToTopic("news");

        //FONTS
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/Poppins-Bold.ttf");
        mSignIn = (Button) findViewById(R.id.btnLogin);
        mSignIn.setTypeface(myCustomFont);
        mSignUp= (Button) findViewById(R.id.btnCreateAccount) ;


        mSignIn.setOnClickListener(this);
        mSignUp.setOnClickListener(this);


        mCallbackManager = CallbackManager.Factory.create();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnLogin:
                login();
                break;
            case R.id.btnCreateAccount:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void login() {
        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(final LoginResult loginResult) {
                        currentUser=loginResult.getAccessToken().getUserId();
                        FetchCurrentUser task = new FetchCurrentUser();
                        task.execute(currentUser);

                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "Login Cancel", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
                        if (exception instanceof FacebookAuthorizationException) {
                            if (AccessToken.getCurrentAccessToken() != null) {
                                LoginManager.getInstance().logOut();
                            }
                        }
                    }
                });
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "user_friends", "email"));
    }

    public class FetchCurrentUser extends AsyncTask<String, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(String... params) {
            JSONObject obj = new JSONObject();
            JSONObject obj1 = new JSONObject();
            String jsonTG = "";
            try {
                obj.put("userId", currentUser);
                obj.put("type", "TG");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            jsonTG= HttpUtils.PLACE(Controllers.CurrentUserAuthenticationUrl,"POST", obj,"login");
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
            Controllers.CurrentGT=CurrentUser_API.getCurrentTourGuideList(coa);
            Log.d("Shanyl","GuideID sa Login: "+ Controllers.CurrentGT);

            Intent intent = new Intent(LoginActivity.this, RequestActivity.class);
            startActivity(intent);
//            {"creditCardPassword": "12345678", "province": "Cebu", "isknowledgeable": "4.0000", "citizenship": "Filipino", "photoUrl": null, "expirationDateMonth": "January", "userId": "fqjGxEdbTRO8ufQRumkbaBk3Xg02", "contactNumber": "on hold", "rightpersonality": "4.0000", "EMAIL": "shael2008@yahoo.com", "ratings": 0, "expirationDateYear": "2017", "acts_professionaly": "4.0000", "priority": 10, "numAccept": 0, "streetAddress": "Oldog", "facebookId": "10202564070139378", "city": "Talisay", "guideId": "TG-fqjGxEdbTRO8ufQRumkbaBk3Xg02", "accountNumber": "200-200-200-200", "zipCode": "6045", "numRequest": 0, "PROFILE_DESCRIPTION": "ohla", "creditCardEmail": "shael2008@yahoo.com", "language": [], "firstName": "Shanyl", "cvv": "200", "lastName": "Jimenez", "expirationDateDay": "01", "birthday": "2016-02-11", "country": "Philippines"}
        }
    }


}