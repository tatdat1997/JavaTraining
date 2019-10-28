package com.springboothello.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboothello.entity.StudentInfo;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create StudentInfoRepository interface
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

@Repository
public interface StudentInfoRepository extends CrudRepository<StudentInfo, Serializable> {

	StudentInfo findByinfoId(Long info_id);

	List<StudentInfo> findAll();

}
