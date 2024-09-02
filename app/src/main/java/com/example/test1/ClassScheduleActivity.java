package com.example.test1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ClassScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_schedule);

        // Get the TableLayout
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Array of dummy data
        String[][] scheduleData = {
                {"Grade 1", "Class Room 10-15"},
                {"", ""},
                {"Grade 2", "Class Room 21-24"},
                {"", ""},
                {"Grade 3", "Class Room 26-31"},
                {"", ""},
                {"Grade 4", "Class Room 32-36"},
                {"", ""},
                {"Grade 5", "Class Room 40-46"},
                {"", ""},
                {"Grade 6", "Class Room 50-60"},
                {"", ""},
                {"Grade 7", "Class Room 62-68"},
                {"", ""},
                {"Grade 8", "Class Room 70-75"},
                {"", ""},
                {"Grade 9", "Class Room 76-81"},
                {"", ""},
                {"Grade 10", "Class Room 83-86"},
                {"", ""},
                {"Grade 11", "Class Room 90-96"},
                {"", ""},
                {"Grade 12", "Class Room 98-112"}
        };

        // Populate the table with dummy data
        for (String[] row : scheduleData) {
            TableRow tableRow = new TableRow(this);
            TextView textView1 = new TextView(this);
            textView1.setText(row[0]);
            TextView textView2 = new TextView(this);
            textView2.setText(row[1]);
            tableRow.addView(textView1);
            tableRow.addView(textView2);
            tableLayout.addView(tableRow);
        }
    }
}
