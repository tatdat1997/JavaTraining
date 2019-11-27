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
	
	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}

	@Override
	public List<Student> findStudent(String studentName) {
		// TODO Auto-generated method stub
		return studentRepository.findBystudentName(studentName);
	}

	@Override
	public List<Student> findAllStudentNameByASC() {
		// TODO Auto-generated method stub
		return studentRepository.findAllByAsc();
	}

}
