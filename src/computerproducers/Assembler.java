/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerproducers;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author davidmizrahi
 */
public class Assembler extends Thread {
    
    private static int standardComputersNeeded;
    private static int graphicCardComputers;
    
    //SEMAPHORE
    private static Semaphore mutex;
    
    //COUNTERS
    public static int standardComputerCounter;
    public static int graphicCardComputerCounter;
    private int salary;
    private int sleep_time;
    
    
    //HARDWARE REQUIREMENTS
    private int ram_needed;
    private int cpu_needed;
    private int graphicCardsNeeded;
    private int plaques_needed;
    private int power_supply_needed;
    
    //Text Fields GUI
    public JTextField standardComputerCounterDisplayer;
    public JTextField graphicCardComputerCounterDisplayer;
//    private JTextField RAMProduced;
//    private JTextField CPUProduced;
//    private JTextField PowerSupplyProduced;
//    private JTextField GraphicsCardProduced;
//    private JTextField PlaquesProduced;
//    
//    
//    public Assembler(){
//        this.CPUProduced = new JTextField();
//        this.GraphicsCardProduced = new JTextField();
//        this.PlaquesProduced = new JTextField();
//        this.PowerSupplyProduced = new JTextField();
//        this.RAMProduced = new JTextField();
//    }
    
    public Assembler(int salary, 
                     int sleep_time, 
                     int ram_needed, 
                     int cpu_needed, 
                     int graphicCardsNeeded, 
                     int plaques_needed, 
                     int power_supply_needed, 
                     int standardComputersNeeded, 
                     int graphicCardComputers, 
                     JTextField standardComputerCounterDisplayer, 
                     JTextField graphicCardComputerCounterDisplayer
                     ){
        
        standardComputerCounter = 0;
        graphicCardComputerCounter = 0;
        this.standardComputersNeeded = standardComputersNeeded;
        this.graphicCardComputers = graphicCardComputers;
        this.salary = salary;
        this.sleep_time = sleep_time;
        
        //COUNTERS
        
        
        //HARDWARE REQUIREMENTS
        this.ram_needed = ram_needed;
        this.cpu_needed = cpu_needed;
        this.graphicCardsNeeded = graphicCardsNeeded;
        this.plaques_needed = plaques_needed;
        this.power_supply_needed = power_supply_needed;
        
        //SEMAPHORE INITIALIZATION
        this.mutex = new Semaphore(1);
        
        //VARIABLE JTEXTFIELD PARA MOSTRAR EN LA INTERFAZ DE USUARIO
        this.standardComputerCounterDisplayer = standardComputerCounterDisplayer;
        this.graphicCardComputerCounterDisplayer = graphicCardComputerCounterDisplayer;
    }
        
        //Initializa JTextField Variables
        
//        this.CPUProduced = new JTextField();
//        this.GraphicsCardProduced = new JTextField();
//        this.PlaquesProduced = new JTextField();
//        this.PowerSupplyProduced = new JTextField();
//        this.RAMProduced = new JTextField();
//        
//    }
//
//    public void setRAMProduced(JTextField RAMProduced) {
//        this.RAMProduced = RAMProduced;
//    }
//
//    public void setCPUProduced(JTextField CPUProduced) {
//        this.CPUProduced = CPUProduced;
//    }
//
//    public void setPowerSupplyProduced(JTextField PowerSupplyProduced) {
//        this.PowerSupplyProduced = PowerSupplyProduced;
//    }
//
//    public void setGraphicsCardProduced(JTextField GraphicsCardProduced) {
//        this.GraphicsCardProduced = GraphicsCardProduced;
//    }
//
//    public void setPlaquesProduced(JTextField PlaquesProduced) {
//        this.PlaquesProduced = PlaquesProduced;
//    }

    public int getStandardComputerCounter() {
        return standardComputerCounter;
    }

    public void setStandardComputerCounter(int standardComputerCounter) {
        this.standardComputerCounter = standardComputerCounter;
    }

    public JTextField getStandardComputerCounterDisplayer() {
        return standardComputerCounterDisplayer;
    }

    public void setStandardComputerCounterDisplayer(JTextField standardComputerCounterDisplayer) {
        this.standardComputerCounterDisplayer = standardComputerCounterDisplayer;
    }

    public static Semaphore getMutex() {
        return mutex;
    }

    public static void setMutex(Semaphore mutex) {
        Assembler.mutex = mutex;
    }

    public static int getGraphicCardComputerCounter() {
        return graphicCardComputerCounter;
    }

