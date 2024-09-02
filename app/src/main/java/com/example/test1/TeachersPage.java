package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TeachersPage extends AppCompatActivity {

    private ListView listViewTeachers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_page);

        // Initialize views
        listViewTeachers = findViewById(R.id.listViewTeachers);

        // Data for list view
        String[] options = {
                "Teacher's Registration",
                "Library Registration for Teachers",
                "Categories of Streams",
                "Contact Institute"
        };

        // Set adapter to list view
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, options);
        listViewTeachers.setAdapter(adapter);

        // Set item click listener
        listViewTeachers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        // Navigate to TeacherRegistrationActivity
                        Intent intent = new Intent(TeachersPage.this, TeacherRegistrationActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        // Navigate to LibraryRegistrationActivity
                        Intent libraryIntent = new Intent(TeachersPage.this, LibraryRegistrationActivity.class);
                        startActivity(libraryIntent);
                        break;
                    case 2:
                        // Navigate to CategoriesActivity
                        Intent CategoryIntent = new Intent(TeachersPage.this, CategoriesActivity.class);
                        startActivity(CategoryIntent);
                        break;
                    case 3:
                        // Navigate to ContactsActivity
                        Intent ContactsIntent = new Intent(TeachersPage.this, ContactsActivity.class);
                        startActivity(ContactsIntent);
                        break;
                }
            }
        });

    }
}
