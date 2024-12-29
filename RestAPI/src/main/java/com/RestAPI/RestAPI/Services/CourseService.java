package com.RestAPI.RestAPI.Services;

import com.RestAPI.RestAPI.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course>  getCourses();
    public Course getCourse(long courseId);
    public Course addCourse (Course course);
    public Course updateCourse(Course course);
    public Course deleteCourse(Course course);

    boolean deleteCourse(long courseId);
}
