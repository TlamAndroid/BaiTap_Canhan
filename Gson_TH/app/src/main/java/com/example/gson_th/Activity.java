package com.example.gson_th;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import com.google.gson.reflect.TypeToken;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Activity extends AppCompatActivity implements StudentAdapter.OnStudentClickListener {
    private RecyclerView recyclerView;
    private StudentAdapter adapter;
    private List<Student> studentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadJSON();
    }

    private void loadJSON() {
        try {
            InputStream is = getAssets().open("students.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);

            // Phân tích cú pháp JSON sử dụng JSONArray
            studentList = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Student student = new Gson().fromJson(jsonObject.toString(), Student.class);
                studentList.add(student);
            }

            // Khởi tạo adapter với đúng listener
            adapter = new StudentAdapter(studentList, this);
            recyclerView.setAdapter(adapter);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
    public void onStudentClick(Student student) {
        // Hiển thị thông tin chi tiết về sinh viên
        Intent intent = new Intent(this, StudentDetailActivity.class);
        intent.putExtra("student", new Gson().toJson(student));
        startActivity(intent);
    }

}