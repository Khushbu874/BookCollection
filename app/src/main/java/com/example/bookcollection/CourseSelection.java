package com.example.bookcollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CourseSelection extends AppCompatActivity {

    ListView courseListView;
    String[] courses = {"B.Tech", "Diploma", "M.Tech"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_selection);

        courseListView = findViewById(R.id.courseListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,courses);

        courseListView.setAdapter(adapter);

        courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCourse = courses[position];

                Intent intent = new Intent(CourseSelection.this, SemesterSelection.class);
                intent.putExtra("selectedCourse", selectedCourse);
                startActivity(intent);

                Toast.makeText(CourseSelection.this, "Selected: " + selectedCourse, Toast.LENGTH_SHORT).show();
            }
        });
    }
}