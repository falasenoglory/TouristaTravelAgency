package com.touristadev.tourista.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.share.ShareApi;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.touristadev.tourista.R;
import com.touristadev.tourista.dataModels.CurrentUser;
import com.touristadev.tourista.utils.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class ReferralCodeActivity extends AppCompatActivity {

    private String tourId;
    private ImageView qrCode;
    private Button btnShare,btnOkay;

    final QRCodeWriter writer = new QRCodeWriter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referral_code);
        Intent i = getIntent();
        tourId = i.getStringExtra("tourId");
        qrCode = (ImageView) findViewById(R.id.imgQRcode);
        try {
            BitMatrix bitMatrix = writer.encode(tourId, BarcodeFormat.QR_CODE, 512, 512);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
            qrCode.setImageBitmap(bmp);

        } catch (WriterException e) {
            e.printStackTrace();
        }
        btnShare = (Button) findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Bitmap bitmap = ((BitmapDrawable)qrCode.getDrawable()).getBitmap();
                SharePhoto photo = new SharePhoto.Builder()
                        .setBitmap(bitmap)
                        .build();
                SharePhotoContent content = new SharePhotoContent.Builder()
                        .addPhoto(photo)
                        .build();
                ShareApi.share(content,null);
                ShareDialog.show(ReferralCodeActivity.this,content);
                JSONObject jobj = new JSONObject();
                try {
                    jobj.put("code_qr", tourId);
                    jobj.put("discount", "50");
                    jobj.put("userId", CurrentUser.userFirebaseId);
                } catch (JSONException e) {
                    e.printStackTrace();

                    Log.d("PasDetailsChnnix", e+"");
                }
             PostQRcode pc = new PostQRcode();
                pc.execute(jobj);
            }
        });
        btnOkay = (Button) findViewById(R.id.btnOk);
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(ReferralCodeActivity.this,HistoryActivity.class);
                startActivity(e);
            }
        });

    }
    public static class PostQRcode extends AsyncTask<JSONObject, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(JSONObject... params) {

            HttpUtils.PLACE("http://192.168.1.5:8000/api/add/qr/code","POST",params[0],"qrcode");
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject rt) {

            super.onPostExecute(rt);
        }
    }
}
