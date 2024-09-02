package com.example.test1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TeacherRegistrationActivity extends AppCompatActivity {

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etIndexNumber;
    private EditText etAddress;
    private EditText etEmailAddress;
    private EditText etContactNumber;
    private Button btnRegister;
    private TeachersDB dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_registration);

        // Initialize views
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etIndexNumber = findViewById(R.id.etIndexNumber);
        etAddress = findViewById(R.id.etAddress);
        etEmailAddress = findViewById(R.id.etEmailAddress);
        etContactNumber = findViewById(R.id.etContactNumber);
        btnRegister = findViewById(R.id.btnRegister);
        dbHelper = new TeachersDB(this);

        // Set up the register button click listener
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = etFirstName.getText().toString();
                String lastName = etLastName.getText().toString();
                String indexNumber = etIndexNumber.getText().toString();
                String address = etAddress.getText().toString();
                String emailAddress = etEmailAddress.getText().toString();
                String contactNumber = etContactNumber.getText().toString();

                // Check if any field is empty
                if (isEmpty(firstName) || isEmpty(lastName) || isEmpty(indexNumber) ||
                        isEmpty(address) || isEmpty(emailAddress) || isEmpty(contactNumber)) {
                    Toast.makeText(TeacherRegistrationActivity.this, "All fields should be filled!", Toast.LENGTH_SHORT).show();
                    return; // Exit the function if any field is empty
                }

                // Validate email and contact number before inserting
                if (isValidEmail(emailAddress) && isValidContactNumber(contactNumber)) {
                    boolean isInserted = dbHelper.insertTeacher(firstName, lastName, indexNumber, address, emailAddress, contactNumber);
                    if (isInserted) {
                        Toast.makeText(TeacherRegistrationActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        clearFields();
                    } else {
                        Toast.makeText(TeacherRegistrationActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    String errorMessage = "";
                    if (!isValidEmail(emailAddress)) {
                        errorMessage += "Invalid Email Address\n";
                    }
                    if (!isValidContactNumber(contactNumber)) {
                        errorMessage += "Invalid Contact Number (must be 10 digits)";
                    }
                    Toast.makeText(TeacherRegistrationActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isEmpty(String str) {
        return str.isEmpty() || str.trim().length() == 0;
    }

    private boolean isValidEmail(String email) {
        return email.contains("@gmail.com") && email.length() > "@gmail.com".length();
    }

    private boolean isValidContactNumber(String contactNumber) {
        return contactNumber.length() == 10 && contactNumber.matches("[0-9]+"); // Matches only digits
    }

    private void clearFields() {
        etFirstName.setText("");
        etLastName.setText("");
        etIndexNumber.setText("");
        etAddress.setText("");
        etEmailAddress.setText("");
        etContactNumber.setText("");
    }
}
