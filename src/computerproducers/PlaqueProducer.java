/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerproducers;

import static computerproducers.RAMProducer.STORE_CAPACITY;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author davidmizrahi
 */
public class PlaqueProducer extends Producer {
    public static final int STORE_CAPACITY = 25;
    private static Semaphore semaphore = new Semaphore(1);
    private static volatile boolean running = true;

    public static int store_counter;
    public JTextField plaqueCounterDisplayer;
    
    public PlaqueProducer(int salary, int time_sleep, JTextField plaqueCounterDisplayer){
        super(salary, time_sleep);
        this.store_counter = 0;
        this.plaqueCounterDisplayer = plaqueCounterDisplayer;
        
    }
    
    public int getStore_capacity() {
        int storecapacity = STORE_CAPACITY;
        return storecapacity;
    }

    public JTextField getPlaqueCounterDisplayer() {
        return plaqueCounterDisplayer;
    }

    public void setPlaqueCounterDisplayer(JTextField plaqueCounterDisplayer) {
        this.plaqueCounterDisplayer = plaqueCounterDisplayer;
    }
    
    
    
    public static int getStore_counter() {
        return store_counter;
    }

    public static void setSemaphore(Semaphore semaphore) {
        PlaqueProducer.semaphore = semaphore;
    }

    public static void setRunning(boolean running) {
        PlaqueProducer.running = running;
    }

    public static void setStore_counter(int store_counter) {
        PlaqueProducer.store_counter = store_counter;
    }

    public int getSalary_per_hour() {
        return salary_per_hour;
    }

    public void setSalary_per_hour(int salary_per_hour) {
        this.salary_per_hour = salary_per_hour;
    }

    public int getTime_sleep() {
        return time_sleep;
    }

    public void setTime_sleep(int time_sleep) {
        this.time_sleep = time_sleep;
    }

    public static Semaphore getSemaphore() {
        return semaphore;
    }
    
    
    @Override
      public synchronized void incrementCounter(){
        try {
            semaphore.acquire();
            if(store_counter < STORE_CAPACITY){
                Thread.sleep(time_sleep);
                store_counter++;
                
                if(getStore_counter() >= 0)plaqueCounterDisplayer.setText(String.valueOf(getStore_counter()));
                
                System.out.println("Plaques Thread: " + Thread.currentThread().getName() + " incremented counter to: " + store_counter);
                
            }else{
                running = false;
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(RAMProducer.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            semaphore.release();
        }
        
    }
      
    @Override
    public void run(){
        
        System.out.println("hello from thread" + Thread.currentThread().getName());
        
        while(running) {
            incrementCounter();
            Thread.yield();// increment with Semaphore control
        }
        
        if(store_counter == STORE_CAPACITY){
                System.out.println("Plaque Producer store limit reached by thread: " + Thread.currentThread().getName());
                
            }
        
    }
    
    
}
