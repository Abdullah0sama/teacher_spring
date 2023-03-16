package com.teacher.teacher_api.teacher;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Teacher findTeacherByEmail(String email);
    List<Teacher> findTeachersByFirstNameStartsWithIgnoreCaseOrLastNameStartsWithIgnoreCase(String firstNamePrefix, String lastNamePrefix);
}
