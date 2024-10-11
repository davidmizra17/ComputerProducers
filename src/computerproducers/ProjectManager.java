/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerproducers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author davidmizrahi
 */
public class ProjectManager extends Thread{
    
    private int remainingDays;
    private int sleep_time; 
    private int accumulatedTime;
    private final int workHoursPerDay = 8;
    private final int animeAndWorkHours = 16;
    private final int payRate = 40;
    private boolean workingDayOver = false;
    private boolean watchingAnime = false;
    private int salaryDeduction;
    
    private JTextField DaysLeft;
    private JTextField activity;
    
    public ProjectManager(){
        this.DaysLeft = new JTextField();
    }
    
    public ProjectManager(int remainingDays, int sleep_time, JTextField PMActivity){
        
        this.remainingDays = remainingDays;
        this.sleep_time = sleep_time;
        
        this.DaysLeft = new JTextField();
        this.activity = PMActivity;
        this.salaryDeduction = 0;
        
    }

    public JTextField getActivity() {
        return activity;
    }

    public boolean isWorkingDayOver() {
        return workingDayOver;
    }

    public void setWorkingDayOver(boolean workingDayOver) {
        this.workingDayOver = workingDayOver;
    }

    public boolean isWatchingAnime() {
        return watchingAnime;
    }

    public void setWatchingAnime(boolean watchingAnime) {
        this.watchingAnime = watchingAnime;
    }
    
    public int deductSalary(int fault){
        salaryDeduction+= fault;
        return salaryDeduction;
    }
    

    public void setActivity(JTextField activity) {
        this.activity = activity;
    }
    
    public void setDaysLeft(JTextField DaysLeft) {
        this.DaysLeft = DaysLeft;
    }

    public JTextField getDaysLeft() {
        return DaysLeft;
    }

    public int getAccumulatedTime() {
        return accumulatedTime;
    }

    public void setAccumulatedTime(int accumulatedTime) {
        this.accumulatedTime = accumulatedTime;
    }
    
    
    public int getRemainingDays() {
        return remainingDays;
    }

    public int getSleep_time() {
        return sleep_time;
    }

    public void setRemainingDays(int remainingDays) {
        this.remainingDays = remainingDays;
    }

    public void setSleep_time(int sleep_time) {
        this.sleep_time = sleep_time;
    }
    
    public int getPayForDay() {
        return (workHoursPerDay + animeAndWorkHours) * payRate;
    }
    
    
    @Override
    public void run(){
        while(true){
//            if (getRemainingDays() >= 1) {
//                setRemainingDays(getRemainingDays() - 1);
//            }
            while (remainingDays > 0) {
                // Durante las primeras 16 horas: Ver anime y revisar el proyecto
//                SwingUtilities.invokeLater(() -> {
//                for (int i = 0; i < animeAndWorkHours * 2; i++) { // 16 horas en intervalos de 30 min (32 iteraciones)
//                    if (i % 2 == 0) { // 30 min viendo anime
//                        activity.setText("VIENDO ANIME");
//                        System.out.println("------------VIENDO ANIME EL PROJECT MANAGER-------------------");
//                    } else { // 30 min revisando proyecto
//                        activity.setText("TRABAJANDO");
//                        System.out.println("------------TRABAJANDOOOOO EL PROJECT MANAGER-------------------");
//                    }
//                }
//                });

                int accumulator = 0;
                while(accumulator < 32){
                    try {
                        Thread.sleep(3000);
                        activity.setText("VIENDO ANIME");
                        
                        setWatchingAnime(true);
                        Thread.sleep(3000);
                        
                        activity.setText("TRABAJANDO");
                        setWatchingAnime(false);
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                
                
                for (int i = 0; i < workHoursPerDay; i++) {
                    updateDaysRemaining();
                    try {
                        Thread.sleep((long) (24 * 0.0208)); // Simula una hora de trabajo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                remainingDays--; // Reduce un día
            }
            workingDayOver = true;
            //ESTADO: viendo anime
//                if(getAccumulatedTime() < getSixteenHourTimeLapse)
//                activity.setText("Viendo Anime");
//                Thread.sleep(sleep_time);
//                //ESTADO: trabajando
//                activity.setText("Trabajando");
//                remainingDays-= 1;
//                Thread.sleep(sleep_time);
DaysLeft.setText(Integer.toString(remainingDays));
            
            
        }
    }

    private void updateDaysRemaining() {
        System.out.println("PM actualizando días restantes: " + remainingDays);
    }
}

