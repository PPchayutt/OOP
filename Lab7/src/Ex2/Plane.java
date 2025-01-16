/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex2;

/**
 *
 * @author pitch
 */
public class Plane extends Vehicle implements Flyable {

    private String airline;
    private String boeing;
    private static final int MAX_FLYER = 2;

    public Plane() {
        this(0.0, "", "");
    }

    public Plane(double fuel, String airline, String boeing) {
        this.fuel = fuel;
        this.airline = airline;
        this.boeing = boeing;
    }

    public String getAirline() {
        return airline;
    }

    public String getBoeing() {
        return boeing;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setBoeing(String boeing) {
        this.boeing = boeing;
    }

    /**
     *
     */
    @Override
    public void fly() {
        if (fuel >= 20) {
            fuel -= 20;
            System.out.println("Plane Fly");
        } else {
            System.out.println("Fuel is nearly empty.");
        }
    }

    /**
     *
     */
    @Override
    public void honk() {
        System.out.println("Weeeeeee");
    }

    /**
     *
     */
    @Override
    public void landing() {
        if (fuel >= 10) {
            fuel -= 10;
            System.out.println("Plane Already to Landing");
        } else {
            System.out.println("Fuel is nearly empty.");
        }
    }

    /**
     *
     */
    @Override
    public void startEngine() {
        if (fuel >= 20) {
            fuel -= 20;
            System.out.println("Plane’s Engine starts");
        } else {
            System.out.println("Fuel is not enough.");
        }
    }

    /**
     *
     */
    @Override
    public void stopEngine() {
        System.out.println("Plane’s Engine stops");
    }

    /**
     *
     */
    @Override
    public void takeOff() {
        if (fuel >= 10) {
            fuel -= 10;
            System.out.println("Plane Already to Take Off");
        } else {
            System.out.println("Fuel is nearly empty.");
        }
    }
}
