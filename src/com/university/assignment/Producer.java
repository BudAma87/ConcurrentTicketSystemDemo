package com.university.assignment;

public class Producer implements Runnable{
	
    private final TicketPool pool;

    public Producer(TicketPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            String ticket = "Ticket-" + count++;
            pool.addTicket(ticket);
            try {
                Thread.sleep(1000); // Add ticket every 1 second
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted");
                Thread.currentThread().interrupt(); // Good practice
            }
        }
    }
}
