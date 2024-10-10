/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerproducers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author davidmizrahi
 */
public class Assembler extends Thread {
    
    private static final int STANDARD_COMPUTERS_NEEDED = 5;
    private static final int GRAPHIC_CARD_COMPUTERS = 3;
    
    //COUNTERS
    private int standardComputerCounter;
    private int graphicCardComputerCounter;
    private int salary;
    private int sleep_time;
    private int ram_counter;
    private int cpu_counter;
    private int graphicsCardCounter;
    private int plaque_counter;
    private int powerSupplyCounter;
    
    //HARDWARE REQUIREMENTS
    private int ram_needed;
    private int cpu_needed;
    private int graphicCardsNeeded;
    private int plaques_needed;
    private int power_supply_needed;
    
    //Text Fields GUI
    private JTextField RAMProduced;
    private JTextField CPUProduced;
    private JTextField PowerSupplyProduced;
    private JTextField GraphicsCardProduced;
    private JTextField PlaquesProduced;
    
    
    public Assembler(){
        this.CPUProduced = new JTextField();
        this.GraphicsCardProduced = new JTextField();
        this.PlaquesProduced = new JTextField();
        this.PowerSupplyProduced = new JTextField();
        this.RAMProduced = new JTextField();
    }
    
    public Assembler(int salary, int sleep_time, int ram_needed, int cpu_needed, int graphicCardsNeeded, int plaques_needed, int power_supply_needed, int standardComputersNeeded, int graphicCardComputers){
        
        standardComputerCounter = 0;
        graphicCardComputerCounter = 0;
        this.salary = salary;
        this.sleep_time = sleep_time;
        
        //COUNTERS
        ram_counter = 0;
        cpu_counter = 0;
        graphicsCardCounter = 0;
        plaque_counter = 0;
        powerSupplyCounter = 0;
        
        //HARDWARE REQUIREMENTS
        this.ram_needed = ram_needed;
        this.cpu_needed = cpu_needed;
        this.graphicCardsNeeded = graphicCardsNeeded;
        this.plaques_needed = plaques_needed;
        this.power_supply_needed = power_supply_needed;
        
        //Initializa JTextField Variables
        this.CPUProduced = new JTextField();
        this.GraphicsCardProduced = new JTextField();
        this.PlaquesProduced = new JTextField();
        this.PowerSupplyProduced = new JTextField();
        this.RAMProduced = new JTextField();
        
    }

    public void setRAMProduced(JTextField RAMProduced) {
        this.RAMProduced = RAMProduced;
    }

    public void setCPUProduced(JTextField CPUProduced) {
        this.CPUProduced = CPUProduced;
    }

    public void setPowerSupplyProduced(JTextField PowerSupplyProduced) {
        this.PowerSupplyProduced = PowerSupplyProduced;
    }

    public void setGraphicsCardProduced(JTextField GraphicsCardProduced) {
        this.GraphicsCardProduced = GraphicsCardProduced;
    }

    public void setPlaquesProduced(JTextField PlaquesProduced) {
        this.PlaquesProduced = PlaquesProduced;
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
        
        System.out.println("Assembler took control");
        
        RAMProducer.getSemaphore().acquire();
        
        System.out.println("---------RAM COUNTER BEFORE: " + RAMProducer.store_counter);
        RAMProducer.setStore_counter(RAMProducer.getStore_counter() - 1);
        ram_counter++;
        System.out.println("---------RAM COUNTER AFTER: " + RAMProducer.store_counter);
        
        RAMProducer.getSemaphore().release();
        
    }
    public void getCPU() throws InterruptedException{
        
        System.out.println("Assembler took control");
        
        CPUProducer.getSemaphore().acquire();
        
        System.out.println("---------CPU COUNTER BEFORE: " + CPUProducer.store_counter);
        CPUProducer.setStore_counter(CPUProducer.getStore_counter() - 1);
        cpu_counter++;
        System.out.println("---------CPU COUNTER AFTER: " + CPUProducer.store_counter);
        
        CPUProducer.getSemaphore().release();
        
    }
    public void getGraphicsCard() throws InterruptedException{
        
        System.out.println("Assembler took control");
        
        GraphicsCardProducer.getSemaphore().acquire();
        
        System.out.println("---------GRAPHICS CARD COUNTER BEFORE: " + GraphicsCardProducer.store_counter);
        GraphicsCardProducer.setStore_counter(GraphicsCardProducer.getStore_counter() - 1);
        graphicsCardCounter++;
        System.out.println("---------GRAPHICS CARD COUNTER AFTER: " + GraphicsCardProducer.store_counter);
        
        GraphicsCardProducer.getSemaphore().release();
        
    }
    public void getPlaques() throws InterruptedException{
        
        System.out.println("Assembler took control");
        
        PlaqueProducer.getSemaphore().acquire();
        
        System.out.println("---------PLAQUE COUNTER BEFORE: " + PlaqueProducer.store_counter);
        PlaqueProducer.setStore_counter(PlaqueProducer.getStore_counter() - 1);
        plaque_counter++;
        System.out.println("---------PLAQUE COUNTER AFTER: " + PlaqueProducer.store_counter);
        
        PlaqueProducer.getSemaphore().release();
        
    }
    public void getPowerSupply() throws InterruptedException{
        
        System.out.println("Assembler took control");
        
        PowerSupplyProducer.getSemaphore().acquire();
        
        System.out.println("---------POWER SUPPLY COUNTER BEFORE: " + PowerSupplyProducer.store_counter);
        PowerSupplyProducer.setStore_counter(PowerSupplyProducer.getStore_counter() - 1);
        powerSupplyCounter++;
        System.out.println("---------POWER SUPPLY COUNTER AFTER: " + PowerSupplyProducer.store_counter);
        
        RAMProducer.getSemaphore().release();
        
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
        
        
        return (ram_counter == ram_needed && 
                cpu_counter == cpu_needed && 
                graphicsCardCounter == graphicCardsNeeded && 
                plaque_counter == plaques_needed && 
                powerSupplyCounter == power_supply_needed ? 1 : 0);
        
    }
    
    public int standardComputerAssembly() throws InterruptedException{
//        
        if(RAMProducer.store_counter >= ram_needed && CPUProducer.store_counter >= cpu_needed && PlaqueProducer.store_counter >= plaques_needed && PowerSupplyProducer.store_counter >= power_supply_needed){
            
            getRAM();
            getCPU();
            getPlaques();
            getPowerSupply();
             
        }
        
        return (ram_counter == ram_needed && 
                cpu_counter == cpu_needed &&                 
                plaque_counter == plaques_needed && 
                powerSupplyCounter == power_supply_needed ? 1 : 0);
        
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
                Thread.sleep(sleep_time);  
                RAMProduced.setText(Integer.toString(ram_counter));
                CPUProduced.setText(Integer.toString(cpu_counter));
                PowerSupplyProduced.setText(Integer.toString(powerSupplyCounter));
                GraphicsCardProduced.setText(Integer.toString(graphicsCardCounter));
                PlaquesProduced.setText(Integer.toString(plaque_counter));
                standardComputerCounter+= standardComputerAssembly();
                if(standardComputerCounter == STANDARD_COMPUTERS_NEEDED){
                    //reset values, assemble computers with graphics cards and start count for regular computers again
                    resetValues();
                    //ASSEMBLE COMPUTER WITH GRAPHICS CARD
                    graphicCardComputerCounter+= graphicsComputerAssembly();
                    
            }
                System.out.println("Assembler checking for available resources...");

              
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Assembler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
