package org.generation.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.Map;
//import java.util.Set;

import org.generation.exceptions.CourseNotFoundException;
import org.generation.exceptions.StudentNotFoundException;

public class StudentService
{
	// Propiedades
   private HashMap<String, Course> courseList = new HashMap<>();

   private HashMap<String, Student> students = new HashMap<>();

   private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();


    public StudentService()
    {
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    }//constructor

    
    public void enrollStudents( String courseName, String studentID ) throws CourseNotFoundException, StudentNotFoundException
    {
    	if(courseList.containsKey(courseName)) {
    		Course course = courseList.get( courseName );
    		if(students.containsKey(studentID)) {
    			if ( !coursesEnrolledByStudents.containsKey( studentID ) )
            {
                coursesEnrolledByStudents.put( studentID, new ArrayList<>() );
                
            }
    			if(!coursesEnrolledByStudents.get( studentID ).contains(course)) {
    				coursesEnrolledByStudents.get( studentID ).add( course );
    				System.out.println("Student with ID "+studentID+" was enrolled in "+courseName);
        	} else { 
        		System.out.println("\nCourse "+courseName+" was enrolled before for student with ID "+studentID);
        	}
    			}else {
        		throw new StudentNotFoundException("\nStudent with ID "+studentID+" wasn't found in "+courseName+"!" );
    		}
	
    	}else {
    		throw new CourseNotFoundException("\n"+courseName+" wasn't found!");
    	}
    }//enrollStudents()

    
    public void unEnrollStudents( String courseName, String studentID ) throws CourseNotFoundException, StudentNotFoundException
    {
    	if(courseList.containsKey(courseName)) {
        Course course = courseList.get( courseName );
        if(students.containsKey(studentID)) {
        if ( coursesEnrolledByStudents.containsKey( studentID ) )
        {
            coursesEnrolledByStudents.get( studentID ).remove( course );
            System.out.println("Student with ID "+studentID+" was unenrolled from "+courseName);
        }
    	}else {
    		throw new StudentNotFoundException("\nStudent with ID "+studentID+" wasn't found in "+courseName+"!");
		}}
    	else {
    		throw new CourseNotFoundException("\n"+courseName+" wasn't found!");
    	}
    }//unEnrollStudents(

    
    public void showEnrolledStudents(String courseId){
        //TODO implement using collections loops   	
    	if(courseList.containsKey(courseId)) {
    	Course course = courseList.get(courseId);
    	System.out.println("\nStudents that are enrolled in "+course.getName()+" are:");
    	coursesEnrolledByStudents.forEach((studentId, listCourses) -> {
    		if(listCourses.contains(course)) {
    			Student student = students.get(studentId);
    			System.out.println(student);
    		}
    	});
    	}else {
    		System.out.println("\nCourse id "+courseId+" wasn't found");
    	}
    }//showEnrolledStudents(

    public void showAllCourses(){
        //TODO implement using collections loops
    	System.out.println("\n\nCourses are:");
    	for(Course course:courseList.values()) {
    		System.out.println(course.toString());
    	}
    }//showAllCourses()
    
    public void setStudents(Student student) {
    	students.put(student.getId(), student);
    }//setStudents()
    
}//class StudentSerice