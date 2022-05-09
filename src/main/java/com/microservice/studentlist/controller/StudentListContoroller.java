package com.microservice.studentlist.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.studentlist.model.StudentDetails;
import com.microservice.studentlist.model.StudentGradesDto;
import com.microservice.studentlist.model.StudentInfo;
import com.microservice.studentlist.model.Student;

@RestController
@RequestMapping("/student-list")
public class StudentListContoroller {
	
	@Autowired
	RestTemplate restTemplate;
	
	private static List<Student> students = Arrays.asList(new Student(1, "1123", "Marko", "Marković"),
			new Student(2, "1124", "Žarko", "Žarković"),
			new Student(3, "1125", "Janko", "Janković"),
			new Student(4, "1126", "Stanko", "Stanković"));
	
	@GetMapping("/all")
	public List<StudentDetails> findAll(){
		List<StudentDetails> studentDetailsList = new ArrayList<StudentDetails>();
		for (Student student : students) {
			StudentInfo studentInfo = restTemplate.getForObject("http://localhost:8082/student-info?index="+student.getIndex(), StudentInfo.class);
			StudentGradesDto studentGradesDto = restTemplate.getForObject("http://localhost:8083/student-grades?index="+student.getIndex(), StudentGradesDto.class);
			studentDetailsList.add(buildStudentDetails(student, studentInfo, studentGradesDto));
		}
		return studentDetailsList;
	}
	
	@GetMapping
	public StudentDetails findByIndex(@RequestParam("index") String index) throws Exception {
		Student student = students.stream().filter(e -> e.getIndex().equals(index)).findFirst()
				.orElseThrow(() -> new Exception("Nije pronađen student sa indexom: "+index+"!"));
		StudentInfo studentInfo = restTemplate.getForObject("http://localhost:8082/student-info?index="+student.getIndex(), StudentInfo.class);
		StudentGradesDto studentGradesDto = restTemplate.getForObject("http://localhost:8083/student-grades?index="+student.getIndex(), StudentGradesDto.class);
		return buildStudentDetails(student, studentInfo, studentGradesDto);
	}
	
	private StudentDetails buildStudentDetails(Student student, StudentInfo studentInfo, StudentGradesDto studentGradesDto) {
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setAdress(studentInfo.getAdress());
		studentDetails.setDepartmentOfStudy(studentInfo.getDepartmentOfStudy());
		studentDetails.setEmail(studentInfo.getEmail());
		studentDetails.setFirstName(student.getFirstName());
		studentDetails.setLastName(student.getLastName());
		studentDetails.setPhoneNumber(studentInfo.getPhoneNumber());
		studentDetails.setYearOfStudy(studentInfo.getYearOfStudy());
		studentDetails.setIndex(student.getIndex());
		studentDetails.setGrades(studentGradesDto.getStudentGrades());
		return studentDetails;
	}
}
