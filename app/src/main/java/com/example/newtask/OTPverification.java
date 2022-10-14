package com.example.newtask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OTPverification extends AppCompatActivity {
   private EditText inputcode1,inputcode2,inputcode3,inputcode4,inputcode5,inputcode6,
           mobilecode1,mobilecode2,mobilecode3,mobilecode4,mobilecode5,mobilecode6;
   private String verificationId;
  private Button verify;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

        TextView textmobile=findViewById(R.id.phonetext);
        textmobile.setText(String.format(
                "+91-%s",getIntent().getStringExtra("mobile")
        ));
//        TextView textemail=findViewById(R.id.emailtext);
//        textemail.setText(getIntent().getStringExtra("email"));



//
//        inputcode1=findViewById(R.id.input_code1);
//        inputcode2=findViewById(R.id.input_code2);
//        inputcode3=findViewById(R.id.input_code3);
//        inputcode4=findViewById(R.id.input_code4);
//        inputcode5=findViewById(R.id.input_code5);
//        inputcode6=findViewById(R.id.input_code6);

        mobilecode1=findViewById(R.id.number_code1);
        mobilecode2=findViewById(R.id.number_code2);
        mobilecode3=findViewById(R.id.number_code3);
        mobilecode4=findViewById(R.id.number_code4);
        mobilecode5=findViewById(R.id.number_code5);
        mobilecode6=findViewById(R.id.number_code6);

        setupOTPInputs();

        final ProgressBar progressBar=findViewById(R.id.progressverify);
       verify=findViewById(R.id.verify);

        verificationId=getIntent().getStringExtra("verificationId");

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (
//                        inputcode1.getText().toString().trim().isEmpty()
//                    || inputcode2.getText().toString().trim().isEmpty()
//                    || inputcode3.getText().toString().trim().isEmpty()
//                    || inputcode4.getText().toString().trim().isEmpty()
//                    || inputcode5.getText().toString().trim().isEmpty()
//                    || inputcode6.getText().toString().trim().isEmpty()
                     mobilecode1.getText().toString().trim().isEmpty()
                    || mobilecode2.getText().toString().trim().isEmpty()
                    || mobilecode3.getText().toString().trim().isEmpty()
                    || mobilecode4.getText().toString().trim().isEmpty()
                    || mobilecode5.getText().toString().trim().isEmpty()
                    || mobilecode6.getText().toString().trim().isEmpty()){
                    Toast.makeText(OTPverification.this, "please enter valid code", Toast.LENGTH_SHORT).show();
                    return;
                }
                String code=
                        mobilecode1.getText().toString() +
                                mobilecode2.getText().toString()+
                                mobilecode3.getText().toString()+
                                mobilecode4.getText().toString()+
                                mobilecode5.getText().toString()+
                                mobilecode6.getText().toString();

                if (verificationId !=null){
                    progressBar.setVisibility(View.VISIBLE);
                    verify.setVisibility(View.INVISIBLE);
                    PhoneAuthCredential phoneAuthCredential= PhoneAuthProvider.getCredential(
                            verificationId,code
                    );
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    verify.setVisibility(View.VISIBLE);
                                    if (task.isSuccessful()){
                                        Intent intent=new Intent(getApplicationContext(),Welcome.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    }else {
                                        Toast.makeText(OTPverification.this, "The verification code entered was invalid", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                }
            }
        });

    }
    private void setupOTPInputs(){
//        inputcode1.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
//                if (!s.toString().trim().isEmpty()){
//                    inputcode2.requestFocus();
//
//                }
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//        inputcode2.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
//                if (!s.toString().trim().isEmpty()){
//                    inputcode3.requestFocus();
//                }
//            }
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//        inputcode3.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
//                if (!s.toString().trim().isEmpty()){
//                    inputcode4.requestFocus();
//                }
//            }
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//        inputcode4.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
//                if (!s.toString().trim().isEmpty()){
//                    inputcode5.requestFocus();
//                }
//            }
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//        inputcode5.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
//                if (!s.toString().trim().isEmpty()){
//                    inputcode6.requestFocus();
//                }
//            }
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });

        mobilecode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty()){
                    mobilecode2.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mobilecode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty()){
                    mobilecode3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mobilecode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty()){
                    mobilecode4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mobilecode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty()){
                    mobilecode5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mobilecode5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty()){
                    mobilecode6.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}