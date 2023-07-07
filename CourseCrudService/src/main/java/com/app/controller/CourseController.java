package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDTO;
import com.app.dto.ReqNameDTO;
import com.app.entities.Course;
import com.app.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	public CourseController() {
		System.out.println("in def ctor of " + getClass());
	}

	@Autowired
	private CourseService courseService;

	@GetMapping
	public List<Course> listCourse() {
		return courseService.getAllCourses();
	}

	@PostMapping
	public ResponseEntity<?> saveCourse(@RequestBody Course transientCourse) {

		return new ResponseEntity<>(courseService.addCourse(transientCourse), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> updateCourse(@RequestBody Course detachedCourse) {

		return new ResponseEntity<>(courseService.updateCourseDetails(detachedCourse), HttpStatus.OK);
	}

	@DeleteMapping("/{cid}")
	public ApiResponse deleteCourse(@PathVariable Long cid ) {
		
		return new ApiResponse(courseService.deleteCourse(cid));
	}
	
	@GetMapping("/search/{cname}")
	public CourseDTO getCourseByName(@Valid ReqNameDTO name) {
		
		return courseService.getCourseByName(name);
	}
	
	
}
