package com.app.service;

import java.util.List;

import com.app.dto.CourseDTO;
import com.app.dto.ReqNameDTO;
import com.app.entities.Course;

public interface CourseService {

	List<Course> getAllCourses();

	Course addCourse(Course transientCourse);

	Course updateCourseDetails(Course detachedCourse);

	String deleteCourse(Long cid);

	CourseDTO getCourseByName( ReqNameDTO name);

}
