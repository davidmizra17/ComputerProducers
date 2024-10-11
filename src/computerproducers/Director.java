/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerproducers;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JTextField;

/**
 *
 * @author juanm
 */
public class Director extends Thread{
   
    private ProjectManager pm;
    private int daysRemaining;
    private final int payRate = 60;
    private boolean salaryDeducted = false;
    private Random random = new Random();
    private JTextField faultDisplay;
    private JTextField faultCounter;
    private JTextField remainingDays;
    private JTextField directorActivity;
    private int faultAccumulation;
    private int totalFaults;

    public Director(ProjectManager pm, int daysRemaining, JTextField faultDisplay, JTextField faultCounter, JTextField remainingDays, JTextField directorActivity) {
        this.pm = pm;
        this.daysRemaining = daysRemaining;
        this.faultDisplay = faultDisplay;
        this.faultCounter = faultCounter;
        this.remainingDays = remainingDays;
        this.directorActivity = directorActivity;
        this.faultAccumulation = 0;
        this.totalFaults = 0;
    }

    public void run() {
        while (daysRemaining > 0) {
            try {
                remainingDays.setText(Integer.toString(daysRemaining));
                System.out.println("Director trabajando en tareas administrativas.");
                directorActivity.setText("Director trabajando en tareas administrativas.");
                
                // Revisión aleatoria al PM
                int randomHour = random.nextInt(24); // Hora aleatoria del día
                Thread.sleep(randomHour * 24); // Espera hasta la hora aleatoria
                
                System.out.println("Director revisando al PM en la hora: " + randomHour);
                directorActivity.setText("Director revisando al PM en la hora: " + randomHour);
                monitorProjectManager(); // Revisa si el PM está viendo anime
                
                Thread.sleep(24 - randomHour); // Termina el día después de la revisión

                daysRemaining--; // Disminuye los días restantes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        remainingDays.setText(Integer.toString(daysRemaining));

        // Cuando el contador de días llega a 0, enviar computadoras
        System.out.println("Director enviando computadoras a las distribuidoras...");
        try {
            Thread.sleep(7000); // Simula las 24 horas para enviar las computadoras
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Reiniciar el contador de días
        resetDays();
    }

    private void monitorProjectManager() {
        try {
            System.out.println("Director observando al PM por 35 minutos...");
            Thread.sleep(3500); // Revisión de 35 minutos

            // Verificar si el PM está viendo anime (lógica a decidir según el estado del PM)
            if (pm.isWatchingAnime()) {
                System.out.println("Director ha descubierto al PM viendo anime. Descuento de $100.");
                faultAccumulation = pm.deductSalary(100); // Descuento de $100 del salario del PM
                faultDisplay.setText(String.valueOf(faultAccumulation));
                totalFaults+= 1;
                faultCounter.setText(String.valueOf(totalFaults));
                salaryDeducted = true;
                
            } else {
                System.out.println("El PM está trabajando. No se aplica descuento.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void resetDays() {
        System.out.println("Director reiniciando el contador de días restantes.");
        this.daysRemaining = daysRemaining; // Reiniciar a 30 días o cualquier cantidad definida
    }

    public int getPayForDay() {
        return 24 * payRate; // El director cobra $60 por hora
    }

    public boolean isSalaryDeducted() {
        return salaryDeducted;
    }
}

    

