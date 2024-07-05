package es.hugoalvarezajenjo.studentmanager.service;

import es.hugoalvarezajenjo.studentmanager.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    Student save(Student student);

    Student getStudentById(long id);

    Student update(Student student);

    void deleteById(long id);
}
