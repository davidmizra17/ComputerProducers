/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package computerproducers;

import static java.lang.Thread.MAX_PRIORITY;

/**
 *
 * @author davidmizrahi
 */
public class ComputerProducers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
            System.out.println("hello from main");
        
        
            RAMProducer rp_1 = new RAMProducer(40, 1000);
            RAMProducer rp_2 = new RAMProducer(40, 1000);
            RAMProducer rp_3 = new RAMProducer(40, 1000);
            RAMProducer rp_4 = new RAMProducer(40, 1000);
            RAMProducer rp_5 = new RAMProducer(40, 1000);
            RAMProducer rp_6 = new RAMProducer(40, 1000);
            RAMProducer rp_7 = new RAMProducer(40, 1000);
            RAMProducer rp_8 = new RAMProducer(40, 1000);
//            RAMProducer rp_9 = new RAMProducer(40, 1000);
//            RAMProducer rp_12 = new RAMProducer(40, 1000);
//            RAMProducer rp_13 = new RAMProducer(40, 1000);
//            RAMProducer rp_23 = new RAMProducer(40, 1000);
//            RAMProducer rp_33 = new RAMProducer(40, 1000);
//            RAMProducer rp_43 = new RAMProducer(40, 1000);
            
            Assembler assembler = new Assembler(45, 600);
            
            
            
            rp_1.start();
            rp_2.start();
            rp_3.start();
            rp_4.start();
            rp_5.start();
            rp_6.start();
            rp_7.start();
            assembler.start();
            rp_8.start();
//            rp_9.start();
//            rp_12.start();
//            rp_13.start();
//            rp_23.start();
//            rp_33.start();
//            rp_43.start();
            
            
        
    }
    
}
