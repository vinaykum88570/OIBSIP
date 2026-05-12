package com.onlineReservationSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlineReservationSystem.entity.User;

@Repository
public interface UserReservationRepository extends  CrudRepository<User, Integer> {


	
}
