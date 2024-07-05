package es.hugoalvarezajenjo.studentmanager.service;

import es.hugoalvarezajenjo.studentmanager.entity.Student;
import es.hugoalvarezajenjo.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(final Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public Student getStudentById(final long id) {
        return this.studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student update(final Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public void deleteById(final long id) {
        this.studentRepository.deleteById(id);
    }
}
