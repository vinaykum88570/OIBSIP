	package com.atm.machine;
	
	import java.util.Scanner;
	
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.context.ApplicationContext;
	
	import com.atm.machine.entity.ATMRegister;
import com.atm.machine.entity.Account;
import com.atm.machine.operation.ATMOperation;
	import com.atm.machine.service.LoginService;
	
	
	
	
	@SpringBootApplication
	public class OIBSIPOnlineReservationSystemApplication {
	
		private static Scanner scanner;
		private static Integer id = null;
		
		public static void main(String[] args) {
			ApplicationContext container = SpringApplication.run(OIBSIPOnlineReservationSystemApplication.class, args);
			LoginService login = container.getBean("login",LoginService.class);
			ATMOperation ops = container.getBean("operation",ATMOperation.class);
			
			
			while(true) {
				scanner = new Scanner(System.in);
				System.out.println("Welcome ATM Machine ");
				System.out.println("1] Register ATM");
				System.out.println("2] Login ATM");
				
				switch(scanner.nextInt()) {
				
				case 1: // User Register(Login Credentials)
					    System.out.println(login.register());
					    break;
					
				case 2: // Login Credentials	
					    System.out.println("Enter Login Details ");
					    System.out.print("Enter Login Id ");
					    id = scanner.nextInt();
					    System.out.print("Enter Login Pin ");
					    int pin = scanner.nextInt();
					    
			            ATMRegister byPin = login.login(id, pin);
			            if(byPin != null) {
			       		 if(id.equals(byPin.getId())) {
			       	    	    if(pin == (byPin.getPin()))
			       	    	    	System.out.println("Login SuccessFull  ");
			       	    	    
			       	    	 boolean isLoggedIn = true;

			       	    	while (isLoggedIn) {

			       	    	    System.out.println("========================================================");
			       	    	    System.out.println("1] Transaction History");
			       	    	    System.out.println("2] Withdraw");
			       	    	    System.out.println("3] Deposit");
			       	    	    System.out.println("4] Transfer");
			       	    	    System.out.println("5] Quit");

			       	    	    int choice = scanner.nextInt();

			       	    	    switch (choice) {
                                
			       	    	        case 1:
			       	    	            // Transaction History
			       	    	            System.out.print("Enter ID For Transaction History: ");
			       	    	            Integer transactionId = scanner.nextInt();
			       	    	        	ops.transaction(transactionId);
			       	    	            break;

			       	    	        case 2: // Withdraw
			       	    	            System.out.print("Enter Withdraw Amount: ");
			       	    	            double withdrawAmount = scanner.nextDouble();
			       	    	        	ops.withdrawOperation(id, withdrawAmount);
			       	    	            break;

			       	    	        case 3:
			       	    	         	System.out.print("Enter  Id: ");
			       	    	            int id = scanner.nextInt();
			       	    	            System.out.print("Enter Deposit Amount: ");
			       	    	            double depositeAmount = scanner.nextDouble();
			       	    	            ops.depositOperation(id, depositeAmount);
			       	    	            break;

			       	    	        case 4:
			       	    	            // Transfer
			       	    	        	System.out.print("Enter Transefer Amount: ");
			       	    	            double transferamount = scanner.nextDouble();
			       	    	            System.out.print("Enter Receiver Id: ");
			       	    	            int receiverId = scanner.nextInt();  
			       	    	            System.out.print("Enter Sender Id: ");
			       	    	            int senderid = scanner.nextInt();
			       	    	            ops.transferMoney(senderid, transferamount, receiverId);
			       	    	            break;

			       	    	        case 5:
			       	    	            System.out.println("Logging out...");
			       	    	            isLoggedIn = false; // EXIT LOOP
			       	    	            break;

			       	    	        default:
			       	    	            System.out.println("Enter Valid Number");
			       	    	    }
			       	    	}
			       		 }else {
			       			System.out.println("Login Failed");
			       		 }
			       		}else {
			       			System.out.println("Login Failed");
			       		 }
					                 
				}	
			}	
			
			
			
		}
	}