    public static void setGraphicCardComputerCounter(int graphicCardComputerCounter) {
        Assembler.graphicCardComputerCounter = graphicCardComputerCounter;
    }

    public int getRam_needed() {
        return ram_needed;
    }

    public void setRam_needed(int ram_needed) {
        this.ram_needed = ram_needed;
    }

    public int getCpu_needed() {
        return cpu_needed;
    }

    public void setCpu_needed(int cpu_needed) {
        this.cpu_needed = cpu_needed;
    }

    public int getGraphicCardsNeeded() {
        return graphicCardsNeeded;
    }

    public void setGraphicCardsNeeded(int graphicCardsNeeded) {
        this.graphicCardsNeeded = graphicCardsNeeded;
    }

    public int getPlaques_needed() {
        return plaques_needed;
    }

    public void setPlaques_needed(int plaques_needed) {
        this.plaques_needed = plaques_needed;
    }

    public int getPower_supply_needed() {
        return power_supply_needed;
    }

    public void setPower_supply_needed(int power_supply_needed) {
        this.power_supply_needed = power_supply_needed;
    }

    public JTextField getGraphicCardComputerCounterDisplayer() {
        return graphicCardComputerCounterDisplayer;
    }

    public void setGraphicCardComputerCounterDisplayer(JTextField graphicCardComputerCounterDisplayer) {
        this.graphicCardComputerCounterDisplayer = graphicCardComputerCounterDisplayer;
    }
   
    
    public int getComputer_counter() {
        return standardComputerCounter;
    }

