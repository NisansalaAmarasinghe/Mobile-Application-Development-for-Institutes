package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Selection extends AppCompatActivity {


    private ImageButton btnStudents;
    private ImageButton btnTeachers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        // Initialize views
        btnStudents = findViewById(R.id.btnStudents);
        btnTeachers = findViewById(R.id.btnTeachers);

        // Set click listeners
        btnStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Students Activity
                Intent intent = new Intent(Selection.this, StudentsPage.class);
                startActivity(intent);
            }
        });

        btnTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to TeachersPage Activity
                Intent intent = new Intent(Selection.this, TeachersPage.class);
                startActivity(intent);
            }
        });
    }
}
