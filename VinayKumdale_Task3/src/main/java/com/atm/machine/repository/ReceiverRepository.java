package com.atm.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atm.machine.entity.ReceiverAccount;

@Repository
public interface ReceiverRepository extends JpaRepository<ReceiverAccount, Integer> {

}
