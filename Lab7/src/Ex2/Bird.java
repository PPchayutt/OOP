/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex2;

/**
 *
 * @author pitch
 */
public abstract class Bird implements Flyable{

    private double wingSize;
    private double weight;
    private double height;

    public Bird() {
        this(0.0, 0.0, 0.0);
    }

    public Bird(double wingSize, double weight, double height) {
        this.wingSize = wingSize;
        this.weight = weight;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getWingSize() {
        return wingSize;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setWingSize(double wingSize) {
        this.wingSize = wingSize;
    }

    public void eat(double food) {
        if (food > 0) {
            weight += food;
        } else {
            System.out.println("Input cannot be negative number.");
        }
    }
}
