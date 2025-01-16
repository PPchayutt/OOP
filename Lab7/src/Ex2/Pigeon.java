/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex2;

/**
 *
 * @author pitch
 */
public class Pigeon extends Bird {

    private static int numberOfPigeon;

    public Pigeon() {
        this(0.0, 0.0, 0.0);
    }

    public Pigeon(double wingSize, double weight, double height) {
        super(wingSize, weight, height);
        numberOfPigeon++;
    }

    public void eat(String food) {
        if (food == "worm") {
            setWeight(getWeight() + 0.5);
        } else if (food == "seed") {
            setWeight(getWeight() + 0.2);
        } else {
            System.out.println("Pigeon can eat only worm and seed.");
        }
    }

    /**
     *
     */
    @Override
    public void fly() {
        if (getWeight() >= 5) {
            setWeight(getWeight() - 0.25);
            System.out.println("Fly Fly");
        } else {
            System.out.println("I’m hungry.");
        }
    }

    /**
     *
     */
    @Override
    public void landing() {
        if (getWeight() >= 5) {
            setWeight(getWeight() - 0.5);
            System.out.println("Landing");
        } else {
            System.out.println("I’m hungry.");
        }
    }

    /**
     *
     */
    @Override
    public void takeOff() {
        if (getWeight() >= 5) {
            setWeight(getWeight() - 0.5);
            System.out.println("Take Off");
        } else {
            System.out.println("I’m hungry.");
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Pigeon " + getWeight() + " kg and " + " " + getHeight() + " cm. There are "+ numberOfPigeon + " pigeons.";
    }
}
