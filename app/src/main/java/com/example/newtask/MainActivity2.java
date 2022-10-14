package com.example.newtask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity2 extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mAuth=FirebaseAuth.getInstance();


        final EditText firstname=findViewById(R.id.firstname);
        final EditText lastname=findViewById(R.id.lastname);

         email=findViewById(R.id.emailaddress);
         password=findViewById(R.id.Password);

        final EditText inputmobile=findViewById(R.id.phonenumber);
        final Button buttongetotp=findViewById(R.id.registerbutton);

        final ProgressBar progressBar=findViewById(R.id.progressbar);

        buttongetotp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

//


                if (inputmobile.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity2.this, "Enter mobile", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (firstname.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity2.this, "Enter first name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (lastname.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity2.this, "Enter last name", Toast.LENGTH_SHORT).show();
                    return;
                }
//

                progressBar.setVisibility(View.VISIBLE);
                buttongetotp.setVisibility(View.INVISIBLE);


                PhoneAuthProvider.getInstance().verifyPhoneNumber("+91" + inputmobile.getText().toString(),
                        60, TimeUnit.SECONDS,
                        MainActivity2.this,


                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                progressBar.setVisibility(View.GONE);
                                buttongetotp.setVisibility(View.VISIBLE);

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar.setVisibility(View.GONE);
                                buttongetotp.setVisibility(View.VISIBLE);
                                Toast.makeText(MainActivity2.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progressBar.setVisibility(View.GONE);
                                buttongetotp.setVisibility(View.VISIBLE);


                                Intent intent=new Intent(getApplicationContext(),OTPverification.class);
                                intent.putExtra("mobile",inputmobile.getText().toString());
//                                intent.putExtra("email",Emailaddress.getText().toString());
                                intent.putExtra("verificationId",verificationId);
                                startActivity(intent);
                            }
                        });
            }

        });
    }

}