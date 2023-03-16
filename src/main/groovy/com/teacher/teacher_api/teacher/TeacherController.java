package com.teacher.teacher_api.teacher;

import com.teacher.teacher_api.teacher.dtos.CreateTeacherDto;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path ="teacher")
public class TeacherController {

    private TeacherService teacherService;
    private ModelMapper modelMapper;

    @Autowired
    public TeacherController(TeacherService teacherService, ModelMapper modelMapper) {
        this.teacherService = teacherService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    List<Teacher> getTeachers() {
        return this.teacherService.getTeachers();
    }

    @GetMapping(value = "{email}")
    Teacher getTeacherByMail(@PathVariable String email) {
        return this.teacherService.getTeacherByEmail(email);
    }

    @GetMapping("/startWith{prefix}")
    List<Teacher> getTeachersStartWithPrefix(@PathVariable String prefix) {
        return this.teacherService.getTeachersWithPrefix(prefix);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Teacher createTeacher(@Valid @RequestBody CreateTeacherDto createTeacherDto) {
        Teacher teacher = modelMapper.map(createTeacherDto, Teacher.class);
        return this.teacherService.createTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTeacher(@PathVariable Integer id) {
        this.teacherService.deleteTeacher(id);
    }
}
