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
public class GraphicsCardProducer extends Producer {
    
    public static final int STORE_CAPACITY = 10;
    private static Semaphore semaphore = new Semaphore(1);
    private static volatile boolean running = true;
  
    public static int store_counter;
    
    public GraphicsCardProducer(int salary, int time_sleep){
        super(salary, time_sleep);
       
    }

    public static int getStore_counter() {
        return store_counter;
    }

    public static void setStore_counter(int store_counter) {
        GraphicsCardProducer.store_counter = store_counter;
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

    public static void setSemaphore(Semaphore semaphore) {
        GraphicsCardProducer.semaphore = semaphore;
    }

    public static boolean isRunning() {
        return running;
    }

    public static void setRunning(boolean running) {
        GraphicsCardProducer.running = running;
    }
    
    
    
    @Override
    public synchronized void incrementCounter(){
        try {
            semaphore.acquire();
            if(store_counter < STORE_CAPACITY){
                Thread.sleep(time_sleep);
                store_counter++;
                System.out.println("Graphics Card Thread: " + Thread.currentThread().getName() + " incremented counter to: " + store_counter);
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
                System.out.println("Graphics Card store limit reached by thread: " + Thread.currentThread().getName());
                
            }
        
    }
}
