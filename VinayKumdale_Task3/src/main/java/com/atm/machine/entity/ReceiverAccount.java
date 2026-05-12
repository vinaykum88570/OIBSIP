package com.atm.machine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Sender_Account")
public class ReceiverAccount {

    @Id
	private Integer id;
	private String receiverName;
	private double receiveBalance;
	private String senderName;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public double getReceiveBalance() {
		return receiveBalance;
	}
	public void setReceiveBalance(double receiveBalance) {
		this.receiveBalance = receiveBalance;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	public String getName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	
	@Override
	public String toString() {
		return "ReceiverAccount [id=" + id + ", receiverName=" + receiverName + ", receiveBalance=" + receiveBalance
				+ ", senderName=" + senderName + "]";
	}
	
	
	
	
}
