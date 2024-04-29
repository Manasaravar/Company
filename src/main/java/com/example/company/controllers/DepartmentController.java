package com.example.company.controllers;
import com.example.company.model.DB;
import com.example.company.model.Departament;
import com.example.company.model.Employee;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private DB db;

    public DepartmentController() {
        this.db = new DB();
    }
    @GetMapping
    public List<Departament> getAllDepartments(){
        return db.findAllDepartments();
    }
    @PostMapping
    private void save(@RequestParam String nameOfDep,@RequestParam (required = false) String group){
        db.save(new Departament(nameOfDep,group));
    }
    @PostMapping ("/updateDep")
    private void update (@RequestParam Integer id, @RequestParam String nameOfDep, @RequestParam String nameGroup){
        db.updateDep(id, nameOfDep, nameGroup);
    }

    @PostMapping ("/removeDep")
    private void remove (@RequestParam Integer id) {
        db.removeDep(id);
    }
}
