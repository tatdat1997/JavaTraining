package com.spring.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.StudentInfo;

@Repository
public interface StudentInfoRepository extends CrudRepository<StudentInfo, Serializable>{
	
	StudentInfo findByinfoId(Long info_id);

	List<StudentInfo> findAll();
}
