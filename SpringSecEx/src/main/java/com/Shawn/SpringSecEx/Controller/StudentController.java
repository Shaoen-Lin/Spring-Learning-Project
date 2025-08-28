package com.Shawn.SpringSecEx.Controller;

import com.Shawn.SpringSecEx.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


    public List<Student> students = new ArrayList<> (List.of(
        new Student(1,"Navin" , 60),
        new Student(2,"Shawn" , 67)
    ));

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student stud)
    {
        students.add(stud);
        return stud;
    }

    @GetMapping("/students")
    public List<Student> getStudent()
    {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
