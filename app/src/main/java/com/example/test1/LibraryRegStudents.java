package com.example.test1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LibraryRegStudents extends AppCompatActivity {

    EditText etFullName, etIndexNumber;
    RadioGroup rgTime, rgDates, rgGrade;
    Button btnRegister;
    StudentDB dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_reg_students);

        etFullName = findViewById(R.id.etFullName);
        etIndexNumber = findViewById(R.id.etIndexNumber);
        rgTime = findViewById(R.id.rgTime);
        rgDates = findViewById(R.id.rgDates);
        rgGrade = findViewById(R.id.rgGrade);
        btnRegister = findViewById(R.id.btnRegister);

        dbHelper = new StudentDB(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = etFullName.getText().toString();
                String indexNumber = etIndexNumber.getText().toString();
                int selectedTimeId = rgTime.getCheckedRadioButtonId();
                int selectedDatesId = rgDates.getCheckedRadioButtonId();
                int selectedGradeId = rgGrade.getCheckedRadioButtonId();

                if (selectedTimeId != -1 && selectedDatesId != -1 && selectedGradeId != -1) {
                    RadioButton selectedTime = findViewById(selectedTimeId);
                    RadioButton selectedDates = findViewById(selectedDatesId);
                    RadioButton selectedGrade = findViewById(selectedGradeId);
                    String time = selectedTime.getText().toString();
                    String dates = selectedDates.getText().toString();
                    String grade = selectedGrade.getText().toString();

                    boolean isInserted = dbHelper.insertStudentLibraryRegistration(fullName, indexNumber, time, dates, grade);
                    if (isInserted) {
                        Toast.makeText(LibraryRegStudents.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                        // Clear EditText fields
                        etFullName.setText("");
                        etIndexNumber.setText("");

                        // Uncheck RadioButtons

                        rgTime.clearCheck();
                        rgDates.clearCheck();
                        rgGrade.clearCheck();
                    } else {
                        Toast.makeText(LibraryRegStudents.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LibraryRegStudents.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
