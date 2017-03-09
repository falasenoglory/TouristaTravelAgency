package com.touristadev.tourista.algo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stripe.android.*;
import com.stripe.android.TokenCallback;
import com.stripe.android.exception.AuthenticationException;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.touristadev.tourista.R;

public class StripeActivity extends AppCompatActivity {

    public static String TestPublishableKey="pk_test_7QPl9BxtJxLvrggZQXHNytfP";
    public static String TestSecretKey="sk_test_hUakYB58uJWRdacl3yXehMw9";

    private EditText txtCreditCardNo;
    private EditText txtMonth;
    private EditText txtYear;
    private EditText txtCVC;
    private Button btnButton;

    private String cardNumber,cardCVC;
    private int cardExpMonth,cardExpYear;
    public static Token tokens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stripe);

        txtCreditCardNo=(EditText)findViewById(R.id.txtCreditCardNo);
        txtMonth=(EditText)findViewById(R.id.txtMonth);
        txtYear=(EditText)findViewById(R.id.txtYear);
        txtCVC=(EditText)findViewById(R.id.txtCVC);
        btnButton=(Button)findViewById(R.id.btnButton);

        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cardNumber=txtCreditCardNo.getText().toString();
                cardExpMonth=Integer.parseInt(txtMonth.getText().toString());
                cardExpYear=Integer.parseInt(txtYear.getText().toString());
                cardCVC=txtCVC.getText().toString();
                Card card = new Card(
                        cardNumber,
                        cardExpMonth,
                        cardExpYear,
                        cardCVC
                );
                card.validateNumber();
                card.validateCVC();

                if (!card.validateCard()) {
                    // Show errors
                    Toast.makeText(StripeActivity.this,"Credit card is invalid. Please Try Again.",
                            Toast.LENGTH_SHORT).show();
                }


                Stripe stripe=null;
                try {
                    stripe = new Stripe("pk_test_7QPl9BxtJxLvrggZQXHNytfP");
                    Toast.makeText(StripeActivity.this,"1",
                            Toast.LENGTH_SHORT).show();
                } catch (AuthenticationException e) {
                    e.printStackTrace();
                }
                stripe.createToken(
                        card,
                        new TokenCallback() {
                            public void onError(Exception error) {
                                // Show localized error message
                                Toast.makeText(StripeActivity.this,"Error in Token Callback.",
                                        Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onSuccess(Token token) {
                                tokens= token;
                            }
                        }
                );

                Toast.makeText(StripeActivity.this, tokens.toString(), Toast.LENGTH_LONG).show();


            }
        });

    }
}
