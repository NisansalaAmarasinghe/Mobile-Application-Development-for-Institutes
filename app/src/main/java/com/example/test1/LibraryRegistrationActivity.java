package com.example.test1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LibraryRegistrationActivity extends AppCompatActivity {

    private EditText etFullName;
    private EditText etIndexNumber;
    private RadioGroup radioGroupDate;
    private RadioGroup radioGroupTime;
    private Button btnLibraryRegistration;
    private TeachersDB dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_registration);

        // Initialize views
        etFullName = findViewById(R.id.etFullName);
        etIndexNumber = findViewById(R.id.etIndexNumber);
        radioGroupDate = findViewById(R.id.radioGroupDate);
        radioGroupTime = findViewById(R.id.radioGroupTime);
        btnLibraryRegistration = findViewById(R.id.btnLibraryRegistration);
        dbHelper = new TeachersDB(this);

        // Set up the register button click listener
        btnLibraryRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = etFullName.getText().toString();
                String indexNumber = etIndexNumber.getText().toString();
                String date = getDateOption();
                String time = getTimeOption();

                boolean isInserted = dbHelper.insertLibraryRegistration(fullName, indexNumber, date, time);
                if (isInserted) {
                    Toast.makeText(LibraryRegistrationActivity.this, "Library Registration Successful", Toast.LENGTH_SHORT).show();
                    // Clear the fields after successful registration
                    clearFields();
                } else {
                    Toast.makeText(LibraryRegistrationActivity.this, "Library Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String getDateOption() {
        int selectedId = radioGroupDate.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        return radioButton.getText().toString();
    }

    private String getTimeOption() {
        int selectedId = radioGroupTime.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        return radioButton.getText().toString();
    }

    private void clearFields() {
        etFullName.setText("");
        etIndexNumber.setText("");
        radioGroupDate.check(R.id.radioButtonWeekdays); // Set default selection to Weekdays
        radioGroupTime.check(R.id.radioButtonMorning); // Set default selection to Morning
    }
}
