package com.onlineReservationSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="ors_User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pnr")
	private Integer pnr;
	
	@Column(name="name")
	private String name;
	
	@Column(name="train_Number")
	private int trainNumber;
	
	@Column(name="train_Name")
	private String trainName;
	
	@Column(name="class_Type")
	private String classType;
	
	@Column(name="date_Of_Journey")
	private String dateOfJourney;
	
	@Column(name="place_To")
	private String placeTo;
	
	
	@Column(name="destination")
	private String destination;
	
	public Integer getPnr() {
		return pnr;
	}
	public void setPnr(Integer pnr) {
		this.pnr = pnr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	public String getPlaceTo() {
		return placeTo;
	}
	public void setPlaceTo(String placeTo) {
		this.placeTo = placeTo;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	public User() {
		
	}
	
	public User(String name, int trainNumber, String trainName, String classType, String dateOfJourney,
			String placeTo, String destination) {
		super();
		this.name = name;
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.classType = classType;
		this.dateOfJourney = dateOfJourney;
		this.placeTo = placeTo;
		this.destination = destination;
	}
	
	@Override
	public String toString() {
		return "User [pnr=" + pnr + ", name=" + name + ", trainNumber=" + trainNumber + ", trainName=" + trainName
				+ ", classType=" + classType + ", dateOfJourney=" + dateOfJourney + ", placeTo=" + placeTo
				+ ", destination=" + destination + "]";
	}
	
	
	
}
