package com.RestAPI.RestAPI.Controller;

import com.RestAPI.RestAPI.Services.CourseService;
import com.RestAPI.RestAPI.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class  MyController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home() {
        return "Welcome to courses application";
    }

    //Get the courses
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();

    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);

    }

    @PutMapping("/courses/{courseId}")
    public Course updateCourse(@PathVariable long courseId, @RequestBody Course course) {
        course.setId(courseId);
        return this.courseService.updateCourse(course);
    }




    }