    public void setComputer_counter(int computer_counter) {
        this.standardComputerCounter = computer_counter;
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
    
    public void getRAM() throws InterruptedException{
        
        if(RAMProducer.getStore_counter() >= ram_needed){
        
        System.out.println("ASSEMBLER THREAD: " + Thread.currentThread().getName() + " TOOK CONTROL OF RAM");
        
        RAMProducer.getSemaphore().acquire();
        
        System.out.println("---------RAM COUNTER BEFORE: " + RAMProducer.store_counter);
        RAMProducer.setStore_counter(RAMProducer.getStore_counter() - ram_needed);
//        ram_counter++;
//        System.out.println("-------RAM COUNTER FROM ASSEMBLER: " + ram_counter);
        System.out.println("---------RAM COUNTER AFTER: " + RAMProducer.store_counter);
        
        RAMProducer.getSemaphore().release();
        }
        
    }
    public void getCPU() throws InterruptedException{
        
        if(CPUProducer.getStore_counter() >= cpu_needed){
        
        System.out.println("ASSEMBLER THREAD: " + Thread.currentThread().getName() + " TOOK CONTROL OF CPU");
        
        CPUProducer.getSemaphore().acquire();
        
        System.out.println("---------CPU COUNTER BEFORE: " + CPUProducer.store_counter);
        CPUProducer.setStore_counter(CPUProducer.getStore_counter() - cpu_needed);
//        cpu_counter++;
//        System.out.println("----------CPU COUNTER FROM ASSEMBLER: " + cpu_counter);
        System.out.println("---------CPU COUNTER AFTER: " + CPUProducer.store_counter);
        
        CPUProducer.getSemaphore().release();
        }
        
    }
    public void getGraphicsCard() throws InterruptedException{
        
        if(GraphicsCardProducer.getStore_counter() >= graphicCardsNeeded){
            
        
        System.out.println("ASSEMBLER THREAD: " + Thread.currentThread().getName() + " TOOK CONTROL OF GRAPHICS");
        
        GraphicsCardProducer.getSemaphore().acquire();
        
        System.out.println("---------GRAPHICS CARD COUNTER BEFORE: " + GraphicsCardProducer.store_counter);
        GraphicsCardProducer.setStore_counter(GraphicsCardProducer.getStore_counter() - graphicCardsNeeded);
//        graphicsCardCounter++;
//        System.out.println("----------GRAPHICS COUNTER FROM ASSEMBLER: " + graphicsCardCounter);
        System.out.println("---------GRAPHICS CARD COUNTER AFTER: " + GraphicsCardProducer.store_counter);
        
        GraphicsCardProducer.getSemaphore().release();
        }
        
    }
    public void getPlaques() throws InterruptedException{
        
        if(PlaqueProducer.getStore_counter() >= plaques_needed){
        
        System.out.println("ASSEMBLER THREAD: " + Thread.currentThread().getName() + " TOOK CONTROL OF PLAQUE");
        
        PlaqueProducer.getSemaphore().acquire();
        
        System.out.println("---------PLAQUE COUNTER BEFORE: " + PlaqueProducer.store_counter);
        PlaqueProducer.setStore_counter(PlaqueProducer.getStore_counter() - plaques_needed);
//        plaque_counter++;
//        System.out.println("----------PLAQUE COUNTER FROM ASSEMBLER: " + plaque_counter);
        System.out.println("---------PLAQUE COUNTER AFTER: " + PlaqueProducer.store_counter);
        
        PlaqueProducer.getSemaphore().release();
        }
        
    }
    public void getPowerSupply() throws InterruptedException{
        
        if(PowerSupplyProducer.getStore_counter() >= power_supply_needed){
        
        System.out.println("ASSEMBLER THREAD: " + Thread.currentThread().getName() + " TOOK CONTROL OF PS");
        
        PowerSupplyProducer.getSemaphore().acquire();
        
        System.out.println("---------POWER SUPPLY COUNTER BEFORE: " + PowerSupplyProducer.store_counter);
        PowerSupplyProducer.setStore_counter(PowerSupplyProducer.getStore_counter() - power_supply_needed);
//        powerSupplyCounter++;
//        System.out.println("----------POWER SUPPLY COUNTER FROM ASSEMBLER: " + powerSupplyCounter);
        System.out.println("---------POWER SUPPLY COUNTER AFTER: " + PowerSupplyProducer.store_counter);
        
        RAMProducer.getSemaphore().release();
        }
        
    }
    
    public int graphicsComputerAssembly() throws InterruptedException{
//        
        if(RAMProducer.store_counter >= ram_needed && CPUProducer.store_counter >= cpu_needed && GraphicsCardProducer.store_counter >= graphicCardsNeeded && PlaqueProducer.store_counter >= plaques_needed && PowerSupplyProducer.store_counter >= power_supply_needed){
            
            getRAM();
            getCPU();
            getGraphicsCard();
            getPlaques();
            getPowerSupply();
            
            
        }
        
        
        return 1;
        
    }
    
    public synchronized int standardComputerAssembly() throws InterruptedException{
//        
        if(RAMProducer.store_counter >= ram_needed && CPUProducer.store_counter >= cpu_needed && PlaqueProducer.store_counter >= plaques_needed && PowerSupplyProducer.store_counter >= power_supply_needed){
//            6, 5, 3, 1, 5, 3, 1
            getRAM();
            getCPU();
            getPlaques();
            getPowerSupply();
        }
        
        
        return 1;
        
    }
    
    public void incrementStandardComputerCount() throws InterruptedException{
            
            mutex.acquire();
            Thread.sleep(sleep_time);  
            
            setStandardComputerCounter(getStandardComputerCounter() + 1);
            System.out.println("-----STANDARD COMPUTER COUNTER FROM ASSEMBLER-------: " + standardComputerCounter);
            
            SwingUtilities.invokeLater(() -> {
                standardComputerCounterDisplayer.setText(String.valueOf(standardComputerCounter));  
            });
            
            mutex.release();
       
    }
    public void incrementGraphicsComputerCount() throws InterruptedException{
            
            mutex.acquire();
            Thread.sleep(sleep_time);  
            
            setGraphicCardComputerCounter(getGraphicCardComputerCounter() + 1);
            
            SwingUtilities.invokeLater(() -> {
                graphicCardComputerCounterDisplayer.setText(String.valueOf(getGraphicCardComputerCounter()));  
            });
            
            mutex.release();
       
    }
        
    
    public void resetValues(){
        
        ram_needed = 0;
        cpu_needed = 0;
        plaques_needed = 0;
        power_supply_needed = 0;
        
    }
    
    @Override
    
    
public void run(){
        while(true){
            
            try {
                
                
//               
                standardComputerAssembly();
                incrementStandardComputerCount();
                System.out.println("thread with id "+ Thread.currentThread().getName() + " has the current stadard computer count: " + getStandardComputerCounter());
                
                
                if(standardComputerCounter == standardComputersNeeded || standardComputerCounter % standardComputersNeeded == 0){
                    //reset values, assemble computers with graphics cards and start count for regular computers again
                    //ASSEMBLE COMPUTER WITH GRAPHICS CARD
                    graphicsComputerAssembly();
                    incrementGraphicsComputerCount();
                    
                  
            }
                Thread.yield();
               


                System.out.println("Assembler checking for available resources...");

              
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Assembler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    
}
