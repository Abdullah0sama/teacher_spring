package com.teacher.teacher_api.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path ="teacher")
public class TeacherController {

    private TeacherService teacherService;
    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping()
    List<Teacher> getTeachers() {
        return this.teacherService.getTeachers();
    }

    @GetMapping(value = "{email}")
    Teacher getTeacherByMail(@PathVariable String email) {
        return this.teacherService.getTeacherByEmail(email);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Teacher createTeacher(@RequestBody Teacher createTeacherDto) {
        return this.teacherService.createTeacher(createTeacherDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTeacher(@PathVariable Integer id) {
        this.teacherService.deleteTeacher(id);
    }
}
