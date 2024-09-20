package org.generation;

import org.generation.classes.Student;
import org.generation.classes.StudentService;
import org.generation.exceptions.CourseNotFoundException;
import org.generation.exceptions.StudentNotFoundException;

public class Main {

    public static void main(String[] args) {
	    StudentService studentService = new StudentService();
	    //TODO refactor this code to use encapsulation inside studentsService
        studentService.setStudents(new Student("Carlos", "1030", 31 ));
        studentService.setStudents(new Student( "Ian", "1020", 28 ) );
        studentService.setStudents(new Student( "Elise", "1040", 26 ) );
        studentService.setStudents(new Student( "Santiago", "1050", 33 ) );

        try {
        	studentService.enrollStudents( "Physics", "1030");
        	studentService.enrollStudents( "Math", "1050" );
        	studentService.enrollStudents( "Math", "1030" );
            studentService.enrollStudents( "Math", "1040" );
        studentService.enrollStudents( "Maths", "1050" );//Prueba error course
        }catch(CourseNotFoundException |StudentNotFoundException e) {
        	System.out.println(e.getMessage());
        }

        try {
        studentService.enrollStudents( "Math", "10" );//Prueba error student
        }catch(CourseNotFoundException |StudentNotFoundException e) {
        	System.out.println(e.getMessage());
        }
        
        studentService.showEnrolledStudents("1050");// Materia errónea
        studentService.showAllCourses(); 
        
        try {
        studentService.unEnrollStudents( "Maths", "1050" );//Prueba error course
        }catch(CourseNotFoundException |StudentNotFoundException e) {
        	System.out.println(e.getMessage());
        }
        
        try {
        studentService.unEnrollStudents( "Math", "100" );//Prueba error student
        }catch(CourseNotFoundException |StudentNotFoundException e) {
        	System.out.println(e.getMessage());
        }
        
        try {
        studentService.unEnrollStudents( "Math", "1060" );//Prueba error student
        }catch(CourseNotFoundException |StudentNotFoundException e) {
        	System.out.println(e.getMessage());
        }
        
        studentService.showEnrolledStudents("Math");
        studentService.showEnrolledStudents("Physics");
        studentService.showEnrolledStudents("Physics2");//Prueba con materia errónea
    }
}
