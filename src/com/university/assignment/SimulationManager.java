package com.university.assignment;

public class SimulationManager {
    public static void main(String[] args) {
        TicketPool pool = new TicketPool();

        // Create Producer and Consumer threads
        Thread producer1 = new Thread(new Producer(pool), "Producer-1");
        Thread consumer1 = new Thread(new Consumer(pool), "Consumer-1");
        Thread consumer2 = new Thread(new Consumer(pool), "Consumer-2");
        
        Thread reader1 = new Thread(new Reader(pool), "Reader-1"); // New Reader thread
        Thread writer1 = new Thread(new Writer(pool), "Writer-1"); // New Writer thread

        // Start the threads
        producer1.start();
        consumer1.start();
        consumer2.start();
        reader1.start();
        writer1.start();
    }
}