package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class StudentRepository {
    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> studentTeacherMapping;

    //Pair is : DirectorName, List of Movie Names


    //Initialization is very important :

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.studentTeacherMapping = new HashMap<String, List<String>>();
    }

    //Add a Student
    public void addStudent(Student student){
        studentMap.put(student.getName(), student);
    }
    //Add a Teacher
    public void addTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(), teacher);
    }
    //Add a student teacher pair
    public void studentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            List<String> st = new ArrayList<>();
            if(studentTeacherMapping.containsKey(teacher))
                st = studentTeacherMapping.get(teacher);
            st.add(student);
            studentTeacherMapping.put(teacher,st);
        }
    }
    //Get Student by Name

    public Student findStudent(String name){
        return studentMap.get(name);
    }
    //Get Teacher by name
    public Teacher findTeacher(String name){
        return teacherMap.get(name);
    }

    //Get list of Students for teacher
    public List<String> listForTeacher(String name){
        List<String> ss = new ArrayList<>();
        if(studentTeacherMapping.containsKey(name))
            ss = studentTeacherMapping.get(name);
        return ss;
    }

    //Get All Students
    public List<String> allStudent(){

        return new ArrayList<>(studentMap.keySet());
    }

    //Delete a teacher and its Students
    public void deleteTeachersStudents(String name){
        List<String> st = new ArrayList<>();
        if(studentTeacherMapping.containsKey(name)) {
            st = studentTeacherMapping.get(name);
            for(String student: st) {
                studentMap.remove(student);
            }
            studentTeacherMapping.remove(name);
        }
        if(teacherMap.containsKey(name)){
            teacherMap.remove(name);
        }


    }

    //Delete all teachers and all Students

    public void deleteAll(){
        studentMap = new HashMap<>();
        teacherMap = new HashMap<>();
        studentTeacherMapping = new HashMap<>();
    }
}
