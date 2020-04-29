package com.syncbyte.registration.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syncbyte.registration.entity.CheckIn;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Long> {

}
