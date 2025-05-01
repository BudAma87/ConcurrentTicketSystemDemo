package com.university.assignment;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
	
	 private final List<String> tickets = new ArrayList<>();

	    // Add ticket (Producer or Writer will call this)
	    public synchronized void addTicket(String ticket) {
	        tickets.add(ticket);
	        System.out.println(Thread.currentThread().getName() + " added: " + ticket);
	    }
	    
	    // Buy ticket (Consumer will call this)
	    public synchronized String buyTicket() {
	        if (!tickets.isEmpty()) {
	            String ticket = tickets.remove(0);
	            System.out.println(Thread.currentThread().getName() + " bought: " + ticket);
	            return ticket;
	        } else {
	            System.out.println(Thread.currentThread().getName() + " tried to buy, but no tickets available");
	            return null;
	        }
	    }

	    // Read available ticket count (Reader will call this)
	    public synchronized int getTicketCount() {
	        return tickets.size();
	    }


}

