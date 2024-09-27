/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerproducers;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davidmizrahi
 */
public class PlaqueProducer extends Producer {
    public static final int STORE_CAPACITY = 25;
    
    static{
        store_counter = 0;
    }
    
    private static final Semaphore semaphore = new Semaphore(1);
    public PlaqueProducer(int salary, int time_sleep){
        super(salary, time_sleep);
        
    }

    public static int getStore_counter() {
        return store_counter;
    }

    public static void setStore_counter(int store_counter) {
        Producer.store_counter = store_counter;
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
      public void incrementCounter(){
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "is working...");
            
            Thread.sleep(time_sleep);
            store_counter++;
            semaphore.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(RAMProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      
    @Override
    public void run(){
        System.out.println("hello from thread" + Thread.currentThread().getName());
       while(store_counter < STORE_CAPACITY) {
        incrementCounter(); // increment with Semaphore control
        if(store_counter == STORE_CAPACITY){
            System.out.println(Thread.currentThread().getName() + "Reached capacity.");
            break; // exit when full
        }
    }
        
    }
    
    
}
