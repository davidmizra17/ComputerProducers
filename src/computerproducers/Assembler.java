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
public class Assembler extends Thread {
    
    private static final int STANDARD_COMPUTERS_NEEDED = 5;
    private static final int GRAPHIC_CARD_COMPUTERS = 3;
    
    private int computer_counter;
    private int salary;
    private int sleep_time;
    
    public Assembler(int salary, int sleep_time){
        
        computer_counter = 0;
        this.salary = salary;
        this.sleep_time = sleep_time;
        
    }

    public int getComputer_counter() {
        return computer_counter;
    }

    public void setComputer_counter(int computer_counter) {
        this.computer_counter = computer_counter;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSleep_time() {
        return sleep_time;
    }

    public void setSleep_time(int sleep_time) {
        this.sleep_time = sleep_time;
    }
    
    public void getRAM(int number_of_ram) throws InterruptedException{
        System.out.println("Assembler took control");
        Thread.sleep(sleep_time);
        for (int i = 0; i < number_of_ram; i++) {
            RAMProducer.setStore_counter(RAMProducer.getStore_counter() - 1);
            
        }
        
        
    }
    
//    public void standardComputerAssembly(int plaques_needed, int cpu_needed, int ram_needed, int power_supply_needed){
//        
//        if(PlaqueProducer.store_counter >= plaques_needed && CPUProducer.store_counter >= cpu_needed && RAMProducer.store_counter >= ram_needed && PowerSupplyProducer.store_counter >= power_supply_needed){
//            
//            //GET PLAQUES
//            
//           
//            
//            
//        }
//        
//        
//    }
    
    @Override
    public void run(){
        int ram_counter = 0;
        while(true){
            try {
                System.out.println("Assembler checking for available resources...");

                if(RAMProducer.store_counter >= 1){
                    RAMProducer.getSemaphore().acquire();
                    System.out.println("---------RAM COUNTER BEFORE: " + RAMProducer.store_counter);
                    RAMProducer.setStore_counter(RAMProducer.getStore_counter() - 1);
                    System.out.println("---------RAM COUNTER AFTER: " + RAMProducer.store_counter);
                    ram_counter++;
                    Thread.sleep(sleep_time);
                    
                    if(ram_counter == 8){
                        System.out.println(ram_counter + " RAM READY");
                        break;
                    }
                    RAMProducer.getSemaphore().release();
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Assembler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
