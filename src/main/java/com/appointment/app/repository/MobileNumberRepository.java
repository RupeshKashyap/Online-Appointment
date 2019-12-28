package com.appointment.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appointment.app.modaldto.MobileNmber;

@Repository
public interface MobileNumberRepository extends JpaRepository<MobileNmber,Long> {

}
