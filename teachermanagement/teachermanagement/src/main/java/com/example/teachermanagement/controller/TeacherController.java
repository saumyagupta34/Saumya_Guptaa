package com.example.teachermanagement.controller;

import com.example.teachermanagement.model.Teacher;
import com.example.teachermanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // POST - Add Teacher
    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    // GET - All Teachers
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    // GET - Teacher By ID
    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable int id) {
        return teacherService.getTeacherById(id);
    }

    // PUT - Update Teacher
    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable int id,
                                 @RequestBody Teacher teacher) {
        return teacherService.updateTeacher(id, teacher);
    }

    // DELETE - Remove Teacher
    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable int id) {
        return teacherService.deleteTeacher(id);
    }
}
