package com.university.assignment;

public class SimulationManagerBlockingQueue {
    public static void main(String[] args) {
        // Create BlockingQueue pool with maximum 10 tickets
        TicketPoolBlockingQueue pool = new TicketPoolBlockingQueue(10);

        // Create threads
        Thread producer1 = new Thread(() -> {
            int count = 0;
            while (true) {
                String ticket = "Ticket-" + count++;
                pool.addTicket(ticket);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        }, "Producer-1");

        Thread consumer1 = new Thread(() -> {
            while (true) {
                pool.buyTicket();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        }, "Consumer-1");

        Thread consumer2 = new Thread(() -> {
            while (true) {
                pool.buyTicket();
                try {
                    Thread.sleep(1800);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        }, "Consumer-2");

        Thread reader1 = new Thread(() -> {
            while (true) {
                int count = pool.getTicketCount();
                System.out.println(Thread.currentThread().getName() + " checked tickets: " + count);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        }, "Reader-1");

        Thread writer1 = new Thread(() -> {
            int count = 1000;
            while (true) {
                String ticket = "WriterTicket-" + count++;
                pool.addTicket(ticket);
                System.out.println(Thread.currentThread().getName() + " added: " + ticket);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        }, "Writer-1");

        // Start all threads
        producer1.start();
        consumer1.start();
        consumer2.start();
        reader1.start();
        writer1.start();
    }
}
