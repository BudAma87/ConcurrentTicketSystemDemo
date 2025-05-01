package com.university.assignment;

public class Writer implements Runnable {
    private final TicketPool pool;

    public Writer(TicketPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        int count = 1000; // Writer uses different ticket numbers
        while (true) {
            String ticket = "WriterTicket-" + count++;
            pool.addTicket(ticket);
            System.out.println(Thread.currentThread().getName() + " added: " + ticket);
            try {
                Thread.sleep(3000); // Add ticket every 3 seconds
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }
}