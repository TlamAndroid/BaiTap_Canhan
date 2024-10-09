package com.example.gson_th;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class StudentDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        String studentJson = getIntent().getStringExtra("student");
        Student student = new Gson().fromJson(studentJson, Student.class);

        // Hiển thị thông tin chi tiết sinh viên
        TextView tvDetails = findViewById(R.id.tv_student_details);
        tvDetails.setText("ID: " + student.getId() + "\n" +
                "Họ: " + student.getFull_name().getFirst() + "\n" +
                "Tên: " + student.getFull_name().getLast() + "\n" +
                "Giới tính: " + student.getGender() + "\n" +
                "Ngày sinh: " + student.getBirth_date() + "\n" +
                "Email: " + student.getEmail() + "\n" +
                "Địa chỉ: " + student.getAddress() + "\n" +
                "Chuyên ngành: " + student.getMajor() + "\n" +
                "GPA: " + student.getGpa() + "\n" +
                "Năm: " + student.getYear());
    }
}

