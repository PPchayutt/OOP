/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex4;

/**
 *
 * @author pitch
 */
public class Car extends Vehicle {

    private String typeEngine;

    public String getTypeEngine() {
        return typeEngine;
    }

    public void setCarInfo(int s, String t, String y) {
        setFuel(s);
        setTopSpeed(t);
        this.typeEngine = y;
    }

    public void setTypeEngine(String t) {
        this.typeEngine = t;
    }

    public void move() {
        if (getFuel() >= 50) {
            System.out.println("Move.");
            setFuel(getFuel()-50);
        } else {
            System.out.println("Please add fuel.");
        }
    }

    public void showCarInfo() {
        System.out.println("Car engine is " + typeEngine + ".");
        System.out.println("Fuel is " + getFuel() + " litre and Top Speed is " + getTopSpeed() + " m/s.");
    }
}
