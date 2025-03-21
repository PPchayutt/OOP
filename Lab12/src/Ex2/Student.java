/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex2;

/**
 *
 * @author OPTO
 */
import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private int id;
    private int money;

    public Student() {
        this("", 0, 0);
    }

    public Student(String name, int id, int money) {
        this.name = name;
        this.id = id;
        this.money = money;
    }

    public int getID() {
        return id;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }
}
