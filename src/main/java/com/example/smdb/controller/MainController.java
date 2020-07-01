package com.example.smdb.controller;

import com.example.smdb.domain.Employee;
import com.example.smdb.domain.User;
import com.example.smdb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(value = "/")
    public String firstView(Map<String, Object> model)
    {
        return "greeting";
    }

    @GetMapping(value="employee_list")
    public String userList(Map<String, Object> model){

       /* boolean isAdmin = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for(GrantedAuthority grantedAuthority : authorities){
            if(grantedAuthority.getAuthority().equals("ADMIN")){
                isAdmin = true;
                break;
            }
        }
        Iterable<Employee> employees = employeeRepository.findAll();
        model.put("employees", employees);
        if(isAdmin){
            return "employee_list_admin";
        }else{
            return "employee_list";
        }*/
        Iterable<Employee> employees = employeeRepository.findAll();
        model.put("employees", employees);
        return "employee_list";

    }

    @GetMapping(value="employee_list_admin")
    public String adminList(Map<String, Object> model){
        Iterable<Employee> employees = employeeRepository.findAll();
        model.put("employees", employees);
        return "employee_list_admin";
    }





    @PostMapping(value = "employee_list")
    public String addUser(@AuthenticationPrincipal User user,
            @RequestParam Long inn, @RequestParam String first_name, @RequestParam String last_name,
                          @RequestParam String position, @RequestParam String department,
                          @RequestParam String phone_number, @RequestParam String email, Map<String, Object> model){
        Employee employee = new Employee(inn, first_name, last_name, position, department, phone_number, email);
        employeeRepository.save(employee);
        Iterable<Employee> employees = employeeRepository.findAll();
        model.put("employees", employees);
        return "employee_list";

    }

    @PostMapping(value = "employee_list_admin")
    public String addUserAdmin(@AuthenticationPrincipal User user,
                          @RequestParam Long inn, @RequestParam String first_name, @RequestParam String last_name,
                          @RequestParam String position, @RequestParam String department,
                          @RequestParam String phone_number, @RequestParam String email, Map<String, Object> model){
        Employee employee = new Employee(inn, first_name, last_name, position, department, phone_number, email);
        employeeRepository.save(employee);
        Iterable<Employee> employees = employeeRepository.findAll();
        model.put("employees", employees);
        return "employee_list_admin";

    }




}
