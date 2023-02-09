package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;


@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	public CourseServiceImpl()
	{
		list=new ArrayList<>();
		list.add(new Course(123,"Java Course","Basics of Java covered in detail"));
		list.add(new Course(4567,"Spring Boot Course","Basics of spring framework covered in detail"));
		
	}
	

	@Override
	public List<Course> getCourses() {
		
		return list;
	}
	@Override
	public Course getCourse(long courseId){
		Course c =null;
		for(Course course:list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		return c;
	}
	@Override
	public Course addCourse(Course course)
	{
		list.add(course);
		return course;
	}


	@Override
	public Course updateCourse(Course course) 
	{
		list.forEach(e->{
			if (e.getId()==course.getId()) 
			  {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			  }
		});
		return course;
	}


	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	}
	
	
}
