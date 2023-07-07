package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CourseDTO;
import com.app.dto.ReqNameDTO;
import com.app.entities.Course;
import com.app.repository.CourseRepository;

import comm.app.customexception.ResourceNotFoundException;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Course> getAllCourses() {

		return courseRepo.findAll();
	}

	@Override
	public Course addCourse(Course transientCourse) {

		return courseRepo.save(transientCourse);
	}

	@Override
	public Course updateCourseDetails(Course detachedCourse) {

		return courseRepo.save(detachedCourse);
	}

	@Override
	public String deleteCourse(Long cid) {
		String mesg = "Invlid id !!!!!!!";
		if (courseRepo.existsById(cid)) {
			courseRepo.deleteById(cid);
			mesg = "Successfully deleted";
		}
		return mesg;
	}

	@Override
	public CourseDTO getCourseByName(ReqNameDTO name) {

		Course course = courseRepo.findByName(name.getName())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid course Id !!!!!!"));

		CourseDTO couDto = mapper.map(course, CourseDTO.class);
		return couDto;
	}

}
