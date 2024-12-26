/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex1;

/**
 *
 * @author pitch
 */
public class Main {

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("John Doe");
        p.setAge(25);

        System.out.println("This person's name is " + p.getName() + " and they are " + p.getAge() + " years old.");
    }
}
