package com.university.assignment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TicketPoolLockBased {
	 private final List<String> tickets = new ArrayList<>();
	 private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	// Add ticket (Producer or Writer will call this)
	    public void addTicket(String ticket) {
	        lock.writeLock().lock();
	        try {
	            tickets.add(ticket);
	            System.out.println(Thread.currentThread().getName() + " added: " + ticket);
	        } finally {
	            lock.writeLock().unlock();
	        }
	    }

	    // Buy ticket (Consumer will call this)
	    public String buyTicket() {
	        lock.writeLock().lock();
	        try {
	            if (!tickets.isEmpty()) {
	                String ticket = tickets.remove(0);
	                System.out.println(Thread.currentThread().getName() + " bought: " + ticket);
	                return ticket;
	            } else {
	                System.out.println(Thread.currentThread().getName() + " tried to buy, but no tickets available");
	                return null;
	            }
	        } finally {
	            lock.writeLock().unlock();
	        }
	    }

	    // Read available ticket count (Reader will call this)
	    public int getTicketCount() {
	        lock.readLock().lock();
	        try {
	            return tickets.size();
	        } finally {
	            lock.readLock().unlock();
	        }
	    }
	}
