package es.hugoalvarezajenjo.studentmanager.service;

import es.hugoalvarezajenjo.studentmanager.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student save(Student student);
}