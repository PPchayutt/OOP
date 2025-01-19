/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pitch
 */
public class Owner {
    protected final String name;
    protected Animal animal;
    public Owner() {
        this("", null);
    }
    public Owner(String name) {
        this.name = name;
        this.animal = null;       
        
    }
    public Owner(Animal animal) {
        this.name = "";
        this.animal = animal;
    }
    public Owner(String name, Animal animal) {
        this.name = name;
        this.animal = animal;
    }
    public String getName() {
        return name;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    public Animal getAnimal() {
        return animal;
    }
    public void feedFood(Food f) {
        animal.setPower(animal.getPower() + f.getPower());
    }
    @Override
    public String toString() {
        return "Owner : name = " + this.getName() + ", Animal : name = " + animal.getName() + ", power = " + animal.getPower() + ", age = " + animal.getAge();
    }
    public void protectOwnerFrom(Animal a) {
        if(this.animal instanceof Dog) {
            ((Dog) this.animal).kick(a);
        } else if(this.animal instanceof Pigeous) {
            ((Pigeous)this.animal).wingAttack(a); 
        } 
    }
}