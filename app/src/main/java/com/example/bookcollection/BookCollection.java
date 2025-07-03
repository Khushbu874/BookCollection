package com.example.bookcollection;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class BookCollection extends AppCompatActivity {

    GridView gridView;
    ArrayList<BookModel> bookList;
    BookAdapter adapter;

    String selectedCourse = "", selectedSemester = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_collection);

        gridView = findViewById(R.id.gridView);
        selectedCourse = getIntent().getStringExtra("selectedCourse");
        selectedSemester = getIntent().getStringExtra("selectedSemester");

        if (selectedCourse == null || selectedSemester == null) { //
            Toast.makeText(this, "Missing course or semester!", Toast.LENGTH_SHORT).show();
            finish(); // prevent crash
            return;
        } //

        bookList = new ArrayList<>();
        loadBooks(); // filter based on course + semester

        adapter = new BookAdapter(this, bookList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BookModel book = bookList.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse(book.getPdfUrl()), "application/pdf");
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
    }

    private void loadBooks() {
        // Dummy data - replace with actual logic or API call
        if (selectedCourse.equals("B.Tech") && selectedSemester.equals("1st Semester")) {

            bookList.add(new BookModel("M-1", "https://mrcet.com/downloads/digital_notes/HS/Mathematics-I.pdf"));
            bookList.add(new BookModel("Physics", "https://mrcet.com/downloads/digital_notes/HS/R20/Engineering%20Physics.pdf"));
            bookList.add(new BookModel("ED&G", "https://mrce.in/ebooks/Design-Engineering%20Design%206th%20Ed.pdf"));
            bookList.add(new BookModel("EVS-E", "https://gbcramgarh.in/e-learning-study-materials/BCA/computer/ENVIRONMENT,%20ECOSYSTEMS%20AND%20BIODIVERSITY/GE6351%20EVS.pdf"));
            bookList.add(new BookModel("BEE", "https://mrcet.com/downloads/digital_notes/HS/Basic%20Electrical%20Engineering%20R-20.pdf"));
            bookList.add(new BookModel("PCS", "https://mrcet.com/downloads/MBA/Professional%20Communication%20Skills.pdf"));


        } else if (selectedCourse.equals("B.Tech") && selectedSemester.equals("2nd Semester")) {

            bookList.add(new BookModel("M-2", "https://mrcet.com/downloads/digital_notes/HS/R-18%20Mathematics-II.pdf"));
            bookList.add(new BookModel("E-Chemistry", "https://mrcet.com/downloads/digital_notes/HS/4%20ENGINEERING%20CHEMISTRY.pdf"));
            bookList.add(new BookModel("E-Mechanics", "https://mrcet.com/downloads/digital_notes/ME/II%20year/Engineering%20Mechanics.pdf"));
            bookList.add(new BookModel("BME", "https://mrcet.com/downloads/digital_notes/EEE/BME%20DIGITAL%20NOTES.pdf"));
            bookList.add(new BookModel("PPS", "https://mrcet.com/downloads/digital_notes/HS/Programming%20for%20Problem%20Solving.pdf"));
            bookList.add(new BookModel("BCE", "https://mace.ac.in/files/Bacics%20of%20Civil%20Engg.pdf"));

        }  else if (selectedCourse.equals("B.Tech") && selectedSemester.equals("3rd Semester")) {

            bookList.add(new BookModel("M-3", "https://mrcet.com/downloads/digital_notes/EEE/M-III%20DIGITAL%20NOTES.pdf"));
            bookList.add(new BookModel("DSA", "https://mrcet.com/downloads/digital_notes/CSE/II%20Year/DATA%20STRUCTURES%20DIGITAL%20NOTES.pdf"));
            bookList.add(new BookModel("BE", "https://mrce.in/ebooks/Electronics-Basic%20Electronics%203rd%20Ed.pdf"));
            bookList.add(new BookModel("POP-1", "https://vardhaman.org/wp-content/uploads/2021/03/CP.pdf"));
            bookList.add(new BookModel("VB.NET", "https://www.tutorialspoint.com/vb.net/vb.net_tutorial.pdf"));

        }  else if (selectedCourse.equals("B.Tech") && selectedSemester.equals("4th Semester")) {

            bookList.add(new BookModel("M-4", "https://vemu.org/uploads/lecture_notes/18_01_2020_110870439.pdf"));
            bookList.add(new BookModel("CN", "https://mrcet.com/downloads/digital_notes/CSE/III%20Year/COMPUTER%20NETWORKS%20NOTES.pdf"));
            bookList.add(new BookModel("OS", "https://www.cl.cam.ac.uk/teaching/1011/OpSystems/os1a-slides.pdf"));
            bookList.add(new BookModel("POP-2", "https://www.tutorialspoint.com/java/java_tutorial.pdf"));
            bookList.add(new BookModel("DBMS", "https://mrcet.com/downloads/digital_notes/ECE/III%20Year/DATABASE%20MANAGEMENT%20SYSTEMS.pdf"));

        }  else if (selectedCourse.equals("B.Tech") && selectedSemester.equals("5th Semester")) {

            bookList.add(new BookModel("DS", "https://web.stanford.edu/class/cs103x/cs103x-notes.pdf"));
            bookList.add(new BookModel("ADA", "https://mrcet.com/downloads/digital_notes/IT/Design%20and%20Analysis%20Algorithms.pdf"));
            bookList.add(new BookModel("POP-3", "https://mrce.in/ebooks/Design-Engineering%20Design%206th%20Ed.pdf"));
            bookList.add(new BookModel("UNIX", "https://gbcramgarh.in/e-learning-study-materials/BCA/computer/ENVIRONMENT,%20ECOSYSTEMS%20AND%20BIODIVERSITY/GE6351%20EVS.pdf"));
            bookList.add(new BookModel("TOC", "https://mrcet.com/downloads/digital_notes/HS/Basic%20Electrical%20Engineering%20R-20.pdf"));

        }  else if (selectedCourse.equals("B.Tech") && selectedSemester.equals("6th Semester")) {

            bookList.add(new BookModel("AI", "https://mrcet.com/downloads/digital_notes/HS/Mathematics-I.pdf"));
            bookList.add(new BookModel("Android", "https://mrcet.com/downloads/digital_notes/HS/R20/Engineering%20Physics.pdf"));
            bookList.add(new BookModel("DC", "https://mrce.in/ebooks/Design-Engineering%20Design%206th%20Ed.pdf"));
            bookList.add(new BookModel("CD", "https://gbcramgarh.in/e-learning-study-materials/BCA/computer/ENVIRONMENT,%20ECOSYSTEMS%20AND%20BIODIVERSITY/GE6351%20EVS.pdf"));
            bookList.add(new BookModel("DIP", "https://mrcet.com/downloads/digital_notes/HS/Basic%20Electrical%20Engineering%20R-20.pdf"));

        }  else if (selectedCourse.equals("B.Tech") && selectedSemester.equals("7th Semester")) {

            bookList.add(new BookModel("CC", "https://mrcet.com/downloads/digital_notes/HS/Mathematics-I.pdf"));

        }  else if (selectedCourse.equals("B.Tech") && selectedSemester.equals("8th Semester")) {

            bookList.add(new BookModel("DM", "https://example.com/diploma_sem2_mechanics.pdf"));

        } else if (selectedCourse.equals("Diploma") && selectedSemester.equals("1st Semester")) {

            bookList.add(new BookModel("Math-1", "https://mrcet.com/downloads/digital_notes/HS/Mathematics-I.pdf"));
            bookList.add(new BookModel("Physics", "https://mrcet.com/downloads/digital_notes/HS/R20/Engineering%20Physics.pdf"));
            bookList.add(new BookModel("ED&G", "https://mrce.in/ebooks/Design-Engineering%20Design%206th%20Ed.pdf"));
            bookList.add(new BookModel("EVS", "https://gbcramgarh.in/e-learning-study-materials/BCA/computer/ENVIRONMENT,%20ECOSYSTEMS%20AND%20BIODIVERSITY/GE6351%20EVS.pdf"));
            bookList.add(new BookModel("BEE", "https://mrcet.com/downloads/digital_notes/HS/Basic%20Electrical%20Engineering%20R-20.pdf"));

        } else if (selectedCourse.equals("Diploma") && selectedSemester.equals("2nd Semester")) {

            bookList.add(new BookModel("Mechanics", "https://example.com/diploma_sem2_mechanics.pdf"));

        } else if (selectedCourse.equals("Diploma") && selectedSemester.equals("3rd Semester")) {

            bookList.add(new BookModel("Mechanics", "https://example.com/diploma_sem2_mechanics.pdf"));

        } else if (selectedCourse.equals("Diploma") && selectedSemester.equals("4th Semester")) {

            bookList.add(new BookModel("Mechanics", "https://example.com/diploma_sem2_mechanics.pdf"));

        } else if (selectedCourse.equals("Diploma") && selectedSemester.equals("5th Semester")) {

            bookList.add(new BookModel("Mechanics", "https://example.com/diploma_sem2_mechanics.pdf"));

        } else if (selectedCourse.equals("Diploma") && selectedSemester.equals("6th Semester")) {

            bookList.add(new BookModel("Mechanics", "https://example.com/diploma_sem2_mechanics.pdf"));

        } else if (selectedCourse.equals("M.Tech") && selectedSemester.equals("1st Semester")) {

            bookList.add(new BookModel("Mechanics", "https://example.com/diploma_sem2_mechanics.pdf"));

        } else if (selectedCourse.equals("M.Tech") && selectedSemester.equals("2nd Semester")) {

            bookList.add(new BookModel("Mechanics", "https://example.com/diploma_sem2_mechanics.pdf"));

        } else if (selectedCourse.equals("M.Tech") && selectedSemester.equals("3rd Semester")) {

            bookList.add(new BookModel("Mechanics", "https://example.com/diploma_sem2_mechanics.pdf"));

        } else if (selectedCourse.equals("M.Tech") && selectedSemester.equals("4th Semester")) {

            bookList.add(new BookModel("Mechanics", "https://example.com/diploma_sem2_mechanics.pdf"));

        } else {

            bookList.add(new BookModel("Maths", "https://example.com/btech_sem1_maths.pdf"));
            bookList.add(new BookModel("Physics", "https://example.com/btech_sem1_physics.pdf"));
            bookList.add(new BookModel("Mechanics", "https://example.com/diploma_sem2_mechanics.pdf"));
        }
    }
}