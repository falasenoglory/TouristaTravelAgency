package com.touristadev.tourista.algo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.touristadev.tourista.R;
import com.touristadev.tourista.controllers.Controllers;

public class TourGuideRecommendationActivity extends AppCompatActivity {

    private TextView txtOutput;
    private Button btnGo;
    Controllers con= new Controllers();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_guide_recommendation);

        txtOutput= (TextView)findViewById(R.id.txtOutput);
        btnGo= (Button)findViewById(R.id.btnGo);


        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Controllers con= new Controllers();
              //  txtOutput.setText(con.getRecommendedTG("Cebu","English"));
                btnGo.setEnabled(false);
            }
        });




    }

}
