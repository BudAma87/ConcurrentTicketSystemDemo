package com.university.assignment;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TicketPoolBlockingQueue {
    private final BlockingQueue<String> tickets;

    public TicketPoolBlockingQueue(int capacity) {
        tickets = new LinkedBlockingQueue<>(capacity);
    }

    // Add ticket (Producer or Writer will call this)
    public void addTicket(String ticket) {
        try {
            tickets.put(ticket); // Automatically blocks if full
            System.out.println(Thread.currentThread().getName() + " added: " + ticket);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted while adding");
            Thread.currentThread().interrupt();
        }
    }

    // Buy ticket (Consumer will call this)
    public String buyTicket() {
        try {
            String ticket = tickets.take(); // Automatically blocks if empty
            System.out.println(Thread.currentThread().getName() + " bought: " + ticket);
            return ticket;
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted while buying");
            Thread.currentThread().interrupt();
            return null;
        }
    }

    // Read available ticket count (Reader will call this)
    public int getTicketCount() {
        return tickets.size();
    }
}

