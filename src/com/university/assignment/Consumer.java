package com.university.assignment;

public class Consumer implements Runnable {
    private final TicketPool pool;

    public Consumer(TicketPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            pool.buyTicket();
            try {
                Thread.sleep(1500); // Buy ticket every 1.5 seconds
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }
}