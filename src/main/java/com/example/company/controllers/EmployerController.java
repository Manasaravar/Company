package com.example.company.controllers;


import com.example.company.model.DB;
import com.example.company.model.Employee;
import com.example.company.model.Profession;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping ("/employees")
public class EmployerController {

    private DB db;

    public EmployerController() {
        this.db = new DB();
    }

    @GetMapping
    public List<Employee> findAllEmployees(){
        return db.findAllEmployees();
    }

    @PostMapping
    private void save(@RequestParam String firstName,@RequestParam String secondName,
                      @RequestParam String sex, @RequestParam Integer age){
        db.save(new Employee(firstName,secondName,sex,age));
    }

    @PostMapping ("/updateEmp")
    private void update (@RequestParam Integer id, @RequestParam String firstName,
                         @RequestParam String secondName, @RequestParam String sex,
                         @RequestParam Integer age){
        db.updateEmp(id, firstName, secondName, sex, age);
    }

    @PostMapping ("/removeEmp")
    private void remove (@RequestParam Integer id) {
        db.removeEmp(id);
    }

}
