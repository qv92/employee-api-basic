package com.example.crudangularspringbootvalidate.service;

import com.example.crudangularspringbootvalidate.exception.UserNotFoundException;
import com.example.crudangularspringbootvalidate.model.Employee;
import com.example.crudangularspringbootvalidate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeebyId(Long id){
        return employeeRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id " + id +" was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

}
