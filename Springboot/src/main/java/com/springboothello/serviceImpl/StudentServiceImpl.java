package com.springboothello.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboothello.entity.Student;
import com.springboothello.repositories.StudentRepository;
import com.springboothello.service.StudentService;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create StudentServiceImpl class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	StudentService studentService;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepo.findAllByAsc();
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
		List<Student> result = studentRepo.findBystudentName("%" + studentName + "%");
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

	@Override
	public List<Student> findAllStudent(Pageable pageable) {
		// TODO Auto-generated method stub
		List<Student> studentList = studentRepo.findAllStudent(pageable);
		return studentList;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return studentRepo.count();
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		return studentRepo.countByName(name);
	}

	@Override
	public List<Student> findByStudentName(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return studentRepo.findByStudentName(name, pageable);
	}

}
