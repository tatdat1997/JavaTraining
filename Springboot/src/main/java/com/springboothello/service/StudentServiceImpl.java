package com.springboothello.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboothello.entity.Student;
import com.springboothello.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	StudentService studentService;

	private List<Student> student = new ArrayList<Student>();

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public List<Student> findAllByAsc() {
		// TODO Auto-generated method stub
		return studentRepo.findAllByAsc();
	}
	
	@Override
	public List<Student> findAllByDesc() {
		// TODO Auto-generated method stub
		return studentRepo.findAllByDesc();
	}
	
	@Override
	public List<Student> findBystudentName(String studentName) {
		// TODO Auto-generated method stub
		List<Student> list = (List<Student>) studentRepo.findAllByAsc();
		List<Student> result = new ArrayList<Student>();
		for (Student student : list) {
			if (student.getStudentName().contains(studentName)) {
				result.add(student);
			}
		}
		return result;
	}

	@Override
	public Student findBystudentId(Long studentId) {
		// TODO Auto-generated method stub
		return studentRepo.findBystudentId(studentId);
	}

	@Override
	public Student deleteBystudentId(Long studentId) {
		// TODO Auto-generated method stub
		return studentRepo.deleteBystudentId(studentId);
	}

	@Override
	public Student findBystudentCode(String studentCode) {
		// TODO Auto-generated method stub
		return findBystudentCode(studentCode);
	}

	@PostConstruct
	private void iniDataForTesting() {
//		student = this.findAll();
		student.addAll(studentRepo.findAll());

	}

	
}
