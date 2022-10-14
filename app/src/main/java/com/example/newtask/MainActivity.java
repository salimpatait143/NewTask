package com.example.newtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView Register=(TextView) findViewById(R.id.Register);
        email=findViewById(R.id.Email);
        password=findViewById(R.id.Password);
        login=findViewById(R.id.login);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailid = email.getText().toString();
                String pass = password.getText().toString();

                if (password.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity.this, "email and password is required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!emailid.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailid).matches() && (pass.length() >= 6 && pass.matches("(.*[0-9].*)")
                        && pass.matches("(.*[A-Z].*)") && pass.matches("^(?=.*[_.()$&@]).*$"))) {
                    Toast.makeText(MainActivity.this, "Email and Password valid", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, Welcome.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "invalid email or password or password contain atleast one special character and one uppercase letter and digit ", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }


}