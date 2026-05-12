package com.onlineReservationSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.onlineReservationSystem.entity.UserRegister;

public interface UserRegisterRepostory extends CrudRepository<UserRegister, Integer> {

	UserRegister findByPassword(String password);

}
