package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    //add a student
    public void addStu(Student student){
        studentRepository.addStudent(student);
    }

    //add a teacher
    public void addTea(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    //pair teacher student
    public void addPair(String student, String teacher){
        studentRepository.studentTeacherPair(student,teacher);
    }

    //get student
    public Student getStu(String student){
        return studentRepository.findStudent(student);
    }

    //get teacher
    public Teacher getTea(String teacher){
        return studentRepository.findTeacher(teacher);
    }

    //students by teacher
    public List<String> stuByTea(String teacher){
        return studentRepository.listForTeacher(teacher);
    }

    //all students
    public List<String> allStu(){
        return studentRepository.allStudent();
    }

    //delete teacher and its students
    public void delTeaStu(String teacher){
        studentRepository.deleteTeachersStudents(teacher);
    }

    //delete all students and teacher
    public void dellAll(){
        studentRepository.deleteAll();
    }
}
