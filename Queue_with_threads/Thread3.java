package com.company;

public class Thread3 extends Thread {
    private PriorityQueue pq;
    private int count = 0;
    private int wxh;

    public Thread3(){}
    public Thread3(int wxh,PriorityQueue pq){
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
               System.out.println("Thread3-PQEUC: [" + temp.getRed() + ", " + temp.getGreen() + ", " + temp.getBlue() + "]");
                count++;
            }

        }

    }

    public PriorityQueue getPq() {
        return pq;
    }
}
