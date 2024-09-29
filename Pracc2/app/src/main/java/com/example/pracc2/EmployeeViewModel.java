package com.example.pracc2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pracc2.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<Employee>> employees = new MutableLiveData<>(new ArrayList<>());

    public LiveData<ArrayList<Employee>> getEmployees() {
        return employees;
    }

    public void addEmployee(String fullName, String staffId, String birthDate, String salary) {
        ArrayList<Employee> currentList = employees.getValue();
        if (currentList != null) {
            currentList.add(new Employee(fullName, staffId, birthDate, salary));
            employees.setValue(currentList);
        }
    }
}