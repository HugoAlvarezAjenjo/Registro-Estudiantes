package es.hugoalvarezajenjo.studentmanager.controllers;

import es.hugoalvarezajenjo.studentmanager.entity.Student;
import es.hugoalvarezajenjo.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping({"/estudiantes", "/"})
    public String getAllStudents(Model model) {
        model.addAttribute("students", this.studentService.getAll());
        return "students";
    }

    @GetMapping("/estudiantes/nuevo")
    public String createStudent(Model model) {
        final Student student = new Student();
        model.addAttribute("student", student);
        return "crear_estudiante";
    }

    @PostMapping("/estudiantes/nuevo")
    public String saveStudent(@ModelAttribute("student") final Student student) {
        this.studentService.save(student);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/editar/{id}")
    public String editStudent(@PathVariable final long id, Model model) {
        model.addAttribute("student", this.studentService.getStudentById(id));
        return "editar_estudiante";
    }

    @PostMapping("/estudiantes/editar/{id}")
    public String updateStudent(@PathVariable final long id, @ModelAttribute("student") final Student student) {
        final Student actualStudent = this.studentService.getStudentById(id);
        actualStudent.setId(id);
        actualStudent.setName(student.getName());
        actualStudent.setSurname(student.getSurname());
        actualStudent.setEmail(student.getEmail());
        this.studentService.update(actualStudent);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/delete/{id}")
    public String deleteStudent(@PathVariable final long id) {
        this.studentService.deleteById(id);
        return "redirect:/estudiantes";
    }

}
