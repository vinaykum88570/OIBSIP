package com.atm.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atm.machine.entity.ReceiverAccount;
import com.atm.machine.entity.SenderAccount;

@Repository
public interface SenderRepository extends JpaRepository<SenderAccount, Integer> {

}
