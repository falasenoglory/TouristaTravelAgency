package com.touristadev.tourista.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.touristadev.tourista.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mRegister;
    private CallbackManager mCallbackManager;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private AccessToken currentAccessToken;

    private String firstName;
    private String lastName;
    private String email;
    private String facebookId;
    private String photoUrl;

    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_register);


        //FONTS
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/Poppins-Bold.ttf");

        mCallbackManager = CallbackManager.Factory.create();

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //A user is signed in
                } else {
                    //A user is not signed in
                }
            }
        };
        mRegister = (Button) findViewById(R.id.btnRegister);
        mRegister.setTypeface(myCustomFont);
        mRegister.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnRegister:
                login();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void handleFacebookAccessToken(AccessToken token) {
        final String userID = token.getUserId();
        Log.d("Shangwaps",token.toString());
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            //do nothing
                        } else {
                            photoUrl = task.getResult().getUser().getPhotoUrl().toString();
                            Intent intent = new Intent(RegisterActivity.this, RegisterTwoActivity.class);
                            intent.putExtra("firstName", firstName);
                            intent.putExtra("lastName", lastName);
                            intent.putExtra("email", email);
                            intent.putExtra("facebookid",facebookId);
                            intent.putExtra("photoUrl",photoUrl);
                            Log.d("Shangwaps",firstName+" "+lastName+" "+facebookId);
                            startActivity(intent);
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void login() {
        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(final LoginResult loginResult) {
                        currentAccessToken = loginResult.getAccessToken();
                        handleFacebookAccessToken(currentAccessToken);
                        GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                try {
                                    firstName = object.getString("first_name");
                                    lastName = object.getString("last_name");
                                    email = object.getString("email");
                                    facebookId = currentAccessToken.getUserId();
                                    Log.d("Boholst",firstName + " " + lastName + " " + email + " " + facebookId);
                                    Toast.makeText(getApplicationContext(), "Welcome! " + firstName, Toast.LENGTH_SHORT).show();
                                } catch (JSONException e) {
                                    Log.d("Boholst", "Exception " +e.getMessage());
                                }
                            }
                        });

                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "first_name,last_name,email,birthday");
                        graphRequest.setParameters(parameters);
                        graphRequest.executeAsync();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "Login Cancel", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "user_friends", "email"));
    }
}
