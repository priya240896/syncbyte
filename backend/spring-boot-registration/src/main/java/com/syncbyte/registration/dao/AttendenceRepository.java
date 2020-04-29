package com.syncbyte.registration.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syncbyte.registration.entity.EmployeeAttendence;
@Repository
public interface AttendenceRepository extends JpaRepository<EmployeeAttendence, Integer> {
	

}
