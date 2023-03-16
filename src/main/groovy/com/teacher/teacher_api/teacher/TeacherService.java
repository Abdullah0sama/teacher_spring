package com.teacher.teacher_api.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    TeacherService(TeacherRepository  teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    public Teacher getTeacherByEmail(String email) {
        return teacherRepository.findTeacherByEmail(email);
    }

    public Teacher createTeacher(Teacher createTeacherDto) {
        return teacherRepository.save(createTeacherDto);
    }

    public void deleteTeacher(Integer id) {
        teacherRepository.deleteById(id);
    }

    public List<Teacher> getTeachers() {
        return this.teacherRepository.findAll();
    }

    public List<Teacher> getTeachersWithPrefix(String prefix) {
        return this.teacherRepository.findTeachersByFirstNameStartsWithIgnoreCaseOrLastNameStartsWithIgnoreCase(prefix, prefix);
    }
}
