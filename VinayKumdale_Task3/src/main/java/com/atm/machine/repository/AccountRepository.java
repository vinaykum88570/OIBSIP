	package com.atm.machine.repository;
	
	import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atm.machine.entity.Account;
	
	@Repository
	public interface AccountRepository extends JpaRepository<Account, Integer> {
	
		
		public Optional findById(Integer id);
	}
