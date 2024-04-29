package com.example.company.model;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Data
public class DB {
    private LinkedList<Profession> professions;
    private LinkedList<Employee> employees;
    private LinkedList<Departament> departments;

    public DB() {
        this.professions = new LinkedList<>();
        professions.add(new Profession(1, "Разраб", "Java"));
        this.employees = new LinkedList<>();
        employees.add(new Employee("Sergey", "Kornyushin", "M", 55));
        this.departments = new LinkedList<>();
        departments.add(new Departament("Департамент продаж", "Отдел розницы"));
    }


    public List<Profession> findAll() {
        return professions;
    }

    public List<Employee> findAllEmployees() {
        return employees;
    }

    public LinkedList<Departament> findAllDepartments() {
        return departments;
    }

    public void save(Profession profession) {
        Integer lastId = getLastId();
        profession.setId(lastId + 1);
        professions.add(profession);
    }

    public void save(Employee employee) {
        Integer lastId = getLastId();
        employee.setId(lastId + 1);
        employees.add(employee);
    }

    public void save(Departament departament) {
        Integer lastId = getLastId();
        departament.setId(lastId + 1);
        departments.add(departament);
    }

    public void remove(Integer id) {
        for (Profession prof : professions)
            if (Objects.equals(id, prof.getId())) {
                professions.remove(professions.get(id - 1));
                break;
            } else System.out.println("id = " + id + " not found");
    }
    public void removeDep(Integer id) {
        for (Departament dep : departments)
            if (Objects.equals(id, dep.getId())) {
                departments.remove(departments.get(id - 1));
                break;
            } else System.out.println("id = " + id + " not found");
    }
    public void removeEmp(Integer id) {
        for (Employee employee : employees)
            if (Objects.equals(id, employee.getId())) {
                employees.remove(employees.get(id - 1));
                break;
            } else System.out.println("id = " + id + " not found");
    }

//    public void remove (Profession profession){
//        for(Profession prof : professions)
//            if (prof.equals(profession)) {
//                professions.remove(prof);
//                break;
//            }
//            else System.out.println("profession = " + profession + " not found");
//    }

    public void update(Integer id, String newName, String newNote) {
        for (Profession prof : professions) {
            if (Objects.equals(prof.getId(), id)) {
                prof.setName(newName);
                prof.setNote(newNote);
            }
        }
    }
    public void updateDep(Integer id, String nameOfDep, String nameGroup) {
        for (Departament dep : departments) {
            if (Objects.equals(dep.getId(), id)) {
                dep.setNameOfDep(nameOfDep);
                dep.setGroup(nameGroup);
            }
        }
    }
    public void updateEmp(Integer id, String firstName, String secondName, String sex, Integer age) {
        for (Employee employee : employees) {
            if (Objects.equals(employee.getId(), id)) {
              employee.setFirstName(firstName);
              employee.setSecondName(secondName);
              employee.setSex(sex);
              employee.setAge(age);
            }
        }
    }
    private Integer getLastId() {
        return professions.getLast().getId();

    }
}
