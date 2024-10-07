/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerproducers;

/**
 *
 * @author juanm
 */
public class Director extends Thread{
    private int SalaryPerHour = 60;
    
    private int remainingDays;
    
    private int dayDuration;
    
    private int timeSpent;
    
    private Producer prod;
    
    private ProjectManager pm;
    
    
    
    public Director(ProjectManager pm){
        
        this.timeSpent = 0;
        
        this.pm = pm;
        
        this.remainingDays = pm.getRemainingDays();
        
    }

    public int getSalaryPerHour() {
        return SalaryPerHour;
    }

    public int getRemainingDays() {
        return remainingDays;
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public ProjectManager getPm() {
        return pm;
    }

    public void setSalaryPerHour(int SalaryPerHour) {
        this.SalaryPerHour = SalaryPerHour;
    }

    public void setRemainingDays(int remainingDays) {
        this.remainingDays = remainingDays;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public void setPm(ProjectManager pm) {
        this.pm = pm;
    }
    
    
    public void sendComputers() throws InterruptedException{
        
        if(remainingDays == 0){
            sleep(dayDuration);
            
        }
        
    }
    
}
