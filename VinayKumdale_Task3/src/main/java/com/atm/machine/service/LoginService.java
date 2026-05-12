package com.atm.machine.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.machine.entity.ATMRegister;
import com.atm.machine.repository.ATMRepository;

@Service("login")
public class LoginService {

	@Autowired(required=false)
	private ATMRegister register;
	
	@Autowired
	private ATMRepository repository;
	
	private Scanner scanner;
	
	public String register() {
		ATMRegister register = new ATMRegister();
		scanner=new Scanner(System.in);
	    System.out.println("Enter Registration Details:");
	    
	    System.out.print("Enter Name:");
	    register.setName(scanner.next());
	    System.out.print("Enter Pin:");
	    register.setPin(scanner.nextInt());
	    ATMRegister save = repository.save(register);
		return "Registration Successfull.";
	}
	
	public ATMRegister login(Integer id , int pin) {
	    Optional<ATMRegister> user = repository.findById(id);
	    
	    if(user.isPresent() && user.get().getPin() == pin) {
	        return user.get();
	    }
	    return null;
	}

}
