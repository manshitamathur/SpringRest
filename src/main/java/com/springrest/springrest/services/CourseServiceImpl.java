package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

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
	
}
