package com.atm.machine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Receiver_Account")
public class SenderAccount {

	@Id
	private Integer id;
	private String senderName;
	private double transeferBalance;
	private String receiverName;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getTranseferBalance() {
		return transeferBalance;
	}
	public void setTranseferBalance(double transeferBalance) {
		this.transeferBalance = transeferBalance;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	
	public String getsenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	@Override
	public String toString() {
		return "ReceiverAccount [id=" + id + ", senderName=" + senderName + ", transeferBalance=" + transeferBalance + ", receiverName=" + receiverName + "]";
	}

	
	
	
	
}
