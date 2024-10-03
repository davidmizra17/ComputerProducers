/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerproducers;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davidmizrahi
 */
public class ProjectManager extends Thread{
    
    private int remainingDays;
    private int sleep_time; 
    
    public ProjectManager(int remainingDays, int sleep_time){
        
        this.remainingDays = remainingDays;
        this.sleep_time = sleep_time;
        
    }
    
    @Override
    public void run(){
        while(true){
            try {
                //ESTADO: viendo anime
                Thread.sleep(30);
                //ESTADO: trabajando
                remainingDays-= 1;
                Thread.sleep(30);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    
    //---------------------------------------------FIRST STAGE---------------------------------------------
    
//    Project Manager: Solo hay uno por cada compañía, y su trabajo es registrar  el paso de los días. 
//            Tiene acceso a un contador con los días restantes para la entrega de los computadores terminados. 
    
//    ---------------------------------------------SECOND STAGE---------------------------------------------
//            Sin embargo, al PM se le conoce por  su fanatismo al anime (Está al día con One Piece), 
//                    a tal punto que las  primeras 16 horas del día logra ver anime a escondidas. 
//                    Cada intervalo de  30 minutos ve anime, y los siguientes 30 minutos trabaja revisando el  avance del proyecto, 
//                    siguiendo el ciclo durante las primeras 16 horas del día.  
//                    Las últimas 8 horas del día las invierte cambiando el contador con los días  restantes para la entrega. 
//                    El PM cobra $40 la hora esté trabajando o esté  viendo anime.  
}
