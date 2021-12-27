package com.company;

public class Thread2 extends Thread {
    private PriorityQueue pq;
    private int count = 0;
    private int wxh;

    public Thread2(int wxh,PriorityQueue pq){
        this.wxh = wxh;
        this.pq = pq;
    }

    @Override
    public  synchronized void run() {

        while (count < wxh){
            synchronized (pq) {
                while (pq.isEmpty()) {
                    try {
                        pq.wait();
                    } catch (Exception e) {
                    }

                }
                Pixel temp = pq.poll();
                System.out.println("Thread2-PQLEX: [" + temp.getRed() + ", " + temp.getGreen() + ", " + temp.getBlue() + "]");

                count++;
            }

    }

    }
    public Thread2(){}

    public PriorityQueue getPq() {
        return pq;
    }
}
