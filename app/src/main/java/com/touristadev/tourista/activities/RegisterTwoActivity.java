package com.touristadev.tourista.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.touristadev.tourista.R;

public class RegisterTwoActivity extends AppCompatActivity {

    private EditText txtFirstName, txtLastName, txtEmailAddres, txtContactnumber,txtBirthDate,txtCitizenship
            ,txtCountry, txtCity,txtprovince,txtStreetAddress;
    private Button btnNext;


    private String fname,lname,email,contactno,birthday,citizenship,country,city,province,streetaddress,facebookid,photoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registertg);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarL);
        setSupportActionBar(toolbar);

        toolbar.setBackgroundColor(Color.parseColor("#fecd23"));
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

        txtFirstName=(EditText) findViewById(R.id.txtZipCode);
        txtLastName=(EditText) findViewById(R.id.txtLastName);
        txtEmailAddres=(EditText) findViewById(R.id.txtAddress);
        txtContactnumber=(EditText) findViewById(R.id.txtContactNumber);
        txtBirthDate=(EditText)findViewById(R.id.txtBirthdate);
        txtCitizenship=(EditText)findViewById(R.id.txtCitizenship);
        txtCountry=(EditText)findViewById(R.id.txtCountry);
        txtCity=(EditText)findViewById(R.id.txtCity);
        txtprovince=(EditText)findViewById(R.id.txtProvince);
        txtStreetAddress=(EditText)findViewById(R.id.txtStreetAddress);

        btnNext=(Button)findViewById(R.id.btnRegisterNext);

        Intent intent=getIntent();
        fname=intent.getStringExtra("firstName");
        lname=intent.getStringExtra("lastName");
        email=intent.getStringExtra("email");
        facebookid=intent.getStringExtra("facebookid");
        photoUrl=intent.getStringExtra("photoUrl");

        Log.d("Shangwaps",fname+" "+lname+" "+facebookid);

        txtFirstName.setText(fname);
        txtLastName.setText(lname);
        txtEmailAddres.setText(email);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fname=txtFirstName.getText().toString();
                lname=txtLastName.getText().toString();
                email=txtEmailAddres.getText().toString();
                contactno=txtContactnumber.getText().toString();
                birthday=txtBirthDate.getText().toString();
                citizenship=txtCitizenship.getText().toString();
                country=txtCountry.getText().toString();
                city=txtCity.getText().toString();
                province=txtprovince.getText().toString();
                streetaddress=txtStreetAddress.getText().toString();

                Log.d("Shangwaps","RestinerTwoActivity, next");
                Intent intent1= new Intent(RegisterTwoActivity.this,RegisterFinalStepActivity.class);
                intent1.putExtra("firstname",fname);
                intent1.putExtra("lastname",lname);
                intent1.putExtra("email",email);
                intent1.putExtra("contactno",contactno);
                intent1.putExtra("birthday",birthday);
                intent1.putExtra("citizenship",citizenship);
                intent1.putExtra("country",country);
                intent1.putExtra("city",city);
                intent1.putExtra("facebookid",facebookid);
                intent1.putExtra("photoUrl",photoUrl);
                intent1.putExtra("province",province);
                intent1.putExtra("streetaddress",streetaddress);
                startActivity(intent1);
            }
        });


    }
}
