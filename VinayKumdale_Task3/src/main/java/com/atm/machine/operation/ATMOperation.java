package com.atm.machine.operation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atm.machine.entity.ATMRegister;
import com.atm.machine.entity.Account;
import com.atm.machine.entity.ReceiverAccount;
import com.atm.machine.entity.SenderAccount;
import com.atm.machine.repository.ATMRepository;
import com.atm.machine.repository.AccountRepository;
import com.atm.machine.repository.ReceiverRepository;
import com.atm.machine.repository.SenderRepository;

@Component("operation")
public class ATMOperation {

	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private ATMRepository repo;
	
	@Autowired
	private SenderRepository sendRepo;
	
	@Autowired
	private ReceiverRepository receiveRepo;
	
	public void depositOperation(Integer id, double depositAmount) {

	    ATMRegister register = findById(id);

	    Account account = (Account) repository.findById(id).orElse(null);

	    if (account != null) {
	        // UPDATE existing account
	        account.setBalance(account.getBalance() + depositAmount);

	        System.out.println("Amount Deposited: " + depositAmount);
	        System.out.println("Updated Balance: " + account.getBalance());

	        repository.save(account); // ✔ UPDATE
	    } else {
	        // CREATE new account (first time)
	        Account newAccount = new Account();
	       
	        newAccount.setName(register.getName());
	        newAccount.setPin(register.getPin());
	        newAccount.setBalance(depositAmount);

	        System.out.println("Account created & Amount Deposited: " + depositAmount);

	        repository.save(newAccount); // ✔ INSERT
	    }
	}
	
	
	
	// Register Login Data find
	public ATMRegister findById(Integer id) {
		ATMRegister register = repo.findById(id).get();
		return register;
	}
	
	// Withdraw Available Balance
	public Account availableBalance(Integer id ) {
		Account account = (Account) repository.findById(id).get();
		return account;
	}
	
	
	// Withdraw Operation
	public void withdrawOperation(Integer id , double withdrawAmount) {
		ATMRegister register = findById(id);
		Account account = (Account)repository.findById(id).get();
		if(withdrawAmount < account.getBalance()) {
			account.setBalance(account.getBalance() - withdrawAmount);
			System.out.println("Withdraw Successful "+withdrawAmount);
			System.out.println("Remaining Balance "+account.getBalance());
			repository.save(account);
		}else {
			System.out.println("Insufficient Balance ");
		}
			
	}
	
	
	
	public void transferMoney(Integer senderId, double transferamount, Integer receiverId) {
	    
	    // ADD THIS LINE - FIXES YOUR ERROR
	    if(!repository.findById(senderId).isPresent() || !repository.findById(receiverId).isPresent()) {
	        System.out.println("Account not found! Please check sender and receiver IDs.");
	        return;
	    }
	    
	    Account account = (Account)repository.findById(senderId).get();
	    SenderAccount sender = new SenderAccount();
	    if(transferamount <= account.getBalance()) { 
	        account.setBalance(account.getBalance() - transferamount);
	        
	        Account receiverAccount = (Account)repository.findById(receiverId).get();
	        receiverAccount.setBalance(receiverAccount.getBalance() + transferamount);
	        
	        System.out.println("Transfer Amount: "+transferamount);
	        System.out.println("Sender Remaining Balance: "+account.getBalance());
	        System.out.println("Receiver New Balance: "+receiverAccount.getBalance());
	        
	        repository.save(account);
	        repository.save(receiverAccount);
	        
	        // Sender Data Save
	        Account send = (Account)repository.findById(senderId).get();
	        sender.setSenderName(send.getName());
	        sender.setId(send.getId());
	        sender.setTranseferBalance(transferamount);
	        Account send1 = (Account)repository.findById(receiverId).get();
	        sender.setReceiverName(send1.getName());
	        sendRepo.save(sender);
	        
	        // Receiver Data Save
	        Account sendAccount = (Account)repository.findById(receiverId).get();
	        ReceiverAccount receiver = new ReceiverAccount();
	        receiver.setId(sendAccount.getId());
	        receiver.setReceiveBalance(transferamount);
	        receiver.setReceiverName(sendAccount.getName());
	        receiver.setSenderName(account.getName());
	        receiveRepo.save(receiver);
	        
	        System.out.println("Transaction Completed");
	        
	    } else {
	        System.out.println("Insufficient Balance! Your balance: " + account.getBalance());
	    }
	}
	
	public void transaction(Integer id) {
	    
	    System.out.println("===========================================");
	    System.out.println("         TRANSACTION HISTORY");
	    System.out.println("===========================================");
	    
	    // Account Details
	    System.out.println("\n ACCOUNT DETAILS:");
	    System.out.println("-------------------------------------------");
	    Account account = (Account)repository.findById(id).get();
	    System.out.println("Account ID: " + account.getId());
	    System.out.println("Account Name: " + account.getName());
	    System.out.println("Current Balance: ₹" + account.getBalance());
	    System.out.println("-------------------------------------------");
	    
	    // Money Sent Transactions
	    System.out.println("\n MONEY SENT (Debit Transactions):");
	    System.out.println("-------------------------------------------");
	    boolean hasTransactions = false;
	    
	    List<SenderAccount> all3 = sendRepo.findAll();
	    for (SenderAccount senderAccount : all3) {
	        if(senderAccount.getId().equals(id)) {
	            hasTransactions = true;
	            System.out.println("  Sent To: " + senderAccount.getReceiverName());
	            System.out.println("  Amount: ₹" + senderAccount.getTranseferBalance());
	            System.out.println("  Type: DEBIT");
	            System.out.println("-------------------------------------------");
	        }
	    }
	    
	    // Money Received Transactions
	    System.out.println("\n MONEY RECEIVED (Credit Transactions):");
	    System.out.println("-------------------------------------------");
	    
	    List<ReceiverAccount> all4 = receiveRepo.findAll();
	    for (ReceiverAccount receiverAccount : all4) {
	        if(receiverAccount.getId().equals(id)) {
	            hasTransactions = true;
	            System.out.println("  Received From: " + receiverAccount.getSenderName());
	            System.out.println("  Amount: " + receiverAccount.getReceiveBalance());
	            System.out.println("  Type: CREDIT");
	            System.out.println("-------------------------------------------");
	        }
	    }
	    
	    if(!hasTransactions) {
	        System.out.println("  No transactions found for this account!");
	        System.out.println("-------------------------------------------");
	    }
	    
	    System.out.println("\n===========================================");
	    System.out.println("\n===========================================");
	    System.out.println("\n===========================================");
	    System.out.println("\n===========================================");
	}
}	  


