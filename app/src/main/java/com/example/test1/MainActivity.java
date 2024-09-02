package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);

        // Set click listener for login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.equals("School") && password.equals("1234")) {
                    // Credentials are correct, navigate to OptionsActivity
                    Intent intent = new Intent(MainActivity.this, Selection.class);
                    startActivity(intent);
                } else {
                    // Credentials are incorrect
                    Toast.makeText(MainActivity.this, "Your credentials are wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set click listener for create account button
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // For demonstration, just show a toast
                Toast.makeText(MainActivity.this, "Create New Account Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
