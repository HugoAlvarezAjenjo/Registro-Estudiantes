package es.hugoalvarezajenjo.studentmanager.controllers;

import es.hugoalvarezajenjo.studentmanager.entity.Student;
import es.hugoalvarezajenjo.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

}
