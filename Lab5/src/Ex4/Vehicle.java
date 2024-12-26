/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex4;

/**
 *
 * @author pitch
 */
public class Vehicle {

    private int fuel;
    private String topSpeed;

    protected int getFuel() {
        return fuel;
    }

    protected String getTopSpeed() {
        return topSpeed;
    }

    protected void setFuel(int i) {
        this.fuel = i;
    }

    protected void setTopSpeed(String n) {
        this.topSpeed = n;
    }

    public void showInfo() {
        System.out.println("Fuel is " + fuel + " litre and Top Speed is " + topSpeed + "m/s.");
    }
}
