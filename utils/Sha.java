package utils;

import java.util.List;


public class Sha implements Runnable{
    private int id;

    public Sha(int _id){
        id = _id;
    }

    private void process(String line) {
        double alpha = Math.random(); // already gives number between 0 and 1
        double sleepTime = alpha * id + 1;

        try {
            Thread.sleep((int)Math.floor(sleepTime));
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
    }

    public void run(){
    }
}


