package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class StudentsPage extends AppCompatActivity {

    Button btnStudentRegistration, btnLibraryRegistration, btnClassSchedule, btnContactInstitute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_page);

        btnStudentRegistration = findViewById(R.id.btnStudentRegistration);
        btnLibraryRegistration = findViewById(R.id.btnLibraryRegistration);
        btnClassSchedule = findViewById(R.id.btnClassSchedule);
        btnContactInstitute = findViewById(R.id.btnContactInstitute);

        btnStudentRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentsPage.this, StudentsRegistration.class);
                startActivity(intent);
            }
        });

        btnLibraryRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentsPage.this, LibraryRegStudents.class);
                startActivity(intent);
            }
        });

        btnClassSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentsPage.this, ClassScheduleActivity.class);
                startActivity(intent);
            }
        });


        btnContactInstitute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentsPage.this, ContactsActivity.class);
                startActivity(intent);
            }
        });

    }
}
