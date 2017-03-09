package com.touristadev.tourista.activities;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.touristadev.tourista.R;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.CurrentUser;
import com.touristadev.tourista.utils.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileDescriptor;
import java.io.IOException;

public class QRCodeActivity extends AppCompatActivity {
    private ImageView imgQRcode;
    private Button btnDecode;
    private String user = null;
    private TextView txtPoints;
    private String api = "api/use/qr/code";
    private String refCode;

    private static int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        imgQRcode = (ImageView) findViewById(R.id.imgQRcode);
        txtPoints = (TextView) findViewById(R.id.textView2);
        final QRCodeWriter writer = new QRCodeWriter();
        final QRCodeReader reader = new QRCodeReader();

        imgQRcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        btnDecode = (Button) findViewById(R.id.btnDecode);
        btnDecode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bMap = ((BitmapDrawable)imgQRcode.getDrawable()).getBitmap();
                int[] intArray = new int[bMap.getWidth()*bMap.getHeight()];
                //copy pixel data from the Bitmap into the 'intArray' array
                bMap.getPixels(intArray, 0, bMap.getWidth(), 0, 0, bMap.getWidth(), bMap.getHeight());

                LuminanceSource source = new RGBLuminanceSource(bMap.getWidth(), bMap.getHeight(), intArray);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                Reader reader = new MultiFormatReader();// use this otherwise ChecksumException
                try {
                    Result result = reader.decode(bitmap);
                    refCode = result.getText();
                    Log.d("QRCodeChan",refCode);
                    txtPoints.setText("Current Points: "+Controllers.getReferralPoints()+"");
                    JSONObject obj = new JSONObject();
                    try {
                        obj.put("code_qr", refCode+"");
                        obj.put("userId",CurrentUser.userFirebaseId);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    QRCodeActivity.ConsumeQR pr= new QRCodeActivity.ConsumeQR();
                    pr.execute(obj);
                    //byte[] rawBytes = result.getRawBytes();
                    //BarcodeFormat format = result.getBarcodeFormat();
                    //ResultPoint[] points = result.getResultPoints();
                } catch (NotFoundException e) { e.printStackTrace();

                    Log.d("QRCodeChan","NotFound "+e);}
                catch (ChecksumException e) { e.printStackTrace();

                    Log.d("QRCodeChan","CheckSum "+refCode);}
                catch (FormatException e) { e.printStackTrace();

                    Log.d("QRCodeChan","FormatException "+refCode);}
            }
        });


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



            Bitmap bmp = null;
            try {
                bmp = getBitmapFromUri(selectedImage);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            imgQRcode.setImageBitmap(bmp);

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
    public class ConsumeQR extends AsyncTask<JSONObject, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(JSONObject... params) {


            HttpUtils.PLACE("http://192.168.1.5:8000/"+api,"POST",params[0],"qr");
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject rt) {

            if(Controllers.Getresponse().equals("Success")){

                txtPoints.setText("Equivalent Points"+Controllers.gettemppoints()+"");
            }
            else{
                txtPoints.setText(Controllers.Getresponse());
            }
            super.onPostExecute(rt);
        }
    }

}
