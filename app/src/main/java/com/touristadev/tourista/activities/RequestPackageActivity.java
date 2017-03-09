package com.touristadev.tourista.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.touristadev.tourista.R;
import com.touristadev.tourista.utils.HttpUtils;

public class RequestPackageActivity extends AppCompatActivity {

    public static final String POST_URL_TOUR_TRANSACTION= "http://172.17.0.94:8000/api/book-package";
    private TextView txtResponse;
    private Button btnRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_package);

        txtResponse=(TextView) findViewById(R.id.txtRespose);
        btnRequest=(Button) findViewById(R.id.btnRequest);

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String re=  "userId=44f1315cde514ad0a85b&"+
                        "packageId=1dfcf4fc&"+
                        "reserveDate=2017-01-31&"+
                        "tourDate=2017-02-09&"+
                        "numOfPeople=10&"+
                        "status=Request";
                POSTRequestPackage pr= new POSTRequestPackage();
                pr.execute(re);
            }
        });




    }

    public class POSTRequestPackage extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpUtils.POST(POST_URL_TOUR_TRANSACTION, params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(String rt) {
            txtResponse.setText("done!");
            super.onPostExecute(rt);
        }
    }
}
