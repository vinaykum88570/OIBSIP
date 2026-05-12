package com.onlineReservationSystem;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.onlineReservationSystem.entity.User;
import com.onlineReservationSystem.entity.UserLogin;
import com.onlineReservationSystem.entity.UserRegister;
import com.onlineReservationSystem.service.UserResservationService;

@SpringBootApplication
public class OIBSIPOnlineReservationSystemApplication  {
		private static Scanner scanner; 
		
		public static void main(String[] args) {
			ApplicationContext container = SpringApplication.run(OIBSIPOnlineReservationSystemApplication.class, args);
			UserResservationService userReservation = container.getBean(UserResservationService.class);
			
			while(true) {
				scanner = new Scanner(System.in);
				System.out.println("Welcome Online Reservation System ");
				System.out.println("1] Register");
				System.out.println("2] Login");
				
				switch(scanner.nextInt()) {
				
				case 1: // User Register(Login Credentials)
					    UserRegister userRegister = userRegister();
					    String register1 = userReservation.userRegister(userRegister);
					    System.out.println(register1);
					    break;
					
				case 2: // Login Credentials	
					    UserLogin userLogin = userLogin();
					    UserRegister register2 = userReservation.findByPassword(userLogin.getPassword());
				        if(userLogin.getId().equals(register2.getUserId())) {
				    	    if(userLogin.getPassword().equals(register2.getPassword()))
				    		      System.out.println("Login SuccessFull  ");
				    	    
				    	    
				    	              System.out.println("========================================================");
				    	    
				    	    
				    	                System.out.println("");
							            System.out.println("1] Reservation");
							            System.out.println("2] Cancelled Reservation");
							            scanner = new Scanner(System.in);
							
							            switch (scanner.nextInt()) {
							
							            	case 1: // Save Reservation Details
							            		User user = UserResrvation();
							            		String saveUserReservation = userReservation.saveUserReservation(user);
							            		System.out.println(saveUserReservation);
							            		break;
								
							            	case 2: // Cancelled Reservation
							            		User userPNR = cancelReservation();
							            		String cancelReservation = userReservation.cancelReservation(userPNR.getPnr());
							            		System.out.println(cancelReservation);
							            		break; 
							            }
							
				         }else {
				              System.out.println("Please Enter Valid Id and Password ");
				       }
				}	
			}
	}
		

		// User Register(Login Credentials)
		public static UserRegister userRegister() {
			UserRegister userRegister = new UserRegister();
			scanner = new Scanner(System.in);
			
			System.out.println("Enter Regestration Details:");
			System.out.print("Enter User Name:");
			userRegister.setName(scanner.next());
			
			System.out.print("Enter password:");
			userRegister.setPassword(scanner.next());
			return userRegister;
		}
		
		
		// Login Credentials
		public static UserLogin userLogin() {
			UserLogin userLogin = new UserLogin();
			scanner = new Scanner(System.in);
			
			System.out.println("Enter Login Details:");
			System.out.print("Enter id:");
			userLogin.setId(scanner.nextInt());
			System.out.print("Enter password:");
			userLogin.setPassword(scanner.next());
			
			return userLogin;
		}
		
		
		// Save Reservation Details
		public static User UserResrvation() {
			User user = new User();
			scanner = new Scanner(System.in);
			
			System.out.println("Enter Reservation Details");
			System.out.print("Enter User Name:");
			user.setName(scanner.next());
			System.out.print("Enter Train Number:");
			user.setTrainNumber(scanner.nextInt());
			System.out.print("Enter Train Name:");
			user.setTrainName(scanner.next());
			System.out.print("Enter Class Type:");
			user.setClassType(scanner.next());
			System.out.print("Enter Date Of Journey:");
			user.setDateOfJourney(scanner.next());
			System.out.print("Enter Place_To:");
			user.setPlaceTo(scanner.next());
			System.out.print("Enter Destination:");
			user.setDestination(scanner.next());
			return user;
		}
		
		
		// Cancelled Reservation
		public static User cancelReservation() {
			User user = new User();
			scanner = new Scanner(System.in);
			
			System.out.print("Enter PNR For Cancel Reservation:");
			user.setPnr(scanner.nextInt());
			return user;
		}
		

	

}
