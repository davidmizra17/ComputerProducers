/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerproducers;

/**
 *
 * @author davidmizrahi
 */
public abstract class Producer extends Thread{
    
    protected static int store_counter;
    public int salary_per_hour;
    public int time_sleep;
    
    public Producer(int salary, int time){
        salary_per_hour = salary;
        time_sleep = time;
    }
    
    public abstract void incrementCounter();
    
}
