package com.example.teachermanagement.service;

import com.example.teachermanagement.model.Teacher;
import com.example.teachermanagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(int id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher updateTeacher(int id, Teacher updatedTeacher) {
        Teacher teacher = getTeacherById(id);
        if (teacher != null) {
            teacher.setName(updatedTeacher.getName());
            teacher.setSubject(updatedTeacher.getSubject());
            teacher.setSalary(updatedTeacher.getSalary());
            return teacherRepository.save(teacher);
        }
        return null;
    }

    public String deleteTeacher(int id) {
        teacherRepository.deleteById(id);
        return "Teacher deleted successfully";
    }
}
