package com.atm.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atm.machine.entity.ATMRegister;

@Repository
public interface ATMRepository extends JpaRepository<ATMRegister, Integer> {

	public ATMRegister findByPin(int pin);

}
