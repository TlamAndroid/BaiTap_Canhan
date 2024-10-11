package com.example.gson_th;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddStudent extends AppCompatActivity {
    private EditText id, name, date, mail, gpa;
    private Spinner spnDiaChi, spnChuyenNganh, spnNamHoc;
    private Button btnSubmit;
    private RadioButton rdNam, rdNu, rdKhac;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        id = findViewById(R.id.edId);
        name = findViewById(R.id.edName);
        date = findViewById(R.id.edDate);
        mail = findViewById(R.id.edEmail);
        gpa = findViewById(R.id.edGpa);
        spnDiaChi = findViewById(R.id.spinner2);
        spnChuyenNganh = findViewById(R.id.spinner3);
        spnNamHoc = findViewById(R.id.spinner4);
        btnSubmit = findViewById(R.id.button3);
        rdNam = findViewById(R.id.rdnam);
        rdNu = findViewById(R.id.rdnu);
        rdKhac = findViewById(R.id.rdkhac);

        ArrayAdapter<CharSequence> diachi = ArrayAdapter.createFromResource(this, R.array.dia_chi, android.R.layout.simple_spinner_item);
        diachi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDiaChi.setAdapter(diachi);

        ArrayAdapter<CharSequence> chuyennganh = ArrayAdapter.createFromResource(this, R.array.chuyen_nganh, android.R.layout.simple_spinner_item);
        chuyennganh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnChuyenNganh.setAdapter(chuyennganh);

        ArrayAdapter<CharSequence> namhoc = ArrayAdapter.createFromResource(this, R.array.nam_hoc, android.R.layout.simple_spinner_item);
        namhoc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnNamHoc.setAdapter(namhoc);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });
    }

    private void addStudent() {
        String studentId = id.getText().toString().trim();
        String studentName = name.getText().toString().trim();
        String studentDate = date.getText().toString().trim();
        String studentEmail = mail.getText().toString().trim();
        String studentGpa = gpa.getText().toString().trim();
        String studentAddress = spnDiaChi.getSelectedItem().toString();
        String studentMajor = spnChuyenNganh.getSelectedItem().toString();
        String studentYear = spnNamHoc.getSelectedItem().toString();
        String studentGender = rdNam.isChecked() ? "Nam" : rdNu.isChecked() ? "Nữ" : "Khác";


        if (studentId.isEmpty() || studentName.isEmpty() || studentDate.isEmpty() ||
                studentEmail.isEmpty() || studentGpa.isEmpty()) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            String[] nameParts = studentName.split(" ");
            String firstName = nameParts[0]; // Họ
            String middleName = nameParts.length > 2 ? nameParts[1] : ""; // Tên đệm (nếu có)
            String lastName = nameParts[nameParts.length - 1]; // Tên

            JSONObject newStudent = new JSONObject();
            newStudent.put("id", studentId);
            newStudent.put("full_name", new JSONObject()
                    .put("first", firstName)
                    .put("middle", middleName)
                    .put("last", lastName));
            newStudent.put("gender", studentGender);
            newStudent.put("birth_date", studentDate);
            newStudent.put("email", studentEmail);
            newStudent.put("address", studentAddress);
            newStudent.put("major", studentMajor);
            newStudent.put("gpa", Double.parseDouble(studentGpa));
            newStudent.put("year", Integer.parseInt(studentYear));

            saveStudentToJSON(newStudent);
            Toast.makeText(this, "Thêm sinh viên thành công", Toast.LENGTH_SHORT).show();
            clearInputs();
        } catch (JSONException | NumberFormatException e) {
            Log.e("AddStudent", "Lỗi khi thêm sinh viên: " + e.getMessage());
            Toast.makeText(this, "Lỗi khi thêm sinh viên", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveStudentToJSON(JSONObject newStudent) {
        try {
            JSONArray jsonArray = loadStudentsFromJSON();


            jsonArray.put(newStudent);


            FileOutputStream fos = openFileOutput("students.json", MODE_PRIVATE);
            fos.write(jsonArray.toString().getBytes());
            fos.close();
        } catch (IOException e) {
            Log.e("AddStudent", "IOException khi lưu: " + e.getMessage());
        }
    }

    private JSONArray loadStudentsFromJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        try {
            FileInputStream fis = openFileInput("students.json");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                jsonBuilder.append(new String(buffer, 0, length));
            }
            fis.close();
        } catch (IOException e) {
            Log.e("AddStudent", "File không tồn tại, tạo new JSONArray");
            jsonBuilder.append("[]");
        }

        try {
            
            return new JSONArray(jsonBuilder.toString());
        } catch (JSONException e) {
            Log.e("AddStudent", "JSONException khi đọc file: " + e.getMessage());
            return new JSONArray();
        }
    }

    private void clearInputs() {
        id.setText("");
        name.setText("");
        date.setText("");
        mail.setText("");
        gpa.setText("");
        spnDiaChi.setSelection(0);
        spnChuyenNganh.setSelection(0);
        spnNamHoc.setSelection(0);
    }
}
