package com.example.pracc2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EmployeeViewModel employeeViewModel;
    private EditText etN, etS, etBD, etSlr;
    private Button btnAdd;
    private TextView tvMessage, tvEmployeeList;
    private int employeeCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etN = findViewById(R.id.edFName);
        etS = findViewById(R.id.edId);
        etBD = findViewById(R.id.edBDate);
        etSlr= findViewById(R.id.edSlr);
        btnAdd = findViewById(R.id.button);
        tvMessage = findViewById(R.id.tvMess);
        tvEmployeeList = findViewById(R.id.tvEmList);

        employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);

        employeeViewModel.getEmployees().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                displayEmployeeList(employees);
            }
        });


        TextWatcher inputWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputStatus();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        etN.addTextChangedListener(inputWatcher);
        etS.addTextChangedListener(inputWatcher);
        etBD.addTextChangedListener(inputWatcher);
        etSlr.addTextChangedListener(inputWatcher);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEmployee();
            }
        });
    }

    private void displayEmployeeList(List<Employee> employees) {
        if (employees.isEmpty()) {
            tvEmployeeList.setText("No Result!");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (Employee employee : employees) {
                stringBuilder.append(employee.getId()).append(" - ")
                        .append(employee.getName()).append(" - ")
                        .append(employee.getBirthday()).append(" - ")
                        .append(employee.getSalary()).append("\n");
            }
            tvEmployeeList.setText(stringBuilder.toString());
        }
    }
    private void addEmployee() {
        String fullName = etN.getText().toString().trim();
        String staffId = etS.getText().toString().trim();
        String birthDate = etBD.getText().toString().trim();
        String salary = etSlr.getText().toString().trim();

        if (validateInputs(fullName, staffId, birthDate, salary)) {
            employeeViewModel.addEmployee(fullName, staffId, birthDate, salary);
            employeeCount++; // Tăng số lượng nhân viên đã thêm
            tvMessage.setText("Đã thêm nhân viên.");
            etN.setText("");
            etS.setText("");
            etBD.setText("");
            etSlr.setText("");
            if (employeeCount > 1) {
                tvMessage.setText("Sau khi thêm vài nhân viên.");
            }
        } else {
            tvMessage.setText("Chưa nhập đủ dữ liệu.");
        }
    }

    private boolean validateInputs(String fullName, String staffId, String birthDate, String salary) {
        return !fullName.isEmpty() && !staffId.isEmpty() && !birthDate.isEmpty() && !salary.isEmpty();
    }





    private void checkInputStatus() {
        String fullName = etN.getText().toString().trim();
        String staffId = etS.getText().toString().trim();
        String birthDate = etBD.getText().toString().trim();
        String salary = etSlr.getText().toString().trim();

        if (!fullName.isEmpty() || !staffId.isEmpty() || !birthDate.isEmpty() || !salary.isEmpty()) {
            tvMessage.setText("Đã nhập nhưng chưa nhấn nút.");
        } else {
            tvMessage.setText("");
        }
    }


}