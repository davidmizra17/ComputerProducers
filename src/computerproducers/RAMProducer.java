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
public class RAMProducer extends Producer{
    
    public static final int STORE_CAPACITY = 55;
    
    static{
            store_counter = 0;
        }
    
    public static int store_counter;
    private static final Semaphore semaphore = new Semaphore(1);
    
    public RAMProducer(int salary, int time_sleep){
        super(salary, time_sleep);
    }
    
    @Override
      public void incrementCounter(){
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " is working...");
            System.out.println(store_counter);
            
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
