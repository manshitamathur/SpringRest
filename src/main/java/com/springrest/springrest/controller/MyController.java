package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService cs;
	

	@GetMapping("/home")
	public String home() {
		return "This is HomePage";
	}
	
	//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.cs.getCourses();
	}
	
	//GET THE PARTICULAR COURSE BY COURSEID
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId)
	{
		return this.cs.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping(path="/courses",consumes="application/json")
	public Course addCourse(@RequestBody Course course) 
	{
	 return this.cs.addCourse(course);
	}
	
	
	
}
