package com.example.bookcollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SemesterSelection extends AppCompatActivity {

    ListView semesterListView;
    String[] semesters;

    String selectedCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_selection);

        selectedCourse = getIntent().getStringExtra("selectedCourse");

        semesterListView = findViewById(R.id.semesterListView);

        switch (selectedCourse) {
            case "B.Tech":
                semesters = new String[]{"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
                break;
            case "Diploma":
                semesters = new String[]{"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester"};
                break;
            case "M.Tech":
                semesters = new String[]{"1st Semester", "2nd Semester", "3rd Semester", "4th Semester"};
                break;
            default:
                semesters = new String[]{"1st Semester", "2nd Semester"};
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                semesters
        );

        semesterListView.setAdapter(adapter);

        semesterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSemester = semesters[position];

                // Send selected semester to BookCollectionActivity
                Intent intent = new Intent(SemesterSelection.this, BookCollection.class);
                intent.putExtra("selectedSemester", selectedSemester);
                intent.putExtra("selectedCourse", selectedCourse);
                startActivity(intent);

                Toast.makeText(SemesterSelection.this, "Selected: " + selectedSemester, Toast.LENGTH_SHORT).show();
            }
        });
    }
}