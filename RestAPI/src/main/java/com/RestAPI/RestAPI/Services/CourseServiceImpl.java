package com.RestAPI.RestAPI.Services;

import com.RestAPI.RestAPI.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    // List to store courses (In-memory storage for simplicity)
    private List<Course> list;

    // Constructor to initialize the list with some dummy data
    public CourseServiceImpl() {
        list = new ArrayList<>();
        list.add(new Course(123, "Java Core Course", "This course contains basics of Java"));
        list.add(new Course(124, "Spring Boot Course", "This course covers Creating REST APIs using Spring Boot"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        // Search for the course by its ID
        for (Course course : list) {
            if (course.getId() == courseId) {
                return course;
            }
        }
        return null; // Return null if the course is not found
    }

    @Override
    public Course addCourse(Course course) {
        // Add a new course to the list
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        // Find the course by ID and update it
        for (int i = 0; i < list.size(); i++) {
            Course existingCourse = list.get(i);

            // Use primitive '==' to compare long values
            if (existingCourse.getId() == course.getId()) {
                // Replace the old course with the updated one
                list.set(i, course);
                return course;
            }
        }


        return null;
    }

    @Override
    public Course deleteCourse(Course course) {
        return null;
    }

    @Override
    public boolean deleteCourse(long courseId) {
        // Find the course by ID and remove it
        for (int i = 0; i < list.size(); i++) {
            Course course = list.get(i);
            if (course.getId() == courseId) {
                list.remove(i); // Remove the course from the list
                return true; // Return true if the course was deleted
            }
        }
        return false; // Return false if the course was not found
    }

}
