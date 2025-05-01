package com.university.assignment;

public class Reader implements Runnable {
    private final TicketPool pool;

    public Reader(TicketPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            int availableTickets = pool.getTicketCount();
            System.out.println(Thread.currentThread().getName() + " checked tickets: " + availableTickets);
            try {
                Thread.sleep(2000); // Check tickets every 2 seconds
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }
}