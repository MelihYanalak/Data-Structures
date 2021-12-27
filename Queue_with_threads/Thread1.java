package com.company;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Thread1 extends Thread {
    private String fileName;
    private int count = 0;
    private int wxh = 1;
    private PriorityQueue pq2 = new PriorityQueue(new LEX());
    private PriorityQueue pq3 = new PriorityQueue(new EUC());
    private PriorityQueue pq4 = new PriorityQueue(new BMX());

    @Override
    public  synchronized void run() {

                BufferedImage image = null;
                try {
                    // get the BufferedImage, using the ImageIO class
                    image = ImageIO.read(new File(fileName));
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
                int w = image.getWidth();
                int h = image.getHeight();
                wxh = (w * h);
                Thread2 t2 = new Thread2(w * h,pq2);
                Thread3 t3 = new Thread3(w * h,pq3);
                Thread4 t4 = new Thread4(w * h,pq4);
                int i = 0;
                int j = 0;
                while (i < h) {
                    while (j < w) {

                        if (count == 100) {
                            t2.start();
                            t3.start();
                            t4.start();
                        }

                        int pixel = image.getRGB(j, i);
                        int red = (pixel >> 16) & 0xff;
                        int green = (pixel >> 8) & 0xff;
                        int blue = (pixel) & 0xff;
                        System.out.println("Thread 1: [" + red + ", " + green + ", " + blue + "]");

                        Pixel p = new Pixel(red, green, blue);
                        synchronized (pq2) {
                            pq2.offer(p);
                            pq2.notifyAll();
                        }
                        synchronized (pq3) {
                            pq3.offer(p);
                            pq3.notifyAll();
                        }
                        synchronized (pq4) {
                            pq4.offer(p);
                            pq4.notifyAll();


                        }



                        count++;
                        j++;
                    }
                    j = 0;
                    i++;

                }


    }
    public Thread1(String fileName){
        this.fileName = fileName;
    }

}
