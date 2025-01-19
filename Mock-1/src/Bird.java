/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pitch
 */
public abstract class Bird extends Animal implements Flyable {

    /**
     *
     * @param name
     * @param age
     */
    public Bird(String name, int age) {
        super(name, 150, age);
    }

    public abstract void wingAttack(Animal a);
}
