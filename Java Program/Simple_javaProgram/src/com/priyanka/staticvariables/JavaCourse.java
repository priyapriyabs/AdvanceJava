package com.priyanka.staticvariables;

public class JavaCourse {

	int course_id;
	static String course_name;
	String place;
	String coursr_duration;
	
	public JavaCourse(int course_id, String place,String coursr_duration) {
	this.course_id=course_id;
	this.place=place;
	this.coursr_duration=coursr_duration;
	}
	static {
		course_name="JavaCourse";
	}
	
}
