package com.onlineReservationSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineReservationSystem.entity.User;
import com.onlineReservationSystem.entity.UserRegister;
import com.onlineReservationSystem.repository.UserRegisterRepostory;
import com.onlineReservationSystem.repository.UserReservationRepository;

@Service
public class UserResservationService {

	@Autowired
	private UserReservationRepository reservationRepository;
	
	@Autowired
	private UserRegisterRepostory registerRepository;
	
	// User Register(Login Credentials)
	public String userRegister(UserRegister user) {
		registerRepository.save(user);
		return "Registration Sucessfully";
	}
	
	// check id and passwor valid or not
	public UserRegister findByPassword(String password){
		return registerRepository.findByPassword(password);
	}
	
	
	
	// Save Reservation Details
	public String saveUserReservation(User user) {
		reservationRepository.save(user);
		return "Sucessfull Reservation";
	}
	
	
	// Cancelled Reservation
    public String cancelReservation(Integer pnr) {
		reservationRepository.deleteById(pnr);
		return "Sucessfull Cancelled Reservation";
	}
	
}
