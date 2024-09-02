package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class CategoriesActivity extends AppCompatActivity {


    private ImageButton btnMaths;
    private ImageButton btnScience;
    private ImageButton btnCommerce;
    private ImageButton btnArts;
    private ImageButton btnTechnology;
    private ImageButton btnHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        // Initialize views
        btnMaths = findViewById(R.id.btnMaths);
        btnScience = findViewById(R.id.btnScience);
        btnCommerce = findViewById(R.id.btnCommerce);
        btnArts = findViewById(R.id.btnArts);
        btnTechnology = findViewById(R.id.btnTechnology);
        btnHistory = findViewById(R.id.btnHistory);

        // Set click listeners
        btnMaths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Students Activity
                Toast.makeText(CategoriesActivity.this, "Mathematics category is clicked", Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(OptionsActivity.this, StudentsActivity.class);
                // startActivity(intent);
            }
        });

        btnScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Students Activity
                Toast.makeText(CategoriesActivity.this, "Science category is clicked", Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(OptionsActivity.this, StudentsActivity.class);
                // startActivity(intent);
            }
        });

        btnCommerce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Students Activity
                Toast.makeText(CategoriesActivity.this, "Commerce category is clicked", Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(OptionsActivity.this, StudentsActivity.class);
                // startActivity(intent);
            }
        });

        btnArts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Students Activity
                Toast.makeText(CategoriesActivity.this, "Arts category is clicked", Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(OptionsActivity.this, StudentsActivity.class);
                // startActivity(intent);
            }
        });

        btnTechnology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Students Activity
                Toast.makeText(CategoriesActivity.this, "Technology category is clicked", Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(OptionsActivity.this, StudentsActivity.class);
                // startActivity(intent);
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Students Activity
                Toast.makeText(CategoriesActivity.this, "History category is clicked", Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(OptionsActivity.this, StudentsActivity.class);
                // startActivity(intent);
            }
        });

    }
}
