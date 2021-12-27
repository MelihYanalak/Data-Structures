package com.company;

public class Thread4 extends Thread {
    private PriorityQueue pq;
    private int count = 0;
    private int wxh;

    public Thread4(int wxh,PriorityQueue pq){
        this.wxh = wxh;
        this.pq = pq;
    }
    @Override
    public synchronized void run() {
        while (count < wxh) {
            synchronized (pq) {
                while (pq.isEmpty()) {
                    try {
                        pq.wait();
                    } catch (Exception e) {
                    }

                }
                Pixel temp = pq.poll();
                System.out.println("Thread4-PQBMX: [" + temp.getRed() + ", " + temp.getGreen() + ", " + temp.getBlue() + "]");
                 count++;
            }


        }

    }

    public PriorityQueue getPq() {
        return pq;
    }

}
