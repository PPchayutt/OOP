/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pitch
 */
public abstract class Animal {

    private String name = "";
    private int power = 0;
    private int age = 0;

    public Animal() {
        this("", 0, 0);
    }

    public Animal(String name, int power, int age) {
        this.name = name;
        this.power = power;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Animal : name = " + name + ", power = " + power + ", age = " + age;
    }

    public boolean equals(Animal a) {
        return a.name.equals(getName()) && a.age == getAge();
    }

    public abstract void eat(Food f);
}
