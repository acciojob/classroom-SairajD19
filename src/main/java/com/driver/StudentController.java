package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/students/add-student")
    public ResponseEntity<String> addStudent(@RequestBody() Student student){

        studentService.addStu(student);
        return new ResponseEntity<>("New student added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/students/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){

        studentService.addTea(teacher);
        return new ResponseEntity<>("New teacher added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/students/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam String student, @RequestParam String teacher){


        studentService.addPair(student,teacher);
        return new ResponseEntity<>("New student-teacher pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/students/get-student-by-name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name){
        Student student = studentService.getStu(name); // Assign student by calling service layer method

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("/students/get-teacher-by-name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name){
        Teacher teacher = studentService.getTea(name); // Assign student by calling service layer method

        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @GetMapping("/students/get-students-by-teacher-name/{teacher}")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher){
        List<String> students = studentService.stuByTea(teacher); // Assign list of student by calling service layer method

        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }

    @GetMapping("/students/get-all-students")
    public ResponseEntity<List<String>> getAllStudents(){
        List<String> students = studentService.allStu(); // Assign list of student by calling service layer method

        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }

    @DeleteMapping("/students/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam String teacher){

        studentService.delTeaStu(teacher);
        return new ResponseEntity<>(teacher + " removed successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("/students/delete-all-teachers")
    public ResponseEntity<String> deleteAllTeachers(){

        studentService.dellAll();
        return new ResponseEntity<>("All teachers deleted successfully", HttpStatus.CREATED);
    }
}
