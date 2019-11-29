package com.spring.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Student;
import com.spring.repositories.StudentRepository;
import com.spring.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentService StudentService;
	
	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}

	@Override
	public List<Student> findBystudentName(String studentName) {
		// TODO Auto-generated method stub
		return studentRepository.findByStudentNameContaining(studentName);
	}

	@Override
	public Student findByStudentId(int studentId) {
		// TODO Auto-generated method stub
		return studentRepository.findByStudentId(Long.valueOf(studentId));
	}

}
