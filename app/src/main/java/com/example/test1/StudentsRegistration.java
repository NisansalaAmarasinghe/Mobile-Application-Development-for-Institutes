package com.example.test1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class StudentsRegistration extends AppCompatActivity {

    EditText etFirstName, etLastName, etIndexNumber, etAddress, etPhoneNumber;
    RadioGroup rgGrade;
    Button btnRegister;
    StudentDB dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_registration);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etIndexNumber = findViewById(R.id.etIndexNumber);
        etAddress = findViewById(R.id.etAddress);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        rgGrade = findViewById(R.id.rgGrade);
        btnRegister = findViewById(R.id.btnRegister);

        dbHelper = new StudentDB(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = etFirstName.getText().toString();
                String lastName = etLastName.getText().toString();
                String indexNumber = etIndexNumber.getText().toString();
                String address = etAddress.getText().toString();
                String phoneNumber = etPhoneNumber.getText().toString();
                int selectedGradeId = rgGrade.getCheckedRadioButtonId();

                // Check if all fields are filled and phone number is valid
                if (isEmpty(firstName) || isEmpty(lastName) || isEmpty(indexNumber) ||
                        isEmpty(address) || isEmpty(phoneNumber) || !isValidPhoneNumber(phoneNumber)) {
                    String errorMessage = "Please fill all fields and ensure phone number has 10 digits.";
                    Toast.makeText(StudentsRegistration.this, errorMessage, Toast.LENGTH_SHORT).show();
                    return; // Exit the function if any field is empty or phone number is invalid
                }

                if (selectedGradeId != -1) {
                    RadioButton selectedGrade = findViewById(selectedGradeId);
                    String grade = selectedGrade.getText().toString();

                    boolean isInserted = dbHelper.insertStudentData(firstName, lastName, indexNumber, address, phoneNumber, grade);
                    if (isInserted) {
                        Toast.makeText(StudentsRegistration.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                        // Clear EditText fields after successful registration
                        etFirstName.setText("");
                        etLastName.setText("");
                        etIndexNumber.setText("");
                        etAddress.setText("");
                        etPhoneNumber.setText("");
                        // Clear radio button selection
                        rgGrade.clearCheck();
                    } else {
                        Toast.makeText(StudentsRegistration.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(StudentsRegistration.this, "Please select a grade", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.length() == 10 && phoneNumber.matches("[0-9]+"); // Matches only digits
    }
}